package com.example.designmodel.model.m10_observer.observer02;

import java.util.Observer;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/4/27
 */
public class Test {

    public static void main(String[] args) {
        // 被观察者
        Boss boss = new Boss("胡汉三");
        // 观察者
        Observer employee1 = new StockObserver("张三");
        Observer employee2 = new StockObserver("李四");
        Observer employee3 = new StockObserver("王五");

        boss.addObserver(employee1);
        boss.addObserver(employee2);
        boss.addObserver(employee3);

        boss.deleteObserver(employee2);

        boss.setAction("我胡汉三回来了！");
    }
}
