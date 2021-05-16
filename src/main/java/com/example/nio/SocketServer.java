package com.example.nio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) throws IOException {
        System.out.println("服务端已启动----------->");
        ServerSocket serverSocket=new ServerSocket(9000);
        while (true){
            Socket clientSocket= serverSocket.accept();

            handleInfo(clientSocket);
        }
    }

    public static void handleInfo( Socket socket) throws IOException {
        byte[] bytes=new byte[1024];
        int read=socket.getInputStream().read(bytes);
        if (read!=-1){
            System.out.println( new String(bytes,0,read));
        }
    }
}
