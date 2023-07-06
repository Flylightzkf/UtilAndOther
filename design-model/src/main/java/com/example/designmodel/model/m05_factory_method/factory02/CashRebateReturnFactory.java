package com.example.designmodel.model.m05_factory_method.factory02;

import com.example.designmodel.model.m03_decorator.decorator02.CashNormal;
import com.example.designmodel.model.m03_decorator.decorator02.CashRebate;
import com.example.designmodel.model.m03_decorator.decorator02.CashReturn;
import com.example.designmodel.model.m03_decorator.decorator02.ISale;

/**
 * @author benjamin_5
 * @Description 先打折后返利 工厂方式模式
 * @date 2023/4/19
 */
public class CashRebateReturnFactory implements IFactory {

    private double moneyRebate = 1d;
    private double moneyCondition = 0d;
    private double moneyReturn = 0d;

    public CashRebateReturnFactory(double moneyRebate, double moneyCondition, double moneyReturn) {
        this.moneyRebate = moneyRebate;
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }

    @Override
    public ISale createSalesModel() {
        CashNormal normal = new CashNormal();
        CashReturn cashReturn = new CashReturn(this.moneyCondition, this.moneyReturn);
        CashRebate rebate = new CashRebate(this.moneyRebate);
        // 装饰器模式
        cashReturn.decorate(normal);
        rebate.decorate(cashReturn);
        return rebate;
    }

}
