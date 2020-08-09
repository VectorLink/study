package com.example.pattern.visitorpattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author GM20170901
 * @date 2020/3/31 10:34
 */
@Slf4j
public class AmericanVisitor implements Visitor {
    @Override
    public void visit(Treasure treasure) {
        System.out.println("美国游客--visiting");
        log.info("llll");
    }
}
