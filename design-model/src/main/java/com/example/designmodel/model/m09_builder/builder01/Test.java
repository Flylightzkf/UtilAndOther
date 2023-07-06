package com.example.designmodel.model.m09_builder.builder01;

import javax.swing.*;
import java.awt.*;

/**
 * @author benjamin_5
 * @Description 画一个小人
 * @date 2023/4/24
 */
public class Test extends JFrame {

    public Test(){
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void paint(Graphics graphics){
        super.paint(graphics);
        PersonThinBuilder personThinBuilder = new PersonThinBuilder(graphics);
        PersonDirector personDirector = new PersonDirector(personThinBuilder);
        personDirector.createPerson();
    }

    public static void main(String[] args) {
        new Test().setVisible(true);
    }

}
