package com.example.pattern.mediatorpattern;

/**
 *中介者模式（Mediator Pattern）是用来降低多个对象和类之间的通信复杂性。这种模式提供了一个中介类，该类通常处理不同类之间的通信，并支持松耦合，使代码易于维护。中介者模式属于行为型模式。
 *
 *抽象中介者（Mediator）角色：它是中介者的接口，提供了合作者对象注册与转发合作者对象信息的抽象方法。
 *
 *
 *
 * 具体中介者（ConcreteMediator）角色：实现中介者接口，定义一个 List 来管理合作者对象，协调各个合作者角色之间的交互关系，因此它依赖于合作者角色。
 *
 * 抽象合作者类（Colleague）角色：定义合作者类的接口，保存中介者对象，提供合作者对象交互的抽象方法，实现所有相互影响的合作者类的公共功能。
 *
 *
 *
 * 具体合作者类（Concrete Colleague）角色：是抽象合作者类的实现者，当需要与其他合作者对象交互时，由中介者对象负责后续的交互。
 * @author GM20170901
 * @date 2020/3/31 16:45
 */
public class MediatorPatternTest {
        public static void main(String[] args) {
            Mediator mediator = new HouseMediator();
            BaseColleague dada = new Tenant(mediator,"租客达达");
            BaseColleague haha = new Tenant(mediator,"租客哈哈");

            BaseColleague gaga = new Landlord(mediator,"房东嘎嘎");
            BaseColleague hehe = new Landlord(mediator,"房东呵呵");

            mediator.addColleague(dada).addColleague(haha).addColleague(gaga).addColleague(hehe);

            dada.sendMessage("我要租两室一厅的房子");
            haha.sendMessage("我要租三室一厅的房子");

            gaga.sendMessage("我要出租两室一厅的房子");
            hehe.sendMessage("我要出租三室一厅的房子");

        }

}
