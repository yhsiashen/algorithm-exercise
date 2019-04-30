package org.yuhang.designpattern.factory.abstractfactory.ingredientfactory;

/**
 * 用于纽约pizza店制作pizza的原料工厂实现类
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {


    @Override
    public Cheese createCheese() {
        return new NYNeedCheese();
    }

    @Override
    public Sauce createSauce() {
        return new NYNeedSauce();
    }
}
