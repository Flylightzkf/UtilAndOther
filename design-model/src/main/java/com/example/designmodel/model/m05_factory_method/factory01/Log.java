package com.example.designmodel.model.m05_factory_method.factory01;

import com.example.designmodel.model.m01_simple_factory.Operation;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/4/18
 */
public class Log extends Operation {

        @Override
        public double getResult(double num1, double num2) {
            return Math.log(num1) / Math.log(num2);
        }
}
