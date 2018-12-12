package com.itheima.service;

import com.itheima.po.User;

public interface UserService {

    /**
     *查找用户
     */
    User findUser(User user);

    /**
     * 保存用户
     */
    void saveUser(User user);
}
