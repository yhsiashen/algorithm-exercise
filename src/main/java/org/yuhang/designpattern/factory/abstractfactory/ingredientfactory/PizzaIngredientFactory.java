package org.yuhang.designpattern.factory.abstractfactory.ingredientfactory;

/**
 * 用于制作pizza的原料工厂接口，抽象工厂类，负责一组产品(这里为原料)的生产
 */
public interface PizzaIngredientFactory {

    public Cheese createCheese();

    public Sauce createSauce();

}
