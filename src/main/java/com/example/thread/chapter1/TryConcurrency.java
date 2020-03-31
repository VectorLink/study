package com.example.thread.chapter1;

public class TryConcurrency {
    public static void main(String[] args) {
        Thread thread=new Thread(){
            @Override
            public void run() {
                System.out.println("测试一次");
            }
        };
        thread.start();
    }
}
