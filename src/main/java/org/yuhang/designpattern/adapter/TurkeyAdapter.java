package org.yuhang.designpattern.adapter;


/**
 * 适配器模式，现在有一个现成的火鸡对象，需要鸭子对象，于是需要一个适配器来获得鸭子对象
 */
public class TurkeyAdapter implements Duck {

    Turkey turkey; //需要持有现成的火鸡对象的引用

    public TurkeyAdapter(Turkey turkey){
        this.turkey = turkey;
    }

    @Override
    public void quack() {
       turkey.gobble();
    }

    @Override
    public void fly() {
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }
}
