package org.yuhang.designpattern.factory.abstractfactory;

import org.yuhang.designpattern.factory.abstractfactory.ingredientfactory.Cheese;
import org.yuhang.designpattern.factory.abstractfactory.ingredientfactory.Sauce;

/**
 * Pizza抽象类，使用原料工厂造的原料，然后烘焙，剪切，打包等
 */
public abstract class Pizza {
    String name;
    Sauce sauce;
    Cheese cheese;

    public abstract void prepare();

    public void bake() {
        System.out.println(name + " is baked");
    }


    public void cut() {
        System.out.println(name + " is cut");
    }


    public void box() {
        System.out.println(name + " is boxed");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
