package com.example.designmodel.model.m11_abstract_factory;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/4/28
 */
public class Test {
    public static void main(String[] args) {
        AbstractFactory factory1 = new ConcreteFactory1();
        AbstractFactory factory2 = new ConcreteFactory2();

        ProductA productA1 = factory1.createProductA();
        ProductA productA2 = factory2.createProductA();

        ProductB productB1 = factory1.createProductB();
        ProductB productB2 = factory2.createProductB();

        productA1.operationA();
        productA2.operationA();
        productB1.operationB();
        productB2.operationB();
    }
}
