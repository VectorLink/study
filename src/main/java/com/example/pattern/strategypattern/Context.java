package com.example.pattern.strategypattern;

/**
 * @author GM20170901
 * @date 2020/3/31 13:50
 */
public class Context {
    private Calculator calculator;

    public Context(Calculator calculator) {
        this.calculator = calculator;
    }
    public double executeStrategy(int num1,int num2){
        return calculator.calculate(num1,num2);
    }

    public Calculator getCalculator() {
        return calculator;
    }

    public void setCalculator(Calculator calculator) {
        this.calculator = calculator;
    }
}
