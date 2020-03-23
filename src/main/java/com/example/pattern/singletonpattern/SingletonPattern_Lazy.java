package com.example.pattern.singletonpattern;

/**
 * 单例模式-懒汉模式
 * @author GM20170901
 * @date 2020/3/23 11:59
 */
public class SingletonPattern_Lazy {
    private static SingletonPattern_Lazy instance;
    //构造器私有化
    private SingletonPattern_Lazy() {
    }
    /* 静态工程方法，创建实例  缺点非线程安全*/
    public static SingletonPattern_Lazy getInstance(){
        if (instance==null){
            instance=new SingletonPattern_Lazy();
        }
        return instance;
    }

}
