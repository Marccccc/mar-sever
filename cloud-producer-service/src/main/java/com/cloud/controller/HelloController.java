package com.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * 服务提供示例
 *
 * @author cc
 */
//@RefreshScope
//@RestController
public class HelloController {

    @Value("${cloud-config.belong}")
    String value;

    @GetMapping("/config")
    public String cloudConfig() {
        return "test " + value + " , now it is";
    }

    @GetMapping("/hello")
    public String producerGetHello(@RequestParam String name) {
        return "hello " + name + "，you are get request";
    }

    @PostMapping("/hello")
    public String producerPostHello(@RequestBody User user) {
        return "hello " + user.getName() + "，you are post request";
    }

    private static class User {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
