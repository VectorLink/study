package com.example.nio.nettynew;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {
    public static void main(String[] args) throws FileNotFoundException {
        try (FileChannel fileChannel = new FileInputStream(new File("src/main/resources/FileChannelTest.txt")).getChannel()){
            ByteBuffer byteBuffer=ByteBuffer.allocate(8);

            while (true) {
                int data=  fileChannel.read(byteBuffer);
                byteBuffer.flip();
                if (data==-1){
                    break;
                }
                while (byteBuffer.hasRemaining()) {
                    byte b = byteBuffer.get();
                    System.out.println((char) b);
                }
                byteBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
