package com.itheima.dao;

import com.itheima.po.User;

public interface UserDao {
    /**
     *查找用户
     */

    User findUser(User user);

    /**
     * 保存用户
     */
    void saveUser(User user);
}
