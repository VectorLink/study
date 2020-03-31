package com.example.pattern.visitorpattern;




/**
 * @author GM20170901
 * @date 2020/3/31 10:27
 */
public class Bronze implements Treasure {
    @Override
    public void accept(Visitor visitor) {
        System.out.println("青铜器");
        visitor.visit(this);
    }
}
