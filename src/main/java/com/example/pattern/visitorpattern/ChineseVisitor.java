package com.example.pattern.visitorpattern;

/**
 * @author GM20170901
 * @date 2020/3/31 10:33
 */
public class ChineseVisitor implements Visitor {
    @Override
    public void visit(Treasure treasure) {
        System.out.println("中国游客--visiting");
    }
}
