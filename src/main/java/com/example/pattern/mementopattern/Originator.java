package com.example.pattern.mementopattern;

/**
 * @author GM20170901
 * @date 2020/3/31 16:21
 */
public class Originator {
    private String state;

    public Memento saveStateMenmento(){
        return new Memento(state);
    }

    public void getStateFromMenmento(Memento memento){
        state=memento.getState();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
