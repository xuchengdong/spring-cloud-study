package com.dongfeng.user.controller;

import com.dongfeng.domain.User;
import com.dongfeng.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public String add(@RequestBody User user) {
        userService.add(user);
        return "success";
    }

    @DeleteMapping("/users/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "success";
    }

    @PutMapping("/user")
    public String update(@RequestBody User user) {
        userService.update(user);
        return "success";
    }

    @GetMapping("/users/{id}")
    public User get(@PathVariable("id") Long id) {
        return userService.get(id);
    }
}
