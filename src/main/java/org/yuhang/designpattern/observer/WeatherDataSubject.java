package org.yuhang.designpattern.observer;


import java.util.ArrayList;

/**
 * 天气数据类，包含一些可改变的状态(数据)，包括温度，天气，压强 e.g 供订阅方(Observer)获取
 */
public class WeatherDataSubject implements Subject {

    private ArrayList<Observer> observers;
    /**天气温度 */
    private float temperature;
    /**天气温度 */
    private float humidity;
    /**天气压强*/
    private float pressure;

    @Override
    public void registerObserver(Observer observer) {
         observers.add(observer);
    }

    @Override
    public void removeObserver(Observer obeserver) {
        observers.remove(obeserver);
    }

    @Override
    public void notifyObservers() {
        for (Observer o:observers) {
            o.update(this,getTemperature(),getHumidity(),getPressure());
        }
    }

    /**
     * 此方法是监控站测到温度变化后，主动调用的方法，即设置更新的数据，通知订阅方
     */
    public void setMeasurements(float temperature,float humidity,float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
