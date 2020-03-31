package com.example.pattern.statepattern;

/**
 * @author GM20170901
 * @date 2020/3/31 11:01
 */
public class SupervisorState extends State {
    @Override
    public void handle() {
        System.out.println("主管审批通过，下一个经理审批");
        context.setState(new ManagerState());
    }
}
