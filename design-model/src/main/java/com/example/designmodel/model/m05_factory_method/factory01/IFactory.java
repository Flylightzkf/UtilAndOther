package com.example.designmodel.model.m05_factory_method.factory01;

import com.example.designmodel.model.m01_simple_factory.Operation;

/**
 * @author benjamin_5
 * @Description 工厂接口
 * @date 2023/4/18
 */
public interface IFactory {
    public Operation createOperation(String operate);
}
