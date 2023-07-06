package com.example.designmodel.model.m07_template_method;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/4/19
 */
public class Test {

    public static void main(String[] args) {
        AbstractClass a = new ConcreteClassA();
        a.templateMethod();
        AbstractClass b = new ConcreteClassB();
        b.templateMethod();
    }
}
