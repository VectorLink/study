package com.example.pattern.observerpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GM20170901
 * @date 2020/3/31 15:00
 */
public class TeacherSubject implements Subject {

    private List<Observer> observers=new ArrayList<Observer>();
    private String info;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        int i=observers.indexOf(observer);
        if (i>=0){
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {
        for (Observer observer:observers){
            observer.update();
        }
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
