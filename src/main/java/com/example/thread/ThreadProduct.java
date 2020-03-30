package com.example.thread;

/**
 * @author GM20170901
 * @date 2020/3/25 11:52
 */
public class ThreadProduct implements Runnable {

    private int num;
    @Override
    public void run() {

        synchronized (this) {
            try {
                num++;
                System.out.println("数据增加了：" + num);
                System.out.println("执行线程为" + Thread.currentThread().getName());
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
