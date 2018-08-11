package com.zheng.test.web.controller.mybatis;

import com.zheng.test.model.User;
import com.zheng.test.rpc.api.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/mybatis")
@Controller
public class MybatisController {
    private Logger logger = Logger.getLogger(MybatisController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value="/mybatis",produces="text/html;charset=UTF-8" )
    @ResponseBody
    private String selectUserByIdTest(){
        User user = userService.selectUserById(1);
        System.out.println("mybatis:[User email =] "+ user.getUserEmail());
        return user.getUserEmail();
    }
}