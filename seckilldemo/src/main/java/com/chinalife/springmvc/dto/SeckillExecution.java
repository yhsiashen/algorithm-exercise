package com.chinalife.springmvc.dto;

import com.chinalife.springmvc.entity.SuccessKilled;
import com.chinalife.springmvc.enums.SeckillStatEnum;

import java.util.List;

/**
 * 封装执行秒杀后的相关信息(包括ID，秒杀状态,秒杀成功的对象)
 * Created by chinalife on 2017/1/6.
 */
public class SeckillExecution {

    private  long seckillId;

    private  int state;

    private  String stateinfo;

    private List<SuccessKilled> successKilledList;

    public SeckillExecution(long seckillId, SeckillStatEnum statEnum, List<SuccessKilled> successKilledList) {
        this.seckillId = seckillId;
        this.state = statEnum.getState();
        this.stateinfo = statEnum.getStateinfo();
        this.successKilledList = successKilledList;
    }

    public SeckillExecution(long seckillId, SeckillStatEnum statEnum) {
        this.seckillId = seckillId;
        this.state = statEnum.getState();
        this.stateinfo = statEnum.getStateinfo();
    }


    @Override
    public String toString() {
        return "SeckillExecution{" +
                "seckillId=" + seckillId +
                ", state=" + state +
                ", stateinfo='" + stateinfo + '\'' +
                ", successKilledList=" + successKilledList +
                '}';
    }
}
