package com.example.pattern.observerpattern;

/**
 * 观察者模式（又被称为发布-订阅（Publish/Subscribe）模式，属于行为型模式的一种，它定义了一种一对多的依赖关系，让多个观察者对象同时监听某一个主题对象。这个主题对象在状态变化时，会通知所有的观察者对象，使他们能够自动更新自己
 * 观察者模式四大角色
 * Subject：抽象主题（抽象被观察者），抽象主题角色把所有观察者对象保存在一个集合里，每个主题都可以有任意数量的观察者，抽象主题提供新增、删除、通知观察者的方法。
 * ConcreteSubject：具体主题（具体被观察者），该角色将有关状态存入具体观察者对象，在具体主题的内部状态发生改变时，给所有注册过的观察者发送通知。
 * Observer：抽象观察者，是观察者者的抽象类，它定义了一个更新接口，使得在得到主题更改通知时更新自己。
 * ConcrereObserver：具体观察者，实现抽象观察者定义的更新接口，以便在得到主题更改通知时更新
 * @author GM20170901
 * @date 2020/3/31 14:22
 */
public class ObserverPatternTest  {
    public static void main(String[] args) {
        TeacherSubject subject=new TeacherSubject();
        StudentObserver vector=new StudentObserver(subject,"vector");
        StudentObserver link=new StudentObserver(subject,"link");
        subject.setInfo("布置家庭作业：语文");
        subject.notifyObserver();

        subject.setInfo("布置家庭作业：数学");
        subject.notifyObserver();

        subject.setInfo("布置家庭作业：英语");
        subject.notifyObserver();
    }
}
