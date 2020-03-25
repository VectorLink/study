package com.example.pattern.proxypattern;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author GM20170901
 * @date 2020/3/24 16:29
 */
public class CglibDynamicProxy implements MethodInterceptor {

    public Object getProxyInstance(Class clazz){
        //1.创建工具类
        Enhancer enhancer=new Enhancer();
        //2.设置父类
        enhancer.setSuperclass(clazz);
        //3.设置回调函数
        enhancer.setCallback(this);
        //4.创建子类
        return enhancer.create();

    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println( getSomePrivateSomething());
        Object value=methodProxy.invokeSuper(o,objects);
        System.out.println(getSomeSomeDone());
        return value;
    }
    private String getSomePrivateSomething(){
        return "代理开始干某些私事----";
    }
    private String getSomeSomeDone(){
        return "代理干完所有事情了";
    }
}
