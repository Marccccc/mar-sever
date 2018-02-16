package com.cloud.customer;

import com.cloud.customer.controller.CustomerHystrixController;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name= "cloud-service-producer",fallback = CustomerHystrixController.class)
public interface CustomerFeign {

    @PostMapping(value = "/hello")
    public String postHello(@RequestBody Object user);

}
