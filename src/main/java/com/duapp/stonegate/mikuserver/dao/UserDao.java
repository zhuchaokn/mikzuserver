package com.duapp.stonegate.mikuserver.dao;

import com.duapp.stonegate.mikuserver.entity.User;

/**
 * Created by chao.zhu
 * 14-4-22
 * 下午4:58
 */
public interface UserDao {
    public void saveUserIfNotExists(User user);
    public User getUserByUserName(String userName);
    public void setSinaToken(User user);
}
