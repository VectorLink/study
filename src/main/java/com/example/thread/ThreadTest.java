package com.example.thread;

/**
 * @author GM20170901
 * @date 2020/3/25 14:11
 */
public class ThreadTest  {
    public static void main(String[] args) {
        ThreadProduct product =new ThreadProduct();
        for ( int i=0;i<10;i++){
            Thread thread1=new Thread(product);
            thread1.start();

        }
    }
}
