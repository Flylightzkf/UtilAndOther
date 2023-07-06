package com.example.designmodel.model.m11_abstract_factory;

/**
 * @author benjamin_5
 * @Description 产品1具体工厂
 * @date 2023/4/28
 */
public class ConcreteFactory1 implements AbstractFactory{
    @Override
    public ProductA createProductA() {
        return new ConcreteProductA1();
    }

    @Override
    public ProductB createProductB() {
        return new ConcreteProductB1();
    }
}
