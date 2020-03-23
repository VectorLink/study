package com.example.pattern.proxypattern;

/**
 * @author GM20170901
 * @date 2020/3/23 17:30
 */
public class AdminUser implements UserCanDo {
    @Override
    public String userCanDoSomething() {
        return "我是管理员，我可以干任何事情";
    }
}
