package org.yuhang.designpattern.factory.simplefactory;

/**
 * 简单Pizza工厂类，可根据type返回对应的具体Pizza
 */
public class SimplePizzaFactory {


    public static Pizza createPizza(String type){
        if("cheese".equals(type)){
            return new CheesePizza();
        }else if("veggie".equals(type)){
            return new VeggiePizza();
        }else if("clam".equals(type)){
            return new ClamPizza();
        }
       return null;
    }
}
