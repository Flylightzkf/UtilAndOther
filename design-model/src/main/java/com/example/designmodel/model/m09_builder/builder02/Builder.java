package com.example.designmodel.model.m09_builder.builder02;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/4/24
 */
public abstract class Builder {

    /**
     * 构造部件A
     */
    public abstract void buildPartA();

    /**
     * 构造部件B
     */
    public abstract void buildPartB();

    /**
     * 获取产品
     * @return
     */
    public abstract Product getResult();
}
