package com.example.pattern.statepattern;

/**
 * @author GM20170901
 * @date 2020/3/31 10:58
 */
public class Context {
    private State state;

    public Context() {
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
        state.setContext(this);
    }
    public void request(){
        this.state.handle();
    }
}
