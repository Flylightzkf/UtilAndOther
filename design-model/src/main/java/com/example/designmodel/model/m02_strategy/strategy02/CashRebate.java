package com.example.designmodel.model.m02_strategy.strategy02;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/4/13
 */
public class CashRebate extends CashSuper {
    private double moneyRebate = 1d;

    public CashRebate(String moneyRebate) {
        this.moneyRebate = Double.parseDouble(moneyRebate);
    }

    @Override
    public double acceptCash(double money) {
        System.out.println("rebate");
        return money * moneyRebate;
    }

}
