package com.chinalife.springmvc.enums;

/**
 * Created by chinalife on 2017/1/6.
 */
public enum SeckillStatEnum {


     SUCCESS(1,"秒杀成功"),
     END(0,"秒杀结束"),
     REPEAT_KILL(-1,"重复异常"),
     INNER_ERROR(-2,"系统异常"),
     DATA_REWRITE(-3,"数据篡改异常");


    private int state;
    private String stateinfo;

    SeckillStatEnum(int state, String stateinfo) {
        this.state = state;
        this.stateinfo = stateinfo;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateinfo() {
        return stateinfo;
    }

    public void setStateinfo(String stateinfo) {
        this.stateinfo = stateinfo;
    }

    @Override
    public String toString() {
        return "SeckillStatEnum{" +
                "state=" + state +
                ", stateinfo='" + stateinfo + '\'' +
                '}';
    }

    public static SeckillStatEnum stateOf(int index) {
        for (SeckillStatEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}
