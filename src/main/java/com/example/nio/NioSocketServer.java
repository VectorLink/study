package com.example.nio;

import org.apache.commons.lang3.ArrayUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.*;

public class NioSocketServer {

    public static List<SocketChannel> socketChannels=new LinkedList<>();
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
        //绑定监听端口
        serverSocketChannel.socket().bind(new InetSocketAddress(9000));
        //配置服务端为非阻塞
        serverSocketChannel.configureBlocking(false);
        System.out.println("服务已启动");
        while (true){
            SocketChannel socketChannel= serverSocketChannel.accept();
            if (Objects.nonNull(socketChannel)) {
                //配置客户端为非阻塞
                socketChannel.configureBlocking(false);
                socketChannels.add(socketChannel);
            }
            Iterator<SocketChannel> iterator= socketChannels.iterator();
            if (iterator.hasNext()){
                System.out.println("处理链接");
                SocketChannel innerSocketChannel=iterator.next();
                ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
                int data= innerSocketChannel.read(byteBuffer);
                if (data>0){
                    System.out.println(new String(byteBuffer.array()));
                }else {
                    iterator.remove();
                    System.out.println("==================");
                }
            }

        }

    }
}
