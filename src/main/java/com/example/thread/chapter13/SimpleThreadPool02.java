package com.example.thread.chapter13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SimpleThreadPool02 {
    private final int size;
    private final int queueSize;
    private final static int DEFAULT_SIZE = 10;
    private final static int DEFAULT_TASK_QUEUE_SIZE = 2000;
    private static volatile int seq = 0;
    private static final String TREAD_PREFIX = "SIMPLE_TREAD_POOLE_";
    private static final ThreadGroup GROUP = new ThreadGroup("SIMPLE_GROUP");
    private final static LinkedList<Runnable> TASK_QUEUE = new LinkedList<>();
    private final static List<WorkerTask> TREAD_QUEUE = new ArrayList<>();
    private final DiscardPolicy discardPolicy;
    private  volatile boolean destroy=false;
    public final static DiscardPolicy DEFAULT_DISCARD_POLICY = () -> {
        throw new DiscardException("Discard the task !!!");
    };

    public SimpleThreadPool02() {
        this(DEFAULT_SIZE, DEFAULT_TASK_QUEUE_SIZE, DEFAULT_DISCARD_POLICY
        );
    }

    public SimpleThreadPool02(int size, int queueSize, DiscardPolicy policy) {
        this.size = size;
        this.queueSize = queueSize;
        this.discardPolicy = policy;
        init();
    }

    public void submit(Runnable task) {
        if (destroy){
            throw new IllegalStateException("the simple thread pool has been closed");
        }

        if (TASK_QUEUE.size()>queueSize) {
            discardPolicy.discard();
        }
        synchronized (TASK_QUEUE) {
            TASK_QUEUE.addLast(task);
            TASK_QUEUE.notifyAll();
        }
    }

    private void init() {
        for (int i = 0; i < size; i++) {
            createWorkTask();
        }
    }

    private static class WorkerTask extends Thread {
        private volatile TaskState taskState = TaskState.FREE;

        public TaskState getTaskState() {
            return this.taskState;
        }

        public WorkerTask(ThreadGroup group, String name) {
            super(group, name);
        }

        public void close() {
            this.taskState = TaskState.DEAD;
        }

        @Override
        public void run() {
            OUTER:
            while (this.taskState != TaskState.DEAD) {
                Runnable runnable;
                synchronized (TASK_QUEUE) {
                    while (TASK_QUEUE.isEmpty()) {
                        try {
                            taskState = TaskState.BLOCK;
                            TASK_QUEUE.wait();
                        } catch (InterruptedException e) {
                            break OUTER;
                        }
                    }
                    runnable = TASK_QUEUE.removeFirst();
                }

                if (null != runnable) {
                    taskState = TaskState.RUNNING;
                    runnable.run();
                    taskState = TaskState.FREE;
                }
            }
        }

    }

    private void createWorkTask() {
        WorkerTask workerTask = new WorkerTask(GROUP, TREAD_PREFIX + (seq++));
        workerTask.start();
        TREAD_QUEUE.add(workerTask);

    }
    public void shutdown() throws InterruptedException {
        System.out.println(TASK_QUEUE.size());
        while (!TASK_QUEUE.isEmpty()){
            Thread.sleep(100L);
        }
        int active=TREAD_QUEUE.size();
        while (active>0){
            for (WorkerTask task:TREAD_QUEUE){
                if (task.getTaskState()==TaskState.BLOCK){
                    task.interrupt();
                    task.close();
                    active--;
                }else {
                    Thread.sleep(100);
                }
            }
        }
        destroy=true;
        System.out.println("the simple thread pool disposed");

    }

    public boolean isDestroy(){
        return this.destroy;
    }

    public int getSize() {
        return size;
    }

    public int getQueueSize() {
        return queueSize;
    }

    private enum TaskState {
        FREE, BLOCK, RUNNING, DEAD
    }

    public static class DiscardException extends RuntimeException {
        public DiscardException(String message) {
            super(message);
        }
    }

    public interface DiscardPolicy {
        public void discard() throws DiscardException;
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleThreadPool02 simpleThreadPool = new SimpleThreadPool02();
        for (int i = 0; i < 40; i++) {
            System.out.println(i);
            simpleThreadPool.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + "正在办事");
                        Thread.sleep(5_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "办完事情");
                }
            });
        }
        Thread.sleep(10_000L);
        System.out.println("=========>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        simpleThreadPool.shutdown();
        System.out.println("=========");
    }
}
