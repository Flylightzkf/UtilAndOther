package com.example.designmodel.model.m09_builder.builder01;

import java.awt.*;

/**
 * @author benjamin_5
 * @Description 具体建造者
 * @date 2023/4/24
 */
public class PersonThinBuilder extends PersonBuilder{

    public PersonThinBuilder(Graphics graphics) {
        super(graphics);
    }

    @Override
    public void buildHead() {
        graphics.drawOval(150, 120, 30, 30);
    }

    @Override
    public void buildBody() {
        graphics.drawRect(160, 150, 10, 50);
    }

    @Override
    public void buildArmLeft() {
        graphics.drawLine(160, 150, 140, 200);
    }

    @Override
    public void buildArmRight() {
        graphics.drawLine(170, 150, 190, 200);
    }

    @Override
    public void buildLegLeft() {
        graphics.drawLine(160, 200, 140, 250);
    }

    @Override
    public void buildLegRight() {
        graphics.drawLine(170, 200, 190, 250);
    }
}
