package com.example.pattern.visitorpattern;

/**
 * @author GM20170901
 * @date 2020/3/31 10:34
 */
public class AmericanVisitor implements Visitor {
    @Override
    public void visit(Treasure treasure) {
        System.out.println("美国游客--visiting");
    }
}
