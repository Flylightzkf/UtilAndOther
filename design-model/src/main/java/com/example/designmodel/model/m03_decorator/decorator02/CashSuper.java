package com.example.designmodel.model.m03_decorator.decorator02;

/**
 * @author benjamin_5
 * @Description 装饰器类，实现了ISale接口，持有一个ISale接口的引用
 * @date 2023/4/18
 */
public class CashSuper implements ISale{

    private ISale component;

    public void decorate(ISale component) {
        this.component = component;
    }

    @Override
    public double acceptCash(double price, int num) {
        double result = 0d;
        if(this.component != null){
            result = this.component.acceptCash(price, num);
        }
        return result;
    }
}
