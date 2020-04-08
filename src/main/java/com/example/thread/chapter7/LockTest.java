package com.example.thread.chapter7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;

public class LockTest {

    public static void main(String[] args) {
//        Test test=new Test();
//        new Thread(()->{
//            test.m1();
//        },"test1").start();
//        new Thread(()->{
//            test.m2();
//        },"test2").start();

        Class clazz=LockTest.class;


                Method[] methods= clazz.getDeclaredMethods();
                for (Method o :methods) {
                    try {
                        if (o.getName().equals("testMethod")){
                            try {
                                o.invoke(clazz.newInstance());
                            } catch (InstantiationException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }

        System.out.println("done");
    }
    public  void testMethod(){
        System.out.println("test");
    }




}
class Test{
    private static Object LOCK=new Object();

    public void m1(){
        synchronized (LOCK){
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void m2(){
        synchronized (LOCK){
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}