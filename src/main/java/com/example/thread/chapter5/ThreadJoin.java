package com.example.thread.chapter5;

import java.util.stream.IntStream;

public class ThreadJoin {
    public static void main(String[] args) {
        Thread thread=new Thread(()->{
            IntStream.range(1,1000).forEach(
                    i-> System.out.println(Thread.currentThread().getName()+"i"));
        });
        thread.start();
    }
}
