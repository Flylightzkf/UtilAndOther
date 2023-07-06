package com.example.designmodel.model.m03_decorator.decorator01;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/4/13
 */
public class ConcreteDecoratorA extends Decorator{
    private String addedState;

    @Override
    public void operation() {
        super.operation();
        this.addedState = "具体的装饰对象A的操作";
        System.out.println(this.addedState);
    }

}
