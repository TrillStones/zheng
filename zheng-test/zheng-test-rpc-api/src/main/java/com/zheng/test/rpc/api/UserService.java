package com.zheng.test.rpc.api;

import com.zheng.test.model.User;

public interface UserService {
    User selectUserById(Integer userId);

    int addUser(User user);
}