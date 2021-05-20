package com.example.nio.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossGroup=new NioEventLoopGroup();
        EventLoopGroup workerGroup=new NioEventLoopGroup();
        ServerBootstrap serverBootstrap=new ServerBootstrap();
        try {
            serverBootstrap.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new BusinessHandler());
                }
            }).childOption(ChannelOption.SO_KEEPALIVE,true).option(ChannelOption.SO_BACKLOG,128);

            ChannelFuture channelFuture=serverBootstrap.bind(9000).sync();

            channelFuture.channel().closeFuture().sync();
        }catch (Exception e){

        }finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }



    }
}
