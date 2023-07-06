package com.example.designmodel.model.m05_factory_method.factory01;

import com.example.designmodel.model.m01_simple_factory.*;

/**
 * @author benjamin_5
 * @Description 基础运算工厂
 * @date 2023/4/18
 */
public class BasicFactory implements IFactory{

    @Override
    public Operation createOperation(String operate) {
        switch (operate) {
            case "+":
                return new Add();
            case "-":
                return new Sub();
            case "*":
                return new Mul();
            case "/":
                return new Div();
            default:
                return null;
        }
    }
}
