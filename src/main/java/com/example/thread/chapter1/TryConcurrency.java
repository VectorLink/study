package com.example.thread.chapter1;

public class TryConcurrency {
    public static void main(String[] args) {
        Thread thread=new Thread("mythread"){
            @Override
            public void run() {
                try {
                    System.out.println("测试一次");
                    Thread innerThread=new Thread(){
                        @Override
                        public void run() {
                            while (true){
                                System.out.println(" health check");
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }

                        }
                    };
                    innerThread.setDaemon(true);
                    innerThread.start();
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        thread.start();
        System.out.println(Thread.currentThread().getName()+ " 线程 done");
    }
}
