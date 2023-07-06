package com.example.designmodel.model.m10_observer.observer01;

/**
 * @author benjamin_5
 * @Description 具体的观察者
 * @date 2023/4/24
 */
public class CurrentConditionDisplay implements Observer{
    private float temperature;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        // 订阅主题的消息
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        // 更新数据后执行显示逻辑
        display();
    }

    public void display() {
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }

}
