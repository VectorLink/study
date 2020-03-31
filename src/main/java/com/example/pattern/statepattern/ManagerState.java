package com.example.pattern.statepattern;

/**
 * @author GM20170901
 * @date 2020/3/31 11:02
 */
public class ManagerState extends State {
    @Override
    public void handle() {
        System.out.println("经理审批，下一个总监审批");
        context.setState(new DirectorState());
    }
}
