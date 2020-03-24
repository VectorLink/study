package com.example.pattern.proxypattern;

/**
 * @author GM20170901
 * @date 2020/3/24 16:36
 */
public class ProviderUser implements UserCanDo {

@Override
    public String userCanDoSomething(){
        return "我是供应商用户角色，为人们提供商品";
    }
}
