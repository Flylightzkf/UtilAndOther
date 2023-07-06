package com.example.designmodel.model.m03_decorator.decorator02;


/**
 * @author benjamin_5
 * @Description 装饰器模式
 * @date 2023/4/18
 */
public class CashContext {

    private ISale cs;

    public CashContext(int cashType){
        switch (cashType){
            case 1:
                cs = new CashNormal();
                break;
            case 2:
                cs = new CashRebate(0.8d);
                break;
            case 3:
                cs = new CashRebate(0.7d);
                break;
            case 4:
                cs = new CashReturn(300, 100);
                break;
            case 5:
                // 先打8折，再满300返100
                CashNormal cashNormal = new CashNormal();
                CashReturn cashReturn = new CashReturn(300, 100);
                CashRebate cashRebate = new CashRebate(0.8);
                cashReturn.decorate(cashNormal);
                cashRebate.decorate(cashReturn);
                cs = cashRebate;
                break;
            case 6:
                // 满200返50，再打8折
                CashNormal cashNormal1 = new CashNormal();
                CashRebate cashReturn1 = new CashRebate(0.8);
                CashReturn cashRebate1 = new CashReturn(200, 50);
                cashReturn1.decorate(cashNormal1);
                cashRebate1.decorate(cashReturn1);
                cs = cashRebate1;
                break;
            default:
        }
    }

    public double getResult(double price, int num){
        return this.cs.acceptCash(price, num);
    }

    public static void main(String[] args) {
        CashContext cashContext = new CashContext(6);
        double result = cashContext.getResult(200, 2);
        System.out.println(result);

    }

}
