package com.example.designmodel.model.m10_observer.observer02;

import java.util.Observable;
import java.util.Observer;

/**
 * @author benjamin_5
 * @Description 具体的观察者
 * @date 2023/4/27
 */
public class StockObserver implements Observer {

    protected String name;

    public StockObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        Boss b = (Boss) o;
        System.out.println(b.getAction() + " " + name + " 关闭股票行情，继续工作！");
    }
}
