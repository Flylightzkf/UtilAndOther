package com.example.designmodel.model.m09_builder.builder03;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/4/24
 */
public class Test {
    public static void main(String[] args) {
        Pizza pizza = new Pizza.Builder("crust", "sauce")
                .addTopping("cheese")
                .addTopping("mushrooms")
                .addTopping("peppers")
                .build();
    }
}
