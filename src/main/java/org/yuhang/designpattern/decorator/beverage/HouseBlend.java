package org.yuhang.designpattern.decorator.beverage;

public class HouseBlend extends Beverage {

    public HouseBlend() {
        descrption = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
