package com.cloud.customer.controller;

import com.cloud.customer.CustomerFeign;
import org.springframework.stereotype.Component;

@Component
public class CustomerHystrixController implements CustomerFeign {

    @Override
    public String postHello(Object user) {
        return "未调用到PostUser服务";
    }

}
