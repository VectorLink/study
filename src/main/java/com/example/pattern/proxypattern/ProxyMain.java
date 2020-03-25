package com.example.pattern.proxypattern;

/**
 * @author GM20170901
 * @date 2020/3/23 17:37
 */
public class ProxyMain {
    public static void main(String[] args) {
//        静态代理测试
//        UserCanDo userCanDo=new ProviderUser();
//        UserCanDo proxy=new StaticProxy(userCanDo);
//        System.out.println(proxy.userCanDoSomething());

//        //jdk动态代理
//        UserCanDo userCanDo=new ProviderUser();
//        UserCanDo canDo=(UserCanDo) new JdkDynamicProxy(userCanDo).getProxyInstance();
//        System.out.println(canDo.userCanDoSomething());
        //cglib动态代理
//        CglibDynamicProxy dynamicProxy=new CglibDynamicProxy();
//        StockUser userCanDo=(StockUser)(dynamicProxy.getProxyInstance(StockUser.class));
//        System.out.println(userCanDo.getInfo());

    }
}
