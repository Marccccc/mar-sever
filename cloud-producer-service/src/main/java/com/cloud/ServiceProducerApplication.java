package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 生成服务,启动服务发现
 * @author cc
 */
@ComponentScan("com.cloud.controller")
@SpringBootApplication
@EnableDiscoveryClient
public class ServiceProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProducerApplication.class, args);
    }

}