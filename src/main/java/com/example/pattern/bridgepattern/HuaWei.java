package com.example.pattern.bridgepattern;

/**
 * @author GM20170901
 * @date 2020/3/31 10:14
 */
public class HuaWei extends Phone {
    public HuaWei(Software software) {
        super(software);
    }

    @Override
    public void run() {
        System.out.println("huawei run software");
        getSoftware().run();
    }
}
