package com.example.pattern.statepattern;

/**
 * @author GM20170901
 * @date 2020/3/31 10:58
 */
public abstract class State {
    protected Context context;
    public abstract void handle();
    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
