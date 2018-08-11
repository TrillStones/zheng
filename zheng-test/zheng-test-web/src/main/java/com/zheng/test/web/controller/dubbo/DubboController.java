package com.zheng.test.web.controller.dubbo;

import com.zheng.test.rpc.api.DemoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/dubbo")
@Controller
public class DubboController {
    private Logger logger = Logger.getLogger(DubboController.class);

    @Autowired
    private DemoService helloService;

    @RequestMapping(value="/hello",produces="text/html;charset=UTF-8" )
    @ResponseBody
    private String dubbo(){
        return helloService.sayHello();
    }

}