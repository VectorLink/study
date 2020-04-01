package com.example.pattern.adapterpattern;

/**
 * @author GM20170901
 * @date 2020/4/1 10:33
 */
public class ObjectAdapterMode implements Targetable {
    public ObjectAdapterMode(Adapter adapter) {
        this.adapter = adapter;
    }

    Adapter adapter;
    @Override
    public int V5() {
        return adapter.V220()/44;
    }
}
