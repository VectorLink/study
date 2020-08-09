package com.example.comm;

import java.util.concurrent.locks.ReentrantLock;

public class MethodTest1 {
    public static void main(String[] args) {
        Thread thread1=new Thread(()->{
            System.out.println("线程1正在执行");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2=new Thread(()->{
            try {
                thread1.join();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程2正在执行");
        });
        Thread thread3=new Thread(()->{
            try {
                thread2.join();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程3正在执行");
        });
        thread3.start();
        thread2.start();
        thread1.start();
        System.out.println("main thread is over");

    }
}
