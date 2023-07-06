package com.example.designmodel.model.m07_template_method;

/**
 * @author benjamin_5
 * @Description 模版方法模式
 * @date 2023/4/19
 */
public abstract class AbstractClass {
    public void templateMethod(){
        specificMethod();
        abstractMethod1();
        abstractMethod2();
    }

    public void specificMethod(){
        System.out.println("抽象类中的具体方法被调用...");
    }

    public abstract void abstractMethod1();
    public abstract void abstractMethod2();
}
