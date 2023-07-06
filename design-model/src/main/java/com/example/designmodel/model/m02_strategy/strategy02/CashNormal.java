package com.example.designmodel.model.m02_strategy.strategy02;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/4/13
 */
public class CashNormal extends CashSuper {
    @Override
    public double acceptCash(double money) {
        System.out.println("normal");
        return money;
    }
}
