package org.yuhang.designpattern.decorator.condiment;


import org.yuhang.designpattern.decorator.beverage.Beverage;

/**
 * 调料基类，表示诸如摩卡，茶，奶泡等能加到饮料中的调料
 */
public abstract class CondimentDecorator extends Beverage {

    public abstract String getDescription();
}
