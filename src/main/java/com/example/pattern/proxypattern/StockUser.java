package com.example.pattern.proxypattern;

/**
 * @author GM20170901
 * @date 2020/3/23 17:31
 */
public class StockUser implements UserCanDo {
    @Override
    public String userCanDoSomething() {
        return "我是采购商，我可以干采购的事情";
    }
}
