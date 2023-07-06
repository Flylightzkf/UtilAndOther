package com.example.designmodel.model.m12_state.state2;

import lombok.Data;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/4/28
 */
@Data
public class Work {
    private State current;
    private int hour;
    private boolean finish = false;

    public Work() {
        current = new ForenoonState();
    }

    public void writeProgram() {
        // 显示当前状态，并切换下一状态
        current.writeProgram(this);
    }
}
