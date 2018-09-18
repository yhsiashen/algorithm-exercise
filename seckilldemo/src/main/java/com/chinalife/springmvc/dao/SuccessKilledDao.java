package com.chinalife.springmvc.dao;

import com.chinalife.springmvc.entity.SuccessKilled;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by chinalife on 2017/1/5.
 */
public interface SuccessKilledDao {
    /*
	 * 插入购买明细，可过滤重复
	 *
	 * @param seckillId ,userPhone
	 */
    int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

    /*
     * 根据id查询successKilled并携带秒杀产品对象实体
     */
    List<SuccessKilled> queryByIdWithSeckill(long seckillId);

}
