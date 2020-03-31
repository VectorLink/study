package com.example.pattern.visitorpattern;




/**
 * @author GM20170901
 * @date 2020/3/31 10:26
 */
public interface Treasure {
    void accept(Visitor visitor);
}
