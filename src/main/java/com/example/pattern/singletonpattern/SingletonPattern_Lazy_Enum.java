package com.example.pattern.singletonpattern;

import com.example.comm.Student;

/**
 * @author GM20170901
 * @date 2020/3/23 14:43
 */
public enum SingletonPattern_Lazy_Enum {
    /**
     * 单例模式-枚举实现（线程安全）
     * @date 2020/3/23 14:48
     * @return
     */
    INSTANCE;
    private Student student;
    SingletonPattern_Lazy_Enum(){
        student=new Student();
    }
    public Student getStudent(){
        return student;
    }
}
