package com.example.designmodel.model.m05_factory_method.factory01;

import com.example.designmodel.model.m01_simple_factory.Operation;

/**
 * @author benjamin_5
 * @Description 计算工厂
 * @date 2023/4/18
 */
public class OperationFactory implements IFactory{

    @Override
    public Operation createOperation(String operate) {
        IFactory factory = null;
        switch (operate) {
            case "+":
            case "-":
            case "*":
            case "/":
                factory = new BasicFactory();
                break;
            case "pow":
            case "log":
                factory = new AdvanceFactory();
                break;
            default:
                return null;
        }
        return factory.createOperation(operate);
    }

    public static void main(String[] args) {
        OperationFactory operationFactory = new OperationFactory();
        double pow = operationFactory.createOperation("pow").getResult(2, 3);
        double result = operationFactory.createOperation("+").getResult(1, 2);
        System.out.println(pow);
        System.out.println(result);
    }
}
