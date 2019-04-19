package com.dongfeng.ribbonconsumer.controller;

import com.dongfeng.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/ribbon-consumer")
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/hello")
    public String helloConsumer() {
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();
    }

    @GetMapping("/user")
    public User userConsumer(long id) {
        return restTemplate.getForEntity("http://USER-SERVICE/user?id={1}", User.class, id).getBody();
    }
}
