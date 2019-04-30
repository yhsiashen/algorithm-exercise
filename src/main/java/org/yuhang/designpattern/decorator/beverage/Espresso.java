package org.yuhang.designpattern.decorator.beverage;

public class Espresso  extends Beverage {


    public Espresso(){
       descrption = "Espresso";
    }

    public Espresso(int size){
        descrption = "Espresso";
        setSize(size);
    }

    /**
     * 根据饮料杯的大小计算价格
     * @return
     */
    @Override
    public double cost() {
        if(getSize() == -1){
            return 0.1;
        }else if(getSize() == 0){
            return 0.15;
        }else {
            return 0.18;
        }


    }
}
