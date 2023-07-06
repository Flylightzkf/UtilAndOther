package com.example.designmodel.model.m05_factory_method.factory02;

import com.example.designmodel.model.m03_decorator.decorator02.ISale;

/**
 * @author benjamin_5
 * @Description 简单工厂+策略模式+装饰器模式+工厂方法模式
 * @date 2023/4/19
 */
public class CashContext {
    private ISale cs;

    /**
     * 每个case都是一种策略
     * @param cashType
     */
    public CashContext(int cashType){
        switch (cashType){
            case 1:
                // 原价
                cs = new CashRebateReturnFactory(1, 0, 0).createSalesModel();
                break;
            case 2:
                // 打8折
                cs = new CashRebateReturnFactory(0.8, 0, 0).createSalesModel();
                break;
            case 3:
                // 打7折
                cs = new CashRebateReturnFactory(0.7, 0, 0).createSalesModel();
                break;
            case 4:
                // 满300减100
                cs = new CashRebateReturnFactory(1, 300, 100).createSalesModel();
                break;
            case 5:
                // 先打8折，再满300返100
                cs = new CashRebateReturnFactory(0.8, 300, 100).createSalesModel();
                break;
            case 6:
                // 满200返50，再打8折
                cs = new CashReturnRebateFactory(0.8, 200, 50).createSalesModel();
                break;
            default:
        }
    }

    public double getResult(double price, int num){
        return this.cs.acceptCash(price, num);
    }

    public static void main(String[] args) {
        CashContext cashContext = new CashContext(5);
        double result = cashContext.getResult(200, 2);
        System.out.println(result);
    }

}
