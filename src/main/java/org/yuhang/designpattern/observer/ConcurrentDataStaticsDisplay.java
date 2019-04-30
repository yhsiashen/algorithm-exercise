package org.yuhang.designpattern.observer;


/**
 * 当前数据统计面板，实现观察者接口和面板接口，
 * 观察者接口用于更新从天气数据主题获取的实时数据，
 * 面板接口用于展示面板
 */
public class ConcurrentDataStaticsDisplay implements Observer,DisplayElement {

    /**天气温度 */
    private float temperature;
    /**天气温度 */
    private float humidity;
    /**天气压强*/
    private float pressure;

    private Subject weatherDataSubject;

    public ConcurrentDataStaticsDisplay(Subject weatherDataSubject) {
         this.weatherDataSubject = weatherDataSubject;
         registerObserver();
    }

    private void registerObserver(){
        weatherDataSubject.registerObserver(this); //构造器中注册此观察者
    }

    /**
     * 当天气主题数据更新时，主题主动push到所有订阅主题的Observer
     * 也可以订阅方主动的从主题pull数据
     * @param tem
     * @param humidity
     * @param pressure
     */
    @Override
    public void update(Subject subject,float tem, float humidity, float pressure) {
        // push方式
        this.temperature = tem;
        this.humidity = humidity;
        this.pressure = pressure;

        // pull方式
        if(subject instanceof WeatherDataSubject){
            WeatherDataSubject weatherDataSubject = (WeatherDataSubject)subject;
            this.temperature = weatherDataSubject.getTemperature();
            this.humidity = weatherDataSubject.getHumidity();
            this.pressure = weatherDataSubject.getTemperature();
        }

    }

    @Override
    public void display() {
       //将温度，湿度，压力等
    }
}
