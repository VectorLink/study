package com.example.pattern.observerpattern;





/**
 * @author GM20170901
 * @date 2020/3/31 14:25
 */
public interface Subject {
    void addObserver(Observer observer);
    void deleteObserver(Observer observer);
    void notifyObserver();
}
