package com.example.pattern.observerpattern.lesson1;

/**
 * @author Administrator
 */
public abstract class Subject {
    String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    abstract void addObserver(Observer observer);
    abstract void  notifyObserver();
}
