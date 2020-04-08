package com.example.thread.chapter13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SimpleThreadPool {
    private final  int size;
    private final  static int DEFAULT_SIZE=10;
    private static volatile int seq=0;
    private static final String TREAD_PREFIX="SIMPLE_TREAD_POOLE";
    private static final ThreadGroup GROUP=new ThreadGroup("SIMPLE_GROUP");
    private final static LinkedList<Runnable> TASK_QUEUE=new LinkedList<>();
    private final static List<WorkerTask> TREAD_QUEUE=new ArrayList<>();

    public SimpleThreadPool() {
        this(DEFAULT_SIZE);
    }

    public SimpleThreadPool(int size) {
        this.size = size;
        init();
    }
    public void submit(Runnable task){
synchronized (TASK_QUEUE){
    TASK_QUEUE.addLast(task);
    TASK_QUEUE.notifyAll();
}
    }

    private void init() {
        for (int i = 0; i <size ; i++) {
            createWorkTask();
        }
    }
    private static class WorkerTask extends Thread{
        private volatile TaskState taskState=TaskState.FREE;
        public TaskState getTaskState(){
            return this.taskState;
        }
        public WorkerTask(ThreadGroup group,String name){
            super(group,name);
        }
        public void close(){
            this.taskState=TaskState.DEAD;
        }
        @Override
        public void run(){
            OUTER:
            while (this.taskState!=TaskState.DEAD){
                Runnable runnable;
                synchronized (TASK_QUEUE){
                    while (TASK_QUEUE.isEmpty()){
                        try {
                            taskState=TaskState.BLOCK;
                            TASK_QUEUE.wait();
                        } catch (InterruptedException e) {
                           break OUTER;
                        }
                    }
                }
                runnable=TASK_QUEUE.removeFirst();
                if (null!=runnable){
                    taskState=TaskState.RUNNING;
                    runnable.run();
                    taskState=TaskState.FREE;
                }
            }
        }

    }
    private void createWorkTask(){
        WorkerTask workerTask=new WorkerTask(GROUP,TREAD_PREFIX+(seq++));
        workerTask.start();
        TREAD_QUEUE.add(workerTask);

    }
    private enum  TaskState{
        FREE,BLOCK,RUNNING,DEAD
    }

    public static void main(String[] args) {
        SimpleThreadPool simpleThreadPool=new SimpleThreadPool();
        for (int i = 0; i <40 ; i++) {
            simpleThreadPool.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName()+"正在办事");
                        Thread.sleep(10_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"办完事情");
                }
            });
        }
    }
}
