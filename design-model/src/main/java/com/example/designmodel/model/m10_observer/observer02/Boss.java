package com.example.designmodel.model.m10_observer.observer02;

import java.util.Observable;

/**
 * @author benjamin_5
 * @Description 主题实现类(通知者) 对观察者的操作
 * @date 2023/4/27
 */
public class Boss extends Observable {

    protected String name;
    private String action;

    public Boss(String name) {
        this.name = name;
    }

    public void setAction(String action) {
        this.action = action;
        // 改变通知者的状态
        super.setChanged();
        // 调用父类Observable方法，通知所有观察者
        super.notifyObservers();
    }

    public String getAction() {
        return action;
    }

}
