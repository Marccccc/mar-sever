package com.cloud.customer.controller;

import com.cloud.customer.CustomerFeign;
import org.springframework.stereotype.Component;

@Component
public class CustomerHystrixController implements CustomerFeign {

    @Override
    public String getHello(String name) {
        return "getHello服务异常";
    }
    
}
