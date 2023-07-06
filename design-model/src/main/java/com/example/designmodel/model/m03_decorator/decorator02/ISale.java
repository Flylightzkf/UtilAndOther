package com.example.designmodel.model.m03_decorator.decorator02;

/**
 * @author benjamin_5
 * @Description 接口类，充当component
 * @date 2023/4/18
 */
public interface ISale {
    /**
     * 收银
     * @param price 原价
     * @param num 数量
     * @return
     */
    public double acceptCash(double price, int num);
}
