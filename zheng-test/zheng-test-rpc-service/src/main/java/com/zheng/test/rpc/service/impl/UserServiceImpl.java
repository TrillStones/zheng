package com.zheng.test.rpc.service.impl;

import com.zheng.test.dao.UserDao;
import com.zheng.test.model.User;
import com.zheng.test.rpc.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public User selectUserById(Integer userId) {
        return userDao.selectUserById(userId);
    }

    @Override
    public int addUser(User user) {
       return userDao.addUser(user);
    }
}
