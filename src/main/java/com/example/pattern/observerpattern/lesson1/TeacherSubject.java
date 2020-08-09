package com.example.pattern.observerpattern.lesson1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
public class TeacherSubject extends Subject {

    String info;

    @Override
    public String getInfo() {
        return info;
    }

    @Override
    public void setInfo(String info) {
        this.info = info;
        this.notifyObserver();
    }

    private List<Observer> observers=new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        if (observers.indexOf(observer)<0){
            observers.add(observer);
        }
    }

    @Override
    public void notifyObserver() {
        observers.forEach(observer -> observer.update(info));
    }
}
