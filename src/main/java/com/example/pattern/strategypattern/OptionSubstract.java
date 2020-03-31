package com.example.pattern.strategypattern;

/**
 * @author GM20170901
 * @date 2020/3/31 14:03
 */
public class OptionSubstract implements Calculator {
    @Override
    public double calculate(double num1, double num2) {
        return num1-num2;
    }
}
