package org.yuhang.designpattern.factory.abstractfactory;

import org.yuhang.designpattern.factory.abstractfactory.ingredientfactory.PizzaIngredientFactory;

public class CheesePizza extends Pizza {

    PizzaIngredientFactory ingredientFactory;

    public CheesePizza(PizzaIngredientFactory ingredientFactory){
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println(name+" is preparing");
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
    }
}
