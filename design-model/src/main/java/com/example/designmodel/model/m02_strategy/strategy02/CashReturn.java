package com.example.designmodel.model.m02_strategy.strategy02;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/4/13
 */
public class CashReturn extends CashSuper{
    private double moneyCondition = 0.0d;
    private double moneyReturn = 0.0d;

    public CashReturn(String moneyCondition, String moneyReturn) {
        this.moneyCondition = Double.parseDouble(moneyCondition);
        this.moneyReturn = Double.parseDouble(moneyReturn);
    }

    @Override
    public double acceptCash(double money) {
        System.out.println("return");
        double result = money;
        if (money >= moneyCondition) {
            result = money - Math.floor(money / moneyCondition) * moneyReturn;
        }
        return result;
    }
}
