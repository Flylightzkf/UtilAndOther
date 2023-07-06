package com.example.designmodel.model.m03_decorator.decorator01;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/4/13
 */
public class Test {

    public static void main(String[] args) {
        Component c = new ConcreteComponent();
        ConcreteDecoratorA d1 = new ConcreteDecoratorA();
        ConcreteDecoratorA d2 = new ConcreteDecoratorA();

        d1.setComponent(c);
        d2.setComponent(d1);
        d2.operation();
    }
}
