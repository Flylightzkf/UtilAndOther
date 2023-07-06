package com.example.designmodel.model.m08_facade.facade01;

/**
 * @author benjamin_5
 * @Description 基金类 外观类
 * @date 2023/4/24
 */
public class FundFacade {

    Stock1 stock1;
    Stock2 stock2;
    NationalDebt1 nationalDebt1;
    Realty1 realty1;

    public FundFacade() {
        stock1 = new Stock1();
        stock2 = new Stock2();
        nationalDebt1 = new NationalDebt1();
        realty1 = new Realty1();
    }

    public void buyFund() {
        stock1.buy();
        stock2.buy();
        nationalDebt1.buy();
        realty1.buy();
    }

    public void sellFund() {
        stock1.sell();
        stock2.sell();
        nationalDebt1.sell();
        realty1.sell();
    }


}
