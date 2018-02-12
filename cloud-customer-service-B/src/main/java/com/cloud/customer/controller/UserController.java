package com.cloud.customer.controller;

import com.cloud.customer.HelloFeignB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    HelloFeignB helloFeign;

    @PostMapping("/hello")
    public String index(@RequestBody Object user) {
        return helloFeign.postHello(user);
    }

}
