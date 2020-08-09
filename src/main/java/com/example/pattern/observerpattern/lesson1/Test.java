package com.example.pattern.observerpattern.lesson1;

public class Test {
    public static void main(String[] args) {
        TeacherSubject subject=new TeacherSubject();
        Observer observer1=new StudentObserver(subject);
        Observer observer2=new StudentObserver(subject);
        subject.setInfo("布置作业");

    }
}
