package com.zheng.test.dao;

import com.zheng.test.model.User;

public interface UserDao {
    /**
     *
     * @param userId
     * @return
     */
    public User selectUserById(Integer userId);

    public int addUser(User user);
}