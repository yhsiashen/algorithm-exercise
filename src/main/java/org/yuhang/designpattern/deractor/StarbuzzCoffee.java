package org.yuhang.designpattern.deractor;

import org.yuhang.designpattern.deractor.beverage.Beverage;
import org.yuhang.designpattern.deractor.beverage.Espresso;
import org.yuhang.designpattern.deractor.condiment.Mocha;
import org.yuhang.designpattern.deractor.condiment.Whip;

/**
 * 星巴克订单系统
 */
public class StarbuzzCoffee {

    public static void main(String[] args) {
        Beverage espresso = new Espresso(); //订一杯Espresso,不需要任何调料，打印出描述和价格
        System.out.println(espresso.getDescription()+"$"+espresso.cost());

        Beverage beverage = new Espresso(); //订一杯Espresso
        beverage = new Mocha(beverage); // 加摩卡装饰
        beverage = new Mocha(beverage); // 再加摩卡装饰
        beverage = new Whip(beverage); // 加奶泡装饰
        System.out.println(beverage.getDescription()+"$"+beverage.cost());

        Beverage beverage1 = new Espresso(1); //订一个大杯Espresso
        beverage1 = new Mocha(beverage1); // 加摩卡装饰
        beverage1 = new Mocha(beverage1); // 再加摩卡装饰
        beverage1 = new Whip(beverage1); // 加奶泡装饰
        System.out.println(beverage1.getDescription()+"$"+beverage1.cost());



    }
}
