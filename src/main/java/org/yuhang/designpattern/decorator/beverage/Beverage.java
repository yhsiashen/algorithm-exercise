package org.yuhang.designpattern.decorator.beverage;


/**
 * 装饰者模式,星巴克订单计算系统,饮料基类
 */
public abstract class Beverage {

    String descrption = "Unknown Beverage";

    /**饮料容量 -1为小杯 0为中杯 1为大杯 */
    private int size;


    public String getDescription(){
        if(getSize() == -1){
            return "small "+descrption;
        }else if(getSize() == 0){
            return "middle "+descrption;
        }else {
            return "big "+descrption;
        }
    }

    /**
     * 抽象方法，所有继承饮料类的子类实现
     * @return
     */
    public abstract double cost();

    public void setSize(int size){
        this.size = size;
    }

    public int getSize(){
        return this.size;
    }
}
