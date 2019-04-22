package com.dongfeng.user.service;

import com.dongfeng.domain.User;

public interface UserService {
    void add(User user);

    void delete(Long id);

    void update(User user);

    User get(Long id);
}
