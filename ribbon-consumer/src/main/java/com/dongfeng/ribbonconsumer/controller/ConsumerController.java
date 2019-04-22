package com.dongfeng.ribbonconsumer.controller;

import com.dongfeng.domain.User;
import com.dongfeng.ribbonconsumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/ribbon-consumer")
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    public String helloConsumer() {
        return helloService.hello();
    }

    @PostMapping("/user")
    public String add(@RequestBody User user) {
        return restTemplate.postForObject("http://USER-SERVICE/user", user, String.class);
    }

    @DeleteMapping("/users/{id}")
    public String delete(@PathVariable("id") Long id) {
        restTemplate.delete("http://USER-SERVICE/users/{1}", id);
        return "success";
    }

    @PutMapping("/user")
    public String update(@RequestBody User user) {
        restTemplate.put("http://USER-SERVICE/user", user);
        return "success";
    }

    @GetMapping("/users/{id}")
    public User get(@PathVariable("id") Long id) {
        return restTemplate.getForObject("http://USER-SERVICE/users/{1}", User.class, id);
    }
}
