package com.example.designmodel.model.m02_strategy.strategy03;

import com.example.designmodel.model.m02_strategy.strategy02.CashSuper;

import java.lang.reflect.Constructor;

/**
 * @author benjamin_5
 * @Description 反射+策略模式
 * @date 2023/4/13
 */
public class CashContextReflect {

    private static String packageName = "com.example.designmodel.model.m02_strategy.strategy02.";
    private static String name = "Cash";

    public static CashSuper createCashAccept(String type, Object... args) {
        CashSuper cashSuper = null;
        try {
            Class<?> aClass = Class.forName(packageName + name + type);
            Class<?>[] argClass = new Class<?>[args.length];
            for (int i = 0; i < args.length; i++) {
                argClass[i] = args[i].getClass();
            }
            Constructor<?> constructor = aClass.getConstructor(argClass);
            return (CashSuper) constructor.newInstance(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cashSuper;
    }

    public static void main(String[] args) {
        // TODO Rebate可以进一步调整为枚举
        CashSuper cs = CashContextReflect.createCashAccept("Rebate", "0.8");
        double totalPrices = cs.acceptCash(1000);
        System.out.println(totalPrices);

        CashSuper cs2 = CashContextReflect.createCashAccept("Return", "300", "100");
        double totalPrices2 = cs2.acceptCash(1000);
        System.out.println(totalPrices2);
    }
}
