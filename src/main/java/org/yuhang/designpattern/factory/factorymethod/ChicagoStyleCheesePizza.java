package org.yuhang.designpattern.factory.factorymethod;

import org.yuhang.designpattern.factory.simplefactory.Pizza;

public class ChicagoStyleCheesePizza extends Pizza {

    public ChicagoStyleCheesePizza(){
        name = "ChicagoStyle Cheese Pizza";
    }

    public void cut(){
        System.out.println(name + " is cut and cutting the pizza into square slices");
    }
}
