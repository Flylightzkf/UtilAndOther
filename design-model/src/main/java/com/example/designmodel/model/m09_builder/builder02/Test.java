package com.example.designmodel.model.m09_builder.builder02;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/4/24
 */
public class Test {

    public static void main(String[] args) {
        Director director = new Director();
        Builder builder1 = new ConcreteBuilder1();
        Builder builder2 = new ConcreteBuilder2();

        director.construct(builder1);
        Product product1 = builder1.getResult();
        product1.show();

        director.construct(builder2);
        Product product2 = builder2.getResult();
        product2.show();
    }
}
