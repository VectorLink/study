package com.example.pattern.strategypattern;

/**
 * 策略模式定义了一系列算法，并将每个算法封装起来，使他们可以相互替换，且算法的变化不会影响到使用算法的客户，属于行为型模式。
 * @author GM20170901
 * @date 2020/3/31 11:46
 */
public class StrategyPatternTest  {
    public static void main(String[] args) {
        Context context=new Context(new OptionAdd());
        System.out.println( context.executeStrategy(1,2));
        context.setCalculator(new OptionDivide());
        System.out.println(context.executeStrategy(2,1));

    }
}
