package com.example.designmodel.model.m10_observer.observer01;

/**
 * @author benjamin_5
 * @Description 天气检测系统观察者
 * @date 2023/4/24
 */
public interface Observer {
    /**
     * 更新
     * @param temperature 气温
     * @param humidity 湿度
     * @param pressure 气压
     */
    void update(float temperature, float humidity, float pressure);
}
