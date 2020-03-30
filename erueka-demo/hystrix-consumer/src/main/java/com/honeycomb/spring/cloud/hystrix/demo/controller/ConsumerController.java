package com.honeycomb.spring.cloud.hystrix.demo.controller;

import com.honeycomb.spring.cloud.hystrix.demo.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author maoliang
 * @version 1.0.0
 */
@RestController
public class ConsumerController {

    private final HelloService helloService;

    public ConsumerController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/ribbon-consumer")
    public String helloConsumer(){
        return helloService.helloService();
    }
}
