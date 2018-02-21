package com.cloud.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @EnableFeignClients
 * @EnableCircuitBreaker
 */
@ComponentScan("com.cloud.customer")
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
public class CustomerApplicationA {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplicationA.class, args);
    }

}
