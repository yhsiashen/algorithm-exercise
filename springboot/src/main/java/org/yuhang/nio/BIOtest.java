package org.yuhang.nio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by chinalife on 2018/7/17.
 */
public class BIOtest {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(81);
        try{
            while (true){
                //调用操作系统的accept方法
                Socket socket = serverSocket.accept();
//                Thread.sleep(3000);
                //获取输入/输出流处理信息
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                byte[] bytes = new byte[2048];
                int readLen;
                StringBuilder message = new StringBuilder();
//                socket.setSoTimeout(10);
                while ((readLen = inputStream.read(bytes,0,1024))!=-1){
                    message.append(new String(bytes,0,readLen));
                    if(message.indexOf("over")!=-1){
                        break;
                    }
                }
                System.out.println("服务端收到的消息为:"+message);
                outputStream.write("服务器返回信息:响应成功!".getBytes());
                inputStream.close();
                outputStream.close();
                socket.close();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            if(!serverSocket.isClosed()){
                serverSocket.close();
            }
        }
    }
}
