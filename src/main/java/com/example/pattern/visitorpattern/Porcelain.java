package com.example.pattern.visitorpattern;

/**
 * @author GM20170901
 * @date 2020/3/31 10:31
 */
public class Porcelain implements Treasure {
    @Override
    public void accept(Visitor visitor) {
        System.out.println("瓷器");
        visitor.visit(this);
    }
}
