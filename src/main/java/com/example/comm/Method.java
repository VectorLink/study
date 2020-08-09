package com.example.comm;

import java.lang.reflect.Constructor;

public class Method {

    public static void main(String args[]) throws  Exception{
        Class clazz=Class.forName("com.example.comm.Student");

        Student student1=(Student) clazz.newInstance();
        student1.setName("小李");
        System.out.println(student1.toString());

        Constructor constructor=clazz.getConstructor(String.class,String.class,Integer.class,Integer.class);
        Student student2= (Student) constructor.newInstance("小米","男",13,18);

        System.out.println(student2.toString());
    }
}

