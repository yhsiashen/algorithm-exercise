package org.yuhang.designpattern.deractor.beverage;

import org.yuhang.designpattern.deractor.beverage.Beverage;

public class HouseBlend extends Beverage {

    public HouseBlend() {
        descrption = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
