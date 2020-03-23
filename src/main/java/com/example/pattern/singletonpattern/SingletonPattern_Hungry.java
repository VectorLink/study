package com.example.pattern.singletonpattern;

/**
 * 单例模式-饥汉模式
 * @author GM20170901
 * @date 2020/3/23 14:25
 */
public class SingletonPattern_Hungry {
    private static  SingletonPattern_Hungry instance=new SingletonPattern_Hungry();
    //构造器私有化
    private SingletonPattern_Hungry() {
    }
    /* 静态工程方法，创建实例*/
    public static SingletonPattern_Hungry getInstance(){
        return  instance;
    }
}
