package com.dongfeng.hello.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@Slf4j
@RestController
public class HelloController {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private DiscoveryClient client;

    @GetMapping("/hello")
    public String hello() throws JsonProcessingException, InterruptedException {
        List<String> services = client.getServices();
        log.info(mapper.writeValueAsString(services));

        int sleepTime = new Random().nextInt(3000);
        log.info("sleep time:{}", sleepTime);
        Thread.sleep(sleepTime);

        return "Hello World!";
    }

}
