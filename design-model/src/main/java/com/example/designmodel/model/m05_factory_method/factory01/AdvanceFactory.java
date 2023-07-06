package com.example.designmodel.model.m05_factory_method.factory01;

import com.example.designmodel.model.m01_simple_factory.Add;
import com.example.designmodel.model.m01_simple_factory.Operation;
import com.example.designmodel.model.m01_simple_factory.Sub;

/**
 * @author benjamin_5
 * @Description 高级运算工厂
 * @date 2023/4/18
 */
public class AdvanceFactory implements IFactory{

    @Override
    public Operation createOperation(String operate) {
        switch (operate) {
            case "pow":
                return new Pow();
            case "log":
                return new Log();
            default:
                return null;
        }
    }
}
