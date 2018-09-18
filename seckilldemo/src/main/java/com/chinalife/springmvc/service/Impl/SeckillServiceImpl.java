package com.chinalife.springmvc.service.Impl;

import com.chinalife.springmvc.annotation.DynamicDataSource;
import com.chinalife.springmvc.dao.SeckillDao;
import com.chinalife.springmvc.dao.SuccessKilledDao;
import com.chinalife.springmvc.dto.Exposer;
import com.chinalife.springmvc.dto.SeckillExecution;
import com.chinalife.springmvc.entity.Seckill;
import com.chinalife.springmvc.entity.SuccessKilled;
import com.chinalife.springmvc.enums.SeckillStatEnum;
import com.chinalife.springmvc.exception.RepeatKillException;
import com.chinalife.springmvc.exception.SeckillCloseException;
import com.chinalife.springmvc.exception.SeckillException;
import com.chinalife.springmvc.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by chinalife on 2017/1/6.
 */

@Service
public class SeckillServiceImpl implements SeckillService {

    private final Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillDao seckillDao;

    @Autowired
    private SuccessKilledDao successKilledDao;

    //MD5盐值，用于获取MD5密码
    private final String salt="alksdkalnsklaejkbajk,aasdl;jiajsd;asdaksldn";

    public SeckillServiceImpl(SuccessKilledDao successKilledDao) {
        this.successKilledDao = successKilledDao;
    }

    /**
     * 查询所有秒杀商品信息
     *
     * @return List
     */
    public List<Seckill> getSeckillList() {
        List<Seckill> seckills=seckillDao.queryAll(1,4);
        return seckills;
    }

    /**
     * 查询单个秒杀商品信息
     *
     * @param seckillId
     * @return Seckill
     */
    public Seckill getById(long seckillId) {
        Seckill seckill =seckillDao.queryById(seckillId);
        return seckill;
    }

    /**
     * 秒杀开启时输出秒杀接口地址，
     * 否则输出系统时间和秒杀时间
     *
     * @param seckillId
     * @return Exposer
     */
    public Exposer exportSeckillUrl(long seckillId) {
        Seckill seckill = seckillDao.queryById(seckillId);
        if(seckill == null){
            return new Exposer(false,seckillId);
        }
        Date startTime = seckill.getStartTime();
        Date endTime = seckill.getEndTime();
        //系统当前时间
        Date nowTime= new Date();
        //如果当前时间比秒杀结束时间晚，或者比秒杀开启时间早，则秒杀无效，返回false Exposer
        if(nowTime.getTime() > endTime.getTime()
                || nowTime.getTime()<startTime.getTime()){
            return new Exposer(false,seckillId,nowTime.getTime(),startTime.getTime(),endTime.getTime());
        }
         String md5= getMD5(seckillId);
         return new Exposer(true,md5,seckillId);
    }

    // 生成md5加盐密码
    private String getMD5(long seckillId){
        String base = seckillId+"/"+salt;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;

    }

    /**
     * 此方法执行秒杀逻辑：减库存+记录秒杀行为
     * 使用注解控制事务方法的优点：
     * 1.开发团队达成一致约定，明确标注事务方法的编程风格
     * 2.保证事务方法的执行时间尽可能短，不要穿插其他网络操作，如RPC/HTTP请求，实在需要穿插则剥离到事务方法外部
     * 3.不是所有的方法都需要事务，如只有一条修改操作，只读操作不需要事务控制
     * @param seckillId
     * @param userPhone
     * @param md5
     * @return SeckillExecution
     * @throws SeckillException
     */
    @Transactional
    public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) throws SeckillException {
        if (md5 == null || !md5.equals(getMD5(seckillId))) {
            throw new SeckillException("md5密码被篡改");
        }

         Date nowTime = new Date();
         int updateCount = seckillDao.reduceNumber(seckillId, nowTime);
         if (updateCount <= 0) {
             throw new SeckillCloseException("秒杀已结束");
         } else {
             //向success_killed表中插入秒杀成功的用户信息
             int insertCount = successKilledDao.insertSuccessKilled(seckillId, userPhone);
             //唯一：seckillId,userPhone
             if (insertCount <= 0) {
                 //重复秒杀
                 throw new RepeatKillException("用户重复秒杀");
             } else {
                 //秒杀成功
                 List<SuccessKilled> successKilledList = successKilledDao.queryByIdWithSeckill(seckillId);
                 return new SeckillExecution(seckillId, SeckillStatEnum.SUCCESS, successKilledList);
             }
         }
    }
    /**
     * ajax查询版本号
     */
    public String selectVersionID(String id){
        String versionID=seckillDao.selectVersionID(id);
        return versionID;
    }

    /**
     * 测试事务方法
     */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public void updateSeckill() throws Exception {
        try {
            seckillDao.updateSeckillName("iphone111");
        }catch (Exception e){
//            throw new Exception("名字重复");
            System.out.println("名字重复");
        }

        try {
            seckillDao.updateSeckillNumber("30");
        }catch (Exception e){
//            throw new Exception("数目重复");
            System.out.println("数目重复");
        }


    }
    @DynamicDataSource(value = "111")
    public void testAspect() {
        System.out.println("do something...");
    }

}
