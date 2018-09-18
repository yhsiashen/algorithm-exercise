package com.chinalife.springmvc.spring;

/**
 * Created by chinalife on 2018/4/26.
 */
public class CarVo {

    private String tire;
    private int size;
    private String color;

    public String getTire() {
        return tire;
    }

    public void setTire(String tire) {
        this.tire = tire;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "CarVo{" +
                "tire='" + tire + '\'' +
                ", size=" + size +
                ", color='" + color + '\'' +
                '}';
    }
}
