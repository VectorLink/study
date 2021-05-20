package com.example.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioSelectorSokectServer {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //启动NIO服务单，并绑定到9000，设置为非阻塞
        serverSocketChannel.socket().bind(new InetSocketAddress(9000));
        serverSocketChannel.configureBlocking(false);
        //实例化selector，底层调用epoll create函数创建文件描述符
        Selector selector = Selector.open();
        //将服务端注册到selector中，底层调用 epoll ctl 函数控制（add ,modify ,remove ）
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务端启动成功---");
        while (true) {
            //阻塞获取对应的事件信息，底层调用epoll wait 函数，监听遍历事件
            selector.select();
            //获取到对应的响应事件信息
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            //遍历事件信息
            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                //链接事件(只有服务端才会发生的注册事件，这时候需要将服务端里面获取对应的对应的客户端channel，并设置为非阻塞，注册到selector中)
                if (selectionKey.isAcceptable()) {
                     ServerSocketChannel realServerSocketChannel = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel socketChannel = realServerSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                    System.out.println("客户端注册成功");
                    //读事件，client中链接事件，获取对应的客户端channel，读取对应的事件处理对应的业务
                } else if (selectionKey.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(128);
                    int length = socketChannel.read(byteBuffer);
                    if (length > 0) {
                        //获取到客户端的信息
                        System.out.println(new String(byteBuffer.array()));
                    } else if (length == -1) {
                        //如果没有获取到信息，那就关闭链接
                        socketChannel.close();
                        System.out.println("关闭客户端链接成功");
                    }
                }
                //移除已经处理的事件
                iterator.remove();
            }

        }
    }
}
