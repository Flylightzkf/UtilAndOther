package com.example.designmodel.model.m05_factory_method.factory02;

import com.example.designmodel.model.m03_decorator.decorator02.CashNormal;
import com.example.designmodel.model.m03_decorator.decorator02.CashRebate;
import com.example.designmodel.model.m03_decorator.decorator02.CashReturn;
import com.example.designmodel.model.m03_decorator.decorator02.ISale;

/**
 * @author benjamin_5
 * @Description 每个单一工厂都是简单工厂
 * @date 2023/4/19
 */
public class CashReturnRebateFactory implements IFactory{

    private double moneyRebate = 1d;
    private double moneyCondition = 0d;
    private double moneyReturn = 0d;

    public CashReturnRebateFactory(double moneyRebate, double moneyCondition, double moneyReturn) {
        this.moneyRebate = moneyRebate;
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }

    @Override
    public ISale createSalesModel() {
        CashNormal normal = new CashNormal();
        CashRebate rebate = new CashRebate(this.moneyRebate);
        CashReturn cashReturn = new CashReturn(this.moneyCondition, this.moneyReturn);
        rebate.decorate(normal);
        cashReturn.decorate(rebate);
        return cashReturn;
    }
}
