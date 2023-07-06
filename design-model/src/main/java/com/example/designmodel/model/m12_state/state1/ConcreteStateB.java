package com.example.designmodel.model.m12_state.state1;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/4/28
 */
public class ConcreteStateB implements State{

        @Override
        public void handle(Context context) {
            context.setState(new ConcreteStateA());
        }
}
