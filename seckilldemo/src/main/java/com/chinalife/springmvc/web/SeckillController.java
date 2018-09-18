package com.chinalife.springmvc.web;

import com.chinalife.springmvc.dto.Exposer;
import com.chinalife.springmvc.dto.SeckillExecution;
import com.chinalife.springmvc.dto.SeckillResult;
import com.chinalife.springmvc.entity.Seckill;
import com.chinalife.springmvc.enums.SeckillStatEnum;
import com.chinalife.springmvc.exception.RepeatKillException;
import com.chinalife.springmvc.exception.SeckillCloseException;
import com.chinalife.springmvc.service.SeckillService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * Created by chinalife on 2017/1/8.
 */

@Controller
@RequestMapping("/seckill") //表示该类下所有的请求都是以/seckill这个模块作为父路径
public class SeckillController {

    private  final  Logger  logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    private volatile AtomicInteger count = new AtomicInteger(0);

    //获取所有秒杀商品的信息的url
    @RequestMapping(value = "/tolist",method = RequestMethod.GET)
    public ModelAndView list(){
        ModelAndView view = new ModelAndView("list");
        List<Seckill> list= null;
        try {
            System.out.println("打印测试页");
            logger.info("测试用");
            //获取列表页
           list=seckillService.getSeckillList();

        }catch (Exception e){
            e.printStackTrace();
            return view;
        }
        view.addObject("list",list);
        return view;

    }

    //根据传过来的seckillId获取详细商品信息的url
    @RequestMapping(value = "/{seckillId}/detail",method = RequestMethod.GET)
    public ModelAndView detail(@PathVariable("seckillId") Long seckillId, ModelAndView view){
      if(seckillId == null){
          view.setViewName("list");
          return view;
      }else{
          Seckill seckill=seckillService.getById(seckillId);
          if(seckill == null){
              view.setViewName("list");
              return view;
          }else{
              view.addObject("seckill",seckill);
              view.setViewName("detail");
              return view;
          }
      }
    }

    //ajax接口，返回json类型数据
    @RequestMapping(value = "/{seckillId}/exposer",method = RequestMethod.POST,
                    produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SeckillResult<Exposer> exposer(@PathVariable("seckillId") Long seckillId){
        try {
            Exposer exposer = seckillService.exportSeckillUrl(seckillId);
            return new SeckillResult<Exposer>(true,exposer);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            return new SeckillResult<Exposer>(false,e.getMessage());
        }

    }

    @RequestMapping(value = "/{seckillId}/{md5}/execution",method = RequestMethod.GET,
                    produces = "application/json;charset=UTF-8")
    @ResponseBody
    public SeckillResult<SeckillExecution> execute(@PathVariable("seckillId") Long seckillId, @CookieValue(value = "killPhone",required = false) Long userPhone, @PathVariable("md5") String md5){
        if(userPhone==null){
            return new SeckillResult<SeckillExecution>(false,"用户未登陆");
        }

        try {
            SeckillExecution execution = seckillService.executeSeckill(seckillId, userPhone, md5);
            return new SeckillResult<SeckillExecution>(true, execution);
        }catch (RepeatKillException e){
            SeckillExecution seckillExecution = new SeckillExecution(seckillId, SeckillStatEnum.REPEAT_KILL);
            return new SeckillResult<SeckillExecution>(true,seckillExecution);
        }catch (SeckillCloseException e){
            SeckillExecution seckillExecution = new SeckillExecution(seckillId,SeckillStatEnum.END);
            return new SeckillResult<SeckillExecution>(true,seckillExecution);
        }catch(Exception e){
            logger.error(e.getMessage());
            return new SeckillResult<SeckillExecution>(true,e.getMessage());
        }
    }

    //封装系统当前时间的json
    @RequestMapping(value = "/time/now",method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SeckillResult<Long> time(){
        Date date = new Date();
        return new SeckillResult<Long>(true,date.getTime());
    }

    @RequestMapping("/transaction")
    public ModelAndView testTransaction(HttpServletRequest request){
       ModelAndView view = new ModelAndView();
        try {
            seckillService.updateSeckill();
        } catch (Exception e) {
            System.out.println("捕获的异常为:"+e.getMessage());
            if(e.getMessage().equals("数目重复")){
                System.out.println("成功" +
                        "区分异常");
            }else{
                System.out.println("区分异常失败");
            }

        }
        view.setViewName("index.jsp");
        return view;
    }
}
