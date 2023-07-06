package com.example.designmodel.model.m07_template_method;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/4/19
 */
public class ConcreteClassA extends AbstractClass{

    @Override
    public void abstractMethod1() {
        System.out.println("A抽象方法1的实现被调用...");
    }

    @Override
    public void abstractMethod2() {
        System.out.println("A抽象方法2的实现被调用...");
    }
}
