package com.cloud.customer.controller;

import com.cloud.customer.HelloFeignB;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class UserHystrixController implements HelloFeignB {

    @Override
    public String postHello(Object user) {
        return "未调用到PostUser服务";
    }

}
