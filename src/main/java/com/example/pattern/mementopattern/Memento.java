package com.example.pattern.mementopattern;

/**
 * @author GM20170901
 * @date 2020/3/31 16:21
 */
public class Memento {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento(String state) {
        this.state = state;
    }
}
