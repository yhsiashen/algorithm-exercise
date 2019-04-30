package org.yuhang.designpattern.factory.simplefactory;

/**
 * Pizza店,具有生产Pizza和下订单Pizza
 */
public class PizzaStore {

    /**
     * 生产Pizza,从工厂中获得具体Pizza
     */
    public Pizza createPizza(String type){
       return SimplePizzaFactory.createPizza(type);
    }

    /**
     * 下订单
     */
    public void orderPizza(String type){
        Pizza pizza = createPizza(type);//获得pizza种类
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
    }
}
