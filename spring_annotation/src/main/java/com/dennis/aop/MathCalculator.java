package com.dennis.aop;


public class MathCalculator {
    public Integer div(Integer x, Integer y) {
        System.out.println("============目标方法开始============");
        System.out.println("MathCalculator...div...");
        System.out.println("============目标方法结束============");
        return x / y;
    }
}
