package com.example.pattern.mediatorpattern;

/**
 * @author GM20170901
 * @date 2020/3/31 16:50
 */
public class Tenant extends BaseColleague {


    public Tenant(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
        this.type = ColleagueType.TENANT.getValue();
    }

    @Override
    public void sendMessage(String content) {
        System.out.println(this.name + "发布消息：" + content);
        mediator.notifyOtherColleague(this, content);
    }

    @Override
    void acceptMessage(String content) {
        System.out.println(this.name + ":" + "接收来自中介的消息："
                + content);
    }

}
