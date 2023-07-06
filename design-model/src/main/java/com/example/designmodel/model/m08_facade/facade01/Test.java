package com.example.designmodel.model.m08_facade.facade01;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/4/24
 */
public class Test {

    public static void main(String[] args) {
        // 一个统一的对外接口，对调用方来说更加清楚简单，不需要知道内部的实现细节
        FundFacade fund = new FundFacade();
        fund.buyFund();
        fund.sellFund();
    }
}
