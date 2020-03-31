package com.example.pattern.bridgepattern;

/**
 * @author GM20170901
 * @date 2020/3/31 10:11
 */
public abstract class Phone {
    private Software software;

    public Software getSoftware() {
        return software;
    }

    public void setSoftware(Software software) {
        this.software = software;
    }

    public Phone(Software software) {
        this.software = software;
    }
    public abstract  void run();
}
