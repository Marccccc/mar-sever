package com.cloud.customer;

import com.cloud.customer.controller.UserHystrixController;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 服务调用接口
 *
 * @author cc
 */
@FeignClient(name = "cloud-service-producer", fallback = UserHystrixController.class)
public interface HelloFeignA {

    /**
     * getHello服务提供Feign调用
     *
     * @param name 接受名称
     * @return 拼接字符串结果
     */
    @RequestMapping(value = "/hello")
    public String getHello(@RequestParam(value = "name") String name);


}
