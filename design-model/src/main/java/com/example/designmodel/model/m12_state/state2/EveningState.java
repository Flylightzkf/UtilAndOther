package com.example.designmodel.model.m12_state.state2;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/4/28
 */
public class EveningState extends State{
        @Override
        public void writeProgram(Work work) {
            if(work.isFinish()){
                work.setCurrent(new RestState());
                work.writeProgram();
            }else{
                if(work.getHour() < 21){
                    System.out.println("当前时间：" + work.getHour() + "点 加班哦，疲累之极");
                }else{
                    work.setCurrent(new SleepingState());
                    work.writeProgram();
                }
            }
        }
}
