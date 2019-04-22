package com.dongfeng.ribbonconsumer.service.impl;

import com.dongfeng.ribbonconsumer.service.HelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")
    @Override
    public String hello() {
        return restTemplate.getForObject("http://HELLO-SERVICE/hello", String.class);
    }

    public String helloFallback() {
        return "Error !";
    }

}
