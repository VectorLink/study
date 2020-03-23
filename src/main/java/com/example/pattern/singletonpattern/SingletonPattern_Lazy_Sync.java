package com.example.pattern.singletonpattern;

/**
 * 单例模式-饥汉模式 加入同步模块
 * @author GM20170901
 * @date 2020/3/23 14:29
 */
public class SingletonPattern_Lazy_Sync {
    private static SingletonPattern_Lazy_Sync instance=null;

    private SingletonPattern_Lazy_Sync() {
    }
    //对整个方法加锁，只能单个线程进行访问；但是效率很低，
    public static synchronized SingletonPattern_Lazy_Sync getInstance(){
        if (instance==null){
            instance=new SingletonPattern_Lazy_Sync();
        }
        return instance;
    }
}
