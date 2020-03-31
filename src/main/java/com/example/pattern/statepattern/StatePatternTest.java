package com.example.pattern.statepattern;

/**
 *
 * 状态模式
 * 优点：封装了转换规则。枚举可能的状态，在枚举状态之前需要确定状态种类。允许状态转换逻辑与状态对象合成一体，而不是某一个巨大的条件语句块。
 * 缺点：状态模式的使用必然会增加系统类和对象的个数。状态模式对"开闭原则"的支持并不太好，对于可以切换状态的状态模式，增加新的状态类需要修改那些负责状态转换的代码。
 * @author GM20170901
 * @date 2020/3/31 10:52
 */
public class StatePatternTest   {
    public static void main(String[] args) {
    Context context=new Context();
    context.setState(new SupervisorState());
    context.request();
    context.request();
    context.request();
    }
}
