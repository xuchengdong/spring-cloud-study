package com.dongfeng.ribbonconsumer.service.impl;

import com.dongfeng.ribbonconsumer.service.HelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")
    @Override
    public String hello() {
        long startTime = System.currentTimeMillis();
        String result = restTemplate.getForObject("http://HELLO-SERVICE/hello", String.class);
        long endTime = System.currentTimeMillis();
        log.info("Spend time:{}", endTime - startTime);
        return result;
    }

    public String helloFallback() {
        return "Error !";
    }

}
