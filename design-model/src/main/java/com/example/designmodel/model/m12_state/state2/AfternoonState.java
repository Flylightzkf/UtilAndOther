package com.example.designmodel.model.m12_state.state2;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/4/28
 */
public class AfternoonState extends State{
    @Override
    public void writeProgram(Work work) {
        if(work.getHour() < 17){
            System.out.println("当前时间：" + work.getHour() + "点 下午状态还不错，继续努力");
        }else{
            work.setCurrent(new EveningState());
            work.writeProgram();
        }
    }
}
