package com.example.pattern.observerpattern.lesson1;

public class StudentObserver implements Observer {

    private Subject subject;

    public StudentObserver( Subject subject){
        this.subject=subject;
        subject.addObserver(this);
    }

    @Override
    public void update(String message) {
        System.out.println("收到了来自"+subject.getInfo());
    }
}
