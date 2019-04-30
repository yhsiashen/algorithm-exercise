package org.yuhang.designpattern.factory.abstractfactory;

/**
 * 抽象的Pizza店类
 */
public abstract class PizzaStore {

    /**
     * 这里是抽象方法，由子类实现，表示Pizza店将Pizza的创建转移到了子类的方法中
     * 这个方法就如同一个工厂方法
     * @param type
     * @return
     */
    public abstract Pizza createPizza(String type);

    /**
     * 这是个具体方法，因为想要所有的Pizza下订单的流程一致，便于规范流程和管理
     * @param type
     * @return
     */
    public void orderPizza(String type){
        Pizza pizza = createPizza(type);
        /**做pizza流程 */
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
    }


}
