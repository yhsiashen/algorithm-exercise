package org.yuhang.designpattern.factory.factorymethod;


import org.yuhang.designpattern.factory.simplefactory.Pizza;

/**
 * 芝加哥风味的pizz店
 */
public class ChicagoStylePizzaStore extends PizzaStore {


    @Override
    public Pizza createPizza(String type) {
        if("cheese".equals(type)){
            return new ChicagoStyleCheesePizza();
        }

        return null;
    }
}
