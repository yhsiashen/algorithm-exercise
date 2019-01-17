package org.yuhang.concurrency.nio;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.util.concurrent.DefaultThreadFactory;

import java.net.InetSocketAddress;
import java.nio.channels.spi.SelectorProvider;
import java.util.concurrent.ThreadFactory;

/**  netty测试类
 * Created by chinalife on 2018/7/23.
 */
public class TestTCPNetty {

    public static void main(String[] args) {
        //服务启动器
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        //设置Boss线程池
        EventLoopGroup bossLoopGroup = new NioEventLoopGroup(1);
        //设置worker线程池
        ThreadFactory threadFactory = new DefaultThreadFactory("work thread pool");
        //得到cpu个数
        int processNum = Runtime.getRuntime().availableProcessors();
        System.out.println("cpu number = "+processNum);
        //根据cpu个数设置worker线程数
        EventLoopGroup workLoopGroup = new NioEventLoopGroup(processNum << 1,threadFactory, SelectorProvider.provider());
        serverBootstrap.group(bossLoopGroup,workLoopGroup);
        //======设置通道类型
        serverBootstrap.channel(NioServerSocketChannel.class);
        //======设置处理器
        serverBootstrap.childHandler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            public void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                //在socket channel pipeline中加入httphandler和编解码器
                nioSocketChannel.pipeline().addLast(new HttpResponseEncoder());
                nioSocketChannel.pipeline().addLast(new HttpRequestDecoder());
                nioSocketChannel.pipeline().addLast(new HttpServerCodec());
            }
        });

        serverBootstrap.option(ChannelOption.SO_BACKLOG,128);
        serverBootstrap.childOption(ChannelOption.SO_KEEPALIVE,true);
        serverBootstrap.bind((ChannelFuture) new InetSocketAddress("0.0.0.0",83));

    }
}
