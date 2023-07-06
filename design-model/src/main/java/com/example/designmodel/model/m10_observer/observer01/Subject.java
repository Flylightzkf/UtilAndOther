package com.example.designmodel.model.m10_observer.observer01;

/**
 * @author benjamin_5
 * @Description 主题接口：定义对观察者的操作（通知者）
 * @date 2023/4/24
 */
public interface Subject {
    /**
     * 注册观察者
     * @param o
     */
    void registerObserver(Observer o);

    /**
     * 删除观察者
     * @param o
     */
    void removeObserver(Observer o);

    /**
     * 通知观察者
     */
    void notifyObservers();
}
