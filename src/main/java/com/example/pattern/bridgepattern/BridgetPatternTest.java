package com.example.pattern.bridgepattern;

/**
 *
 *
 * 桥接模式
 * @author GM20170901
 * @date 2020/3/31 10:17
 */
public class BridgetPatternTest {
    public static void main(String[] args) {
        Software software=new Camera();
        Phone phone=new HuaWei(software);
        phone.run();
        System.out.println("<=================================>");
        software=new Message();
        phone=new Iphone(software);
        phone.run();

    }
}
