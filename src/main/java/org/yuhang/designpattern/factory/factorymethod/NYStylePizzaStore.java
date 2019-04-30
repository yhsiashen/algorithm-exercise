package org.yuhang.designpattern.factory.factorymethod;


import org.yuhang.designpattern.factory.simplefactory.Pizza;

/**
 * 继承Pizza店基类，是纽约风味的Pizza店
 */
public class NYStylePizzaStore extends PizzaStore {

    /**
     * 工厂方法，由纽约风味Pizza店负责生产纽约风味Pizza
     * @param type
     * @return
     */
    @Override
    public Pizza createPizza(String type) {
        if("cheese".equals(type)){
            return new NYStyleCheesePizza();
        }
        return null;
    }
}
