package com.cloud.customer.controller;

import com.cloud.customer.HelloFeignA;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class UserHystrixController implements HelloFeignA {

    @Override
    public String getHello(String name) {
        return "getHello服务异常";
    }
}
