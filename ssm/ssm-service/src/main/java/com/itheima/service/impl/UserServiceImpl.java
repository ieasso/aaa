package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.po.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    public User findUser(User user) {
       return userDao.findUser(user);
    }

    /**
     * 保存用户
     *
     * @param user
     */
    public void saveUser(User user) {
        userDao.saveUser(user);
    }
}
