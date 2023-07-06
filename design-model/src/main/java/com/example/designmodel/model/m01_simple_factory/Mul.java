package com.example.designmodel.model.m01_simple_factory;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/4/10
 */
public class Mul extends Operation {
    @Override
    public double getResult(double num1, double num2) {
        return num1 * num2;
    }

}
