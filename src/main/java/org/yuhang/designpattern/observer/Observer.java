package org.yuhang.designpattern.observer;

/**
 * 观察者接口，用于订阅主题
 */
public interface Observer {

    public void update(Subject subject,float tem,float humidity,float pressure);
}
