package com.example.pattern.visitorpattern;

/**
 *
 * 访问者模式
 * @author GM20170901
 * @date 2020/3/31 10:23
 */
public class VisitorPatternTest {
    public static void main(String[] args) {
        Treasure treasure=new Bronze();
        Treasure treasure1=new Porcelain();
        Visitor chinese=new ChineseVisitor();
        Visitor american=new AmericanVisitor();


        treasure.accept(chinese);
        treasure.accept(american);
        treasure1.accept(chinese);
        treasure1.accept(american);
    }
}
