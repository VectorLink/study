package com.example.pattern.adapterpattern;

/**
 * 适配器模式（Adapter Pattern）是作为两个不兼容的接口之间的桥梁。这种类型的设计模式属于结构型模式，它结合了两个独立接口的功能。适配器模式有三种：类适配器、对象适配器、接口适配器
 * 主要解决在软件系统中，常常要将一些"现存的对象"放到新的环境中，而新环境要求的接口是现对象不能满足的。
 * 目标（Target）接口：当前系统业务所期待的接口，它可以是抽象类或接口。
 *
 * 适配者（Adaptee）类：它是被访问和适配的现存组件库中的组件接口。
 *
 * 适配器（Adapter）类：它是一个转换器，通过继承或引用适配者的对象，把适配者接口转换成目标接口，让客户按目标接口的格式访问适配者。
 * @author GM20170901
 * @date 2020/4/1 10:30
 */
public class AdapterPatternTest {
    public static void main(String[] args) {

        InterfaceAdapterMode mode=new InterfaceAdapterMode();
        System.out.println(mode.V5());
    }
}
