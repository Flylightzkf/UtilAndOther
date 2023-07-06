package com.example.designmodel.model.m12_state.state2;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/4/28
 */
public class NoonState extends State{
    @Override
    public void writeProgram(Work work) {
        if(work.getHour() < 13){
            System.out.println("当前时间：" + work.getHour() + "点 饿了，吃饭，午休");
        }else{
            work.setCurrent(new AfternoonState());
            work.writeProgram();
        }
    }
}
