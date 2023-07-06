package com.example.designmodel.model.m12_state.state1;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/4/28
 */
public class Test {

    public static void main(String[] args) {
        Context context = new Context(new ConcreteStateA());
        context.execute();
//        context.setState(new ConcreteStateB());
        context.execute();
        context.execute();
        context.execute();
    }
}
