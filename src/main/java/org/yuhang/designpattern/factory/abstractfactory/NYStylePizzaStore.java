package org.yuhang.designpattern.factory.abstractfactory;

import org.yuhang.designpattern.factory.abstractfactory.ingredientfactory.NYPizzaIngredientFactory;
import org.yuhang.designpattern.factory.abstractfactory.ingredientfactory.PizzaIngredientFactory;
import org.yuhang.designpattern.factory.abstractfactory.PizzaStore;

/**
 * 纽约风味pizza店委托纽约原料生产工厂得到原料并生成pizza
 */
public class NYStylePizzaStore extends PizzaStore {

    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;

        //实例一个纽约店需要的原料生产工厂
        PizzaIngredientFactory pizzaIngredientFactory = new NYPizzaIngredientFactory();
        if("cheese".equals(type)){
            pizza = new CheesePizza(pizzaIngredientFactory); //利用这个原料工厂实例化一个CheesePizza
            pizza.setName("NY Style Cheese Pizza");
        }
        return pizza;


    }
}
