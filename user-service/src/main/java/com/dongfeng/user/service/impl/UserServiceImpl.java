package com.dongfeng.user.service.impl;

import com.dongfeng.domain.User;
import com.dongfeng.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private final Map<Long, User> USER_MAP = new HashMap<>();

    @Override
    public void add(User user) {
        USER_MAP.put(user.getId(), user);
    }

    @Override
    public void delete(Long id) {
        USER_MAP.remove(id);
    }

    @Override
    public void update(User user) {
        USER_MAP.put(user.getId(), user);
    }

    @Override
    public User get(Long id) {
        return USER_MAP.get(id);
    }
}
