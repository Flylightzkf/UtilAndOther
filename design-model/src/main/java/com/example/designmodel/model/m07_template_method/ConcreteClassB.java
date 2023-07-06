package com.example.designmodel.model.m07_template_method;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/4/19
 */
public class ConcreteClassB extends AbstractClass{

    @Override
    public void abstractMethod1() {
        System.out.println("B抽象方法1的实现被调用...");
    }

    @Override
    public void abstractMethod2() {
        System.out.println("B抽象方法2的实现被调用...");
    }
}
