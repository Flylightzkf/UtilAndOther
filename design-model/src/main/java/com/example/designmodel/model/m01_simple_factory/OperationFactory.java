package com.example.designmodel.model.m01_simple_factory;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/4/10
 */
public class OperationFactory {

    public static Operation createOperation(String operate) {
        Operation operation = null;
        switch (operate) {
            case "+":
                operation = new Add();
                break;
            case "-":
                operation = new Sub();
                break;
            case "*":
                operation = new Mul();
                break;
            case "/":
                operation = new Div();
                break;
            default:
                System.out.println("传入格式错误");
        }
        return operation;
    }

    public static void main(String[] args) {
        Operation operation = OperationFactory.createOperation("+");
        System.out.println(operation.getResult(1.2, 2.0));
    }
}
