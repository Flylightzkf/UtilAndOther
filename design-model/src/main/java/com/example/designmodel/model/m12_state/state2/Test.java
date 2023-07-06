package com.example.designmodel.model.m12_state.state2;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/4/28
 */
public class Test {
    public static void main(String[] args) {
        Work work = new Work();
        work.setHour(9);
        work.writeProgram();
        work.setHour(10);
        work.writeProgram();
        work.setHour(12);
        work.writeProgram();
        work.setHour(13);
        work.writeProgram();
        work.setHour(14);
    }


}
