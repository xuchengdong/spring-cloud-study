package com.dongfeng.userservice.controller;

import com.dongfeng.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user")
    public User hello(Long id) {
        User user = new User();
        user.setId(id);
        return user;
    }
}
