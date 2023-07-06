package com.example.designmodel.model.m03_decorator.decorator02;

/**
 * @author benjamin_5
 * @Description 打折收银
 * @date 2023/4/18
 */
public class CashRebate extends CashSuper{

    private double moneyRebate = 1d;

    public CashRebate(double moneyRebate) {
        this.moneyRebate = moneyRebate;
    }

    @Override
    public double acceptCash(double price, int num) {
        double result = price * num * moneyRebate;
        System.out.println("rebate: "+ result);
        return super.acceptCash(result, 1);
    }
}
