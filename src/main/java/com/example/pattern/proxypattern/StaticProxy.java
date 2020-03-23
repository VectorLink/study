package com.example.pattern.proxypattern;

/**
 * 代理模式-静态代理
 * @author GM20170901
 * @date 2020/3/23 17:28
 */
public class StaticProxy implements UserCanDo{
    private UserCanDo userCanDo;

    public StaticProxy( UserCanDo userCanDo) {
        this.userCanDo=userCanDo;
    }

    @Override
    public String userCanDoSomething() {
        System.out.println(getSomePrivateSomething());
        System.out.println(userCanDo.userCanDoSomething());
        return getSomeSomeDone();
    }

    private String getSomePrivateSomething(){
        return "代理开始干某些私事----";
    }
    private String getSomeSomeDone(){
        return "代理干完所有事情了";
    }

}
