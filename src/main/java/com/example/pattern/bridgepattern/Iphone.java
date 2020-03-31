package com.example.pattern.bridgepattern;

/**
 * @author GM20170901
 * @date 2020/3/31 10:15
 */
public class Iphone extends Phone {
    public Iphone(Software software) {
        super(software);
    }

    @Override
    public void run() {
        System.out.println("iphone -run -software");
        getSoftware().run();
    }
}
