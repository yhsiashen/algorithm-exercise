package org.yuhang.designpattern.decorator.condiment;


import org.yuhang.designpattern.decorator.beverage.Beverage;

/**
 * 摩卡是调料的一种
 */
public class Mocha extends CondimentDecorator {

    Beverage beverage;

    /**
     * 构造器中必须注入某一个饮料类，组合思想达到动态扩展
     * @param beverage
     */
    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }



    @Override
    public double cost() {
        return 0.20+beverage.cost();
    }


    @Override
    public String getDescription() {
        return beverage.getDescription()+",Mocha";
    }
}
