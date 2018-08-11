package com.zheng.test.web.controller.mysql;

import com.zheng.test.model.User;
import com.zheng.test.rpc.api.UserService;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/mysql")
@Controller
public class MysqlController {

    private Logger logger = Logger.getLogger(MysqlController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value="/queryFirstUser",produces="text/html;charset=UTF-8" )
    @ResponseBody
    private String queryUser(){
        User user = userService.selectUserById(1);
        System.out.println("mybatis:[User email =] "+ user.getUserEmail());
        return user.getUserEmail();
    }

    @RequestMapping(value="/addRandomUser",produces="text/html;charset=UTF-8" )
    @ResponseBody
    private String addRandomUser(){
        User addUser = new User();
        addUser.setUserName(RandomStringUtils.randomAlphabetic(4));
        addUser.setUserEmail(new StringBuffer(RandomStringUtils.randomAlphabetic(4)).append("@126.com").toString());
        addUser.setUserPassword(RandomStringUtils.randomAlphabetic(16));
        int i = userService.addUser(addUser);
        return i + "";
    }
}