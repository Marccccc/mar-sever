package com.cloud.customer;

import com.cloud.customer.controller.UserHystrixController;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name= "cloud-service-producer",fallback = UserHystrixController.class)
public interface HelloFeignB {

    @PostMapping(value = "/hello")
    public String postHello(@RequestBody Object user);

}
