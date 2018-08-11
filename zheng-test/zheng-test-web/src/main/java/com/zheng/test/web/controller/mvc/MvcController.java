package com.zheng.test.web.controller.mvc;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/mvc")
@Controller
public class MvcController {
    private Logger logger = Logger.getLogger(MvcController.class);

    @RequestMapping(value="/hello",produces="text/html;charset=UTF-8" )
    @ResponseBody
    private String hello(){
        return "hello MVC";
    }

}