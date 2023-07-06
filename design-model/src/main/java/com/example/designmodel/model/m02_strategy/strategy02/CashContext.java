package com.example.designmodel.model.m02_strategy.strategy02;

/**
 * @author benjamin_5
 * @Description 策略模式与简单工厂的结合
 * @date 2023/4/13
 */
public class CashContext {
    private CashSuper cs;

    /**
     * 工厂模式创建具体实现类
     * 缺点：增加新的策略，就需要增加新的case
     * @param type
     */
    public CashContext(int type) {
        switch (type) {
            case 1:
                cs = new CashNormal();
                break;
            case 2:
                cs = new CashRebate("0.8");
                break;
            case 3:
                cs = new CashRebate("0.7");
                break;
            case 4:
                cs = new CashReturn("300", "100");
                break;
            default:
        }
    }

    public double getResult(double price, int num){
        return cs.acceptCash(price * num);
    }

    public static void main(String[] args) {
        // 先构造
        CashContext cc = new CashContext(4);
        // 然后调用具体的封装实现方法
        double result = cc.getResult(100, 10);
        System.out.println(result);
    }
}
