package com.chinalife.springmvc.service;

import com.chinalife.springmvc.dto.Exposer;
import com.chinalife.springmvc.dto.SeckillExecution;
import com.chinalife.springmvc.entity.Seckill;
import com.chinalife.springmvc.exception.RepeatKillException;
import com.chinalife.springmvc.exception.SeckillCloseException;
import com.chinalife.springmvc.exception.SeckillException;

import java.util.List;

/**
 * 业务接口：站在“使用者”的角度设计接口
 * Created by chinalife on 2017/1/6.
 */
public interface SeckillService {

    /**
     * 查询所有秒杀商品信息
     * @return  List
     */
    List<Seckill>  getSeckillList();

    /**
     * 查询单个秒杀商品信息
     * @param seckillId
     * @return  Seckill
     */
    Seckill getById(long seckillId);

    /**
     * 秒杀开启时输出秒杀接口地址，
     * 否则输出系统时间和秒杀时间
     * @param seckillId
     * @return Exposer
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) throws SeckillException,SeckillCloseException,
    RepeatKillException;

    public String selectVersionID(String id);

    public void updateSeckill() throws Exception;

    public void testAspect();
}
