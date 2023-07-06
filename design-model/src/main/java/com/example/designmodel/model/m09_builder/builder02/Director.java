package com.example.designmodel.model.m09_builder.builder02;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/4/24
 */
public class Director {

    public void construct(Builder builder) {
        builder.buildPartA();
        builder.buildPartB();
    }
}
