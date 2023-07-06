package com.example.designmodel.model.m08_facade.facade02;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/4/24
 */
public class Facade {
    private SubSystemA systemA;
    private SubSystemB systemB;
    private SubSystemC systemC;

    public Facade() {
        systemA = new SubSystemA();
        systemB = new SubSystemB();
        systemC = new SubSystemC();
    }

    public void method(){
        systemA.methodA();
        systemB.methodB();
        systemC.methodC();
    }

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.method();
    }
}
