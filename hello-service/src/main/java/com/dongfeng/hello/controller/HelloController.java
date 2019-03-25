package com.dongfeng.hello.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private DiscoveryClient client;

    @GetMapping("/hello")
    public String hello() throws JsonProcessingException {
        List<String> services = client.getServices();
        logger.info(mapper.writeValueAsString(services));
        return "Hello World!";
    }

}
