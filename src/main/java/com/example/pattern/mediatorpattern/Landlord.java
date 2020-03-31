package com.example.pattern.mediatorpattern;

/**
 * @author GM20170901
 * @date 2020/3/31 16:54
 */
public class Landlord extends BaseColleague {
    public Landlord( Mediator mediator,String name) {
        this.mediator=mediator;
        this.name=name;
        this.type=ColleagueType.LANDORD.getValue();
    }

    @Override
    void sendMessage(String content) {
        System.out.println(this.name+"只有三室一挺"+content);
        mediator.notifyOtherColleague(this,content);

    }

    @Override
    void acceptMessage(String content) {
        System.out.println("房东收到中介信息"+content);
    }
}
