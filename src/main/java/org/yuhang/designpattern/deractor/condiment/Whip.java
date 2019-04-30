package org.yuhang.designpattern.deractor.condiment;


import org.yuhang.designpattern.deractor.beverage.Beverage;

/**
 * 奶泡是调料的一种
 */
public class Whip extends CondimentDecorator {

    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+",Whip";
    }

    @Override
    public double cost() {
        return beverage.cost()+0.32;
    }
}
