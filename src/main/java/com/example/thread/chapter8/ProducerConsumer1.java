package com.example.thread.chapter8;

import java.util.stream.Stream;

public class ProducerConsumer1 {

    private static final Object LOCK = new Object();
    private static final Object ReadLock = new Object();

    private volatile int i = 0;
    private volatile boolean isProducer = false;

    public static void main(String[] args) {
        ProducerConsumer1 producerConsumer1 = new ProducerConsumer1();
        Stream.of("P1", "P2").forEach(n -> {
            new Thread(
                    () -> {
                        while (true) {
                            producerConsumer1.producer();
                            try {
                                Thread.sleep(100L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }, n
            ).start();
        });
        Stream.of("C1", "C2","C3","C4").forEach(n -> {
            new Thread(
                    () -> {
                        while (true) {
                            producerConsumer1.consumer();
                            try {
                                Thread.sleep(100L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }, n
            ).start();
        });
    }

    public void producer() {
        synchronized (LOCK) {
            if (isProducer) {
                try {
                    System.out.println(Thread.currentThread().getName() + "进入了wait==========");
                    LOCK.wait();
                    System.out.println("继续执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                i++;
                System.out.println(Thread.currentThread().getName() + "生产了产品" + i);
                isProducer = true;
                LOCK.notifyAll();
            }

        }
    }

    public void consumer() {
        synchronized (LOCK) {
            if (!isProducer) {
                try {
                    System.out.println(Thread.currentThread().getName() + "进入了wait==========");
                    LOCK.wait();
                    System.out.println("继续执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }else{

                System.out.println(Thread.currentThread().getName() + "消费了产品" + i);
                isProducer = false;
                LOCK.notifyAll();
            }

        }


    }
}
