package com.duapp.stonegate.mikuserver.service.impl;

import com.duapp.stonegate.mikuserver.dao.UserDao;
import com.duapp.stonegate.mikuserver.entity.User;
import com.duapp.stonegate.mikuserver.serilize.UserDTO;
import com.duapp.stonegate.mikuserver.service.UserService;
import com.sun.naming.internal.FactoryEnumeration;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by chao.zhu 14-4-22 下午6:05
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    UserDao userDao;

    @Override
    public void registerUser(UserDTO userDTO) {
        User user = userDTO.toUser();
    }

    @Override
    public boolean validate(UserDTO userDTO) throws Exception {
        User user = userDao.getUserByUserName(userDTO.getUserName());
        if (user == null) {
            return false;
        }
        if (!user.getPassWord().equals(userDTO.getPassWord())) {
            return false;
        }
        userDTO.setEmail(user.getUserEmail());
        userDTO.setMikuType(user.getMikuType());
        if (userDTO.getSinaToken() != null && userDTO.getSinaToken() != user.getSinaToken()) {
            user.setSinaToken(userDTO.getSinaToken());
            userDao.setSinaToken(user);
        } else {
            userDTO.setSinaToken(user.getSinaToken());
        }
        return true;
    }

    @Override
    public UserDTO getUserByName(String userName) {
        User user = userDao.getUserByUserName(userName);
        if (user == null) {
            return null;
        }
        return new UserDTO(user);
    }
}
