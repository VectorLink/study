package com.example.pattern.adapterpattern;

/**
 * @author GM20170901
 * @date 2020/4/1 10:36
 */
public class InterfaceAdapterMode implements Targetable,Adapterable {
    @Override
    public int V220() {
        return 220;
    }

    @Override
    public int V5() {
        return V220()/44;
    }
}
