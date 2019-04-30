package org.yuhang.designpattern.observer;

/**
 * 主题接口，用户发布数据，还可以注册和移除订阅者
 */
public interface Subject {

    public void registerObserver(Observer observer);

    public void removeObserver(Observer obeserver);

    public void notifyObservers();
}
