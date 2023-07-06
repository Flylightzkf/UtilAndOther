package com.example.designmodel.model.m12_state.state1;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/4/28
 */
public class ConcreteStateA implements State{

    @Override
    public void handle(Context context) {
        context.setState(new ConcreteStateB());
    }
}
