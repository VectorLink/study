package com.example.pattern.proxypattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 * 1.代理对象,不需要实现接
 * 2.代理对象的生成,是利用JDK的API,动态的在内存中构建代理对象(需要我们指定创建代理对象/目标对象实现的接口的类型)
 * 3.动态代理也叫做:JDK代理,接口代理
 *
 *
 * @author GM20170901
 * @date 2020/3/23 17:42
 */
public class JdkDynamicProxy  {
    private Object target;
    public JdkDynamicProxy(Object target){
        this.target=target;
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println(   getSomePrivateSomething());
                        Object object=method.invoke(target,args);
                        System.out.println( getSomeSomeDone());
                        return object;
                    }
                });
    }


    private String getSomePrivateSomething(){
        return "代理开始干某些私事----";
    }
    private String getSomeSomeDone(){
        return "代理干完所有事情了";
    }

}
