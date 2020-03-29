package com.honeycomb.spring.cloud.config.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maoliang
 * @version 1.0.0
 */
@RefreshScope
@RestController
@ResponseBody
public class TestController {

    @Value("${from}")
    private String from;

    @Autowired
    private ContextRefresher contextRefresher;

    @GetMapping("/from")
    public String obtainForm(){
        return from;
    }

    @GetMapping("/refresh")
    public String refresh(){
        contextRefresher.refresh();
        return "success";
    }
}
