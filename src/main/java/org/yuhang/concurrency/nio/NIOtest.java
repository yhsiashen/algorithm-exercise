package org.yuhang.concurrency.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**  多路复用IO的server端实现
 * Created by chinalife on 2018/7/19.
 */
public class NIOtest {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.setReuseAddress(true);
        serverSocket.bind(new InetSocketAddress(81));
        //生成多路复用选择器
        Selector selector = Selector.open();
        //在选择器上注册通道
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        try{
            while (true){
                if(selector.select(100) == 0){

                     continue;
                }
                //取selector的key集合并遍历, selectkey-channel的set集合
                Iterator<SelectionKey> keysIterator = selector.selectedKeys().iterator();
                while (keysIterator.hasNext()){
                    SelectionKey selectionKey = keysIterator.next();
                    keysIterator.remove();
                    SelectableChannel selectableChannel = selectionKey.channel();
                    //selectkey是有效的且通道已准备好
                    if(selectionKey.isValid() && selectionKey.isAcceptable()){
                        System.out.println("====channel通道已准备好====");
                        //将selectableChannel转化为针对tcp的serverSocketChannel
                        ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel)selectableChannel;
                        serverSocketChannel1.configureBlocking(false);
                        //将serverSocketChannel注册到selector,仅可注册三种感兴趣的事件:
                        //SelectionKey.OP_ACCEPT，SelectionKey.OP_WRITE,SelectionKey.OP_CONNECT
                        serverSocketChannel1.register(selector, SelectionKey.OP_ACCEPT);
                    }else if(selectionKey.isValid() && selectionKey.isConnectable()){
                        System.out.println("====socketchannel建立连接====");
                    }else if(selectionKey.isValid() && selectionKey.isReadable()){
                        System.out.println("====socketchannel数据准备完成，可以读数");
                        readSocketChannel(selectionKey);
                    }
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * 读取客户端的socket数据
     * @throws Exception
     */
    private static void readSocketChannel(SelectionKey selectionKey) throws Exception{
        //获取客户端的socketchannel
        SocketChannel clientSocketChannel = (SocketChannel) selectionKey.channel();
        //拿到客户端的端口
        InetSocketAddress inetSocketAddress = (InetSocketAddress)clientSocketChannel.getRemoteAddress();
        Integer clientPort = inetSocketAddress.getPort();
        //获取socketchannel的缓冲区buffer,主要概念是capacity,position,limit
        ByteBuffer byteBuffer = (ByteBuffer) selectionKey.attachment();
        //将通道的数据写入buffer
        int realLen;
        try{
            realLen = clientSocketChannel.read(byteBuffer);
        }catch (Exception e){
            clientSocketChannel.close();
            return;
        }
        if(realLen == -1){
            System.out.println("buffer区没数据");
            return;
        }
        byteBuffer.flip();
        byte[] messageBytes = byteBuffer.array();
        //将buffer中的数据编码
        String messageEncode = new String(messageBytes,"UTF-8");
        String message = URLDecoder.decode(messageEncode,"UTF-8");
        //若接收到over字段，则结束这次请求；若没有，则继续等待接收
        if(!message.contains("over")){
            System.out.println("本次请求结束!,从端口:"+clientPort+"接收到的信息为:"+message);
            //清空buffer中已经读取的数据，并切换buffer为写状态
            byteBuffer.clear();
            //返回响应数据-buffer，并关闭channel
            ByteBuffer responseBuffer = ByteBuffer.wrap(URLEncoder.encode("服务端响应成功！","UTF-8").getBytes());
            clientSocketChannel.write(responseBuffer);
            clientSocketChannel.close();
        }else {
            System.out.println("继续接收请求内容...");
            byteBuffer.position(realLen);
            byteBuffer.limit(byteBuffer.capacity());
        }


    }
}
