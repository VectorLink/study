package com.example.pattern.mementopattern;

/**
 * 备忘录模式（Memento Pattern）模式的定义：在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态，以便以后当需要时能将该对象恢复到原先保存的状态。该模式又叫快照模式，备忘录模式属于行为型模式。
 *
 * 发起人（Originator）角色：记录当前时刻的内部状态信息，提供创建备忘录和恢复备忘录数据的功能，实现其他业务功能，它可以访问备忘录里的所有信息。
 * 备忘录（Memento）角色：负责存储发起人的内部状态，在需要的时候提供这些内部状态给发起人。
 * 管理者（Caretaker）角色：对备忘录进行管理，提供保存与获取备忘录的功能，但其不能对备忘录的内容进行访问与修改。
 * @author GM20170901
 * @date 2020/3/31 16:14
 */
public class MementoPatternTest {
    public static void main(String[] args) {
    Originator originator=new Originator();
    Storage storage=new Storage();
    originator.setState("状态： A");
    storage.add(originator.saveStateMenmento());
        originator.setState("状态： B");
        storage.add(originator.saveStateMenmento());
        originator.setState("状态： C");
        storage.add(originator.saveStateMenmento());
        originator.setState("状态： D");
        storage.add(originator.saveStateMenmento());
        System.out.println("当前状态为：" +originator.getState());
        System.out.println("回到状态2");
        originator.getStateFromMenmento(storage.get(1));
        System.out.println(originator.getState());

    }
}
