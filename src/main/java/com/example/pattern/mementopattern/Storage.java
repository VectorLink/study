package com.example.pattern.mementopattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GM20170901
 * @date 2020/3/31 16:26
 */
public class Storage {
    private List<Memento> mementoList=new ArrayList<>();
    public void add(Memento memento){
        mementoList.add(memento);
    }
    public Memento get(int index){
        if (index>=0){
            return mementoList.get(index);
        }
        return null;
    }
}
