package com.example.designmodel.model.m09_builder.builder01;

import java.awt.*;

/**
 * @author benjamin_5
 * @Description 抽象建造者
 * @date 2023/4/24
 */
public abstract class PersonBuilder {

    protected Graphics graphics;

    public PersonBuilder(Graphics graphics) {
        this.graphics = graphics;
    }

    public abstract void buildHead();

    public abstract void buildBody();

    public abstract void buildArmLeft();

    public abstract void buildArmRight();

    public abstract void buildLegLeft();

    public abstract void buildLegRight();
}
