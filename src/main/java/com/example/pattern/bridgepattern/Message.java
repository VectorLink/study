package com.example.pattern.bridgepattern;

/**
 * @author GM20170901
 * @date 2020/3/31 10:10
 */
public class Message implements Software {
    @Override
    public void run() {
        System.out.println("software----->Message");
    }
}
