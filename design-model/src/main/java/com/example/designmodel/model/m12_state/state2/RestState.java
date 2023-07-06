package com.example.designmodel.model.m12_state.state2;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/4/28
 */
public class RestState extends State{
    @Override
    public void writeProgram(Work work) {
        System.out.println("当前时间：" + work.getHour() + "点 下班回家了");
    }
}
