package com.example.pattern.singletonpattern;

/**
 * @author GM20170901
 * @date 2020/3/23 14:53
 */
public class SingeltonPattern_Lazy_InnerClass {
    //由静态内部内进行变量选择
    private SingeltonPattern_Lazy_InnerClass(){

    }
    public static  SingeltonPattern_Lazy_InnerClass getInstance(){
        return InnerClass.instance;
    }

    static class InnerClass{
        private static SingeltonPattern_Lazy_InnerClass instance;
        static {
            instance=new SingeltonPattern_Lazy_InnerClass();
        }
    }
}
