package com.zheng.test.rpc.service.impl;

import com.zheng.test.rpc.api.DemoService;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService{
    @Override
    public String sayHello() {
        return "hello DUBBO";
    }
}
