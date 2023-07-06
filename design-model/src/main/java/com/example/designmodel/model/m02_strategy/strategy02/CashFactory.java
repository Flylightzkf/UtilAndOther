package com.example.designmodel.model.m02_strategy.strategy02;

/**
 * @author benjamin_5
 * @Description 简单工厂模式
 * @date 2023/4/13
 */
public class CashFactory {
    public static CashSuper createCashAccept(String type) {
        CashSuper cs = null;
        switch (type) {
            case "正常收费":
                cs = new CashNormal();
                break;
            case "满300返100":
                cs = new CashReturn("300.0", "100.0");
                break;
            case "打8折":
                cs = new CashRebate("0.8");
                break;
            default:
        }
        return cs;
    }

    public static void main(String[] args) {
        CashSuper cs = CashFactory.createCashAccept("满300返100");
        double totalPrices = cs.acceptCash(1000);
        System.out.println(totalPrices);
    }
}
