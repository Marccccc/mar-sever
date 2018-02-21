package com.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientTestController {

    @GetMapping("/client")
    private String testClient(){
        return "this is 2 client";
    }

    @GetMapping("/client2")
    private String testClient2(){
        return "this is xxx client";
    }
}
