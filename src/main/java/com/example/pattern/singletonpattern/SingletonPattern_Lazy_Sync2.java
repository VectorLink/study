package com.example.pattern.singletonpattern;

/**
 * 单例模式-饥汉模式 双检索模式
 * @author GM20170901
 * @date 2020/3/23 14:33
 */
public class SingletonPattern_Lazy_Sync2 {
    private static volatile SingletonPattern_Lazy_Sync2 instance;
    private SingletonPattern_Lazy_Sync2() {
    }
    public static SingletonPattern_Lazy_Sync2 getInstance(){
        if (instance==null){
            synchronized (SingletonPattern_Lazy_Sync2.class){
                if (instance==null){
                    instance=new SingletonPattern_Lazy_Sync2();
                }
            }
        }
        return instance;
    }
}
