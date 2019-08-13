package com.honeycomb.spring.cloud.eureka.client.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author maoliang
 */
@RestController
@Slf4j
public class HelloWorldController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/hello")
    public String helloWorld(){
        String serviceName = discoveryClient.getServices().stream().findFirst().orElse("Hello-World");
        if(StringUtils.isEmpty(serviceName)){
            log.info("没有服务被发现。。。。。");
        }else{
            List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serviceName);
            log.info("{}", serviceInstances);
        }
        return "hello world";
    }
}
