package com.example.pattern.statepattern;

/**
 * @author GM20170901
 * @date 2020/3/31 11:03
 */
public class DirectorState extends State {
    @Override
    public void handle() {
        System.out.println("总监审批通过，最后一个审批");
        System.out.println("<==========================>");
        System.out.println("处理完成");
    }
}
