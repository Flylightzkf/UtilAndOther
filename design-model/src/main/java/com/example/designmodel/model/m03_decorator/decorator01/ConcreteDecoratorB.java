package com.example.designmodel.model.m03_decorator.decorator01;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/4/13
 */
public class ConcreteDecoratorB extends Decorator{

    @Override
    public void operation() {
        super.operation();
        this.addedBehavior();
    }

    private void addedBehavior(){
        System.out.println("具体装饰对象B的额外操作");
    }
}
