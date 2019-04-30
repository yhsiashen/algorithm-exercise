package org.yuhang.designpattern.factory.simplefactory;

/**
 * Pizza抽象类，是所有具体Pizza的超类
 */
public abstract class Pizza {

    public String name = "Unknow Pizza";

    public void prepare() {
        System.out.println(name +" is prepared");
    }


    public void bake() {
        System.out.println(name + " is baked");
    }


    public void cut() {
        System.out.println(name + " is cut");
    }


    public void box() {
        System.out.println(name + " is boxed");
    }
}
