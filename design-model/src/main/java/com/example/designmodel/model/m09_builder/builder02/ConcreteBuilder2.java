package com.example.designmodel.model.m09_builder.builder02;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/4/24
 */
public class ConcreteBuilder2 extends Builder{

    private Product product = new Product();

    @Override
    public void buildPartA() {
        product.add("部件X");
    }

    @Override
    public void buildPartB() {
        product.add("部件Y");
    }

    @Override
    public Product getResult() {
        return product;
    }
}
