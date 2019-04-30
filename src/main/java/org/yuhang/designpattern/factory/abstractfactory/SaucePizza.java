package org.yuhang.designpattern.factory.abstractfactory;

import org.yuhang.designpattern.factory.abstractfactory.ingredientfactory.PizzaIngredientFactory;

public class SaucePizza extends Pizza {

    PizzaIngredientFactory ingredientFactory;

    public SaucePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println(name + " is preparing");
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
    }
}
