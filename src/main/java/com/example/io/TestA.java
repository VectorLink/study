package com.example.io;

import java.util.HashSet;
import java.util.Set;

public class TestA {
    public static void main(String[] args) {
        Set<Integer> m=new HashSet<>();
        for (int i=0;i<100;i++){
            m.add(i);
            m.remove(i-1);
        }
        System.out.println(m.size());
    }
}
