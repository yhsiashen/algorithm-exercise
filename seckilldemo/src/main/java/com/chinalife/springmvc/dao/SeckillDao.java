package com.chinalife.springmvc.dao;

import com.chinalife.springmvc.annotation.DynamicDataSource;
import com.chinalife.springmvc.entity.Seckill;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by chinalife on 2017/1/5.
 */
@DynamicDataSource
public interface SeckillDao {
    /*
         * 查询秒杀商品减少数量方法
         */
    int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);

    /*
     * 通过ID查询秒杀一个商品信息
     */
    @DynamicDataSource
    Seckill queryById(long seckillId);

    /*
     * 通过第一个ID和最后一个ID查询多个秒杀商品信息
     */
    List<Seckill> queryAll(@Param("min") Integer min,@Param("max") Integer max);

    /*
     *ajax查询版本号
     */
    public  String  selectVersionID(String id);

    /*
     * 更新手机数量
     */
    public void updateSeckillNumber(String number);

    /*
     * 更新手机名称
     */
    public void updateSeckillName(String name);
}
