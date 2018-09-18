package com.chinalife.springmvc.service;

import com.chinalife.springmvc.dto.Exposer;
import com.chinalife.springmvc.dto.SeckillExecution;
import com.chinalife.springmvc.entity.Seckill;
import com.chinalife.springmvc.exception.RepeatKillException;
import com.chinalife.springmvc.exception.SeckillCloseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * service测试类
 * Created by chinalife on 2017/1/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:spring/spring-dao.xml",
         "classpath:spring/spring-service.xml"})
public class SeckillServiceTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() throws Exception {
        List<Seckill> seckills = seckillService.getSeckillList();
        logger.info("seckills={}",seckills);

    }

    @Test
    public void getById() throws Exception {
        Seckill seckill=seckillService.getById(2L);
        logger.info("seckill={}",seckill);

    }

    @Test
    public void exportSeckillUrl() throws Exception {
        Exposer exposer=seckillService.exportSeckillUrl(4L);
        logger.info("exposer={}",exposer);

    }

    @Test
    public void executeSeckill() throws Exception {
        long seckillId = 3L;
        long userPhone = 13810911234L;
        Exposer exposer = seckillService.exportSeckillUrl(seckillId);
        if (exposer.isExposed()) {
            logger.info("exposer={}", exposer);
            String md5 = exposer.getMd5();
            try {
                SeckillExecution seckillExecution = seckillService.executeSeckill(seckillId, userPhone, md5);
                logger.info("seckillExecution={}", seckillExecution);
            } catch (RepeatKillException e) {
                logger.error(e.getMessage());
            } catch (SeckillCloseException e) {
                logger.error(e.getMessage());
            }
        } else {
            //秒杀未开启
            logger.warn("exposer={}", exposer);
        }

    }
    @Test
    public void testAspect(){
        seckillService.testAspect();
    }

}