package org.yuhang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yuhang.service.AreaService;

/**
 * Created by chinalife on 2018/5/23.
 */
@Controller
public class TestController {

    @Autowired
    AreaService areaService ;

    @RequestMapping(value = "/test")
    @ResponseBody
    String test(){
        return "test";
    }

    String getArea(){
       return null;
    }
}
