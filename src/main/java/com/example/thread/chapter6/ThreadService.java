package com.example.thread.chapter6;

public class ThreadService  {

    private Thread executeThread;
    private static boolean isFinished=false;
    public void execute( Runnable task){
        executeThread=new Thread(){
            @Override
            public void run() {
                Thread thread=new Thread(task);
                thread.setDaemon(true);
                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

    }
    public void shutdown(long mills){
        long currentTime=System.currentTimeMillis();
        while (!isFinished){
            if((System.currentTimeMillis()-currentTime)>mills){
                executeThread.interrupted();
                break;
            }
            try {
                executeThread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }

        }
    }
}
