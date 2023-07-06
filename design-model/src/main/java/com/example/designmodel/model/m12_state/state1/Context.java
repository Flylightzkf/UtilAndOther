package com.example.designmodel.model.m12_state.state1;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/4/28
 */
public class Context {
    private State state;

    public Context(State state) {
        // 初始状态
        this.state = state;
    }

    /**
     * 更新状态
     * @param state
     */
    public void setState(State state) {
        this.state = state;
        System.out.println("当前状态：" + state.getClass().getName());
    }

    public State getState(){
        return this.state;
    }

    public void execute() {
        this.state.handle(this);
    }
}
