package com.example.designmodel.model.m10_observer.observer01;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/4/24
 */
public class Test {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        // 将观察者注册到主题中
        CurrentConditionDisplay currentDisplay = new CurrentConditionDisplay(weatherData);
        // 执行主题方法，同时触发观察者的更新方法
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 62, 31.4f);
        weatherData.setMeasurements(81, 62, 32.4f);
    }
}
