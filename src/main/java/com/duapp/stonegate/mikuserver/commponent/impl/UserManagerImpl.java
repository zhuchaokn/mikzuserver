package com.duapp.stonegate.mikuserver.commponent.impl;

import com.duapp.stonegate.mikuserver.commponent.UserManager;
import com.duapp.stonegate.mikuserver.serilize.UserDTO;
import com.duapp.stonegate.mikuserver.service.UserService;
import com.duapp.stonegate.mikuserver.util.UserState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by chao.zhu 14-4-22 下午6:03
 */
@Service("userManager")
public class UserManagerImpl implements UserManager {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    UserService userService;

    @Transactional
    @Override
    public UserDTO register(UserDTO userDTO){
        UserDTO user = userService.getUserByName(userDTO.getUserName());
        if (user != null) {
            userDTO.setState("Existed");
            return userDTO;
        }
        userService.registerUser(userDTO);
        userDTO.setState("Success");
        return userDTO;
    }

    @Override
    public UserDTO logon(UserDTO userDTO) throws Exception {
        try {
            logger.info("logon=:{}",userDTO);
            if (!userService.validate(userDTO)) {
                throw new Exception("用户名或密码错误");
            }
            logger.debug("userDTO=:{}", userDTO);
            return userDTO;
        } catch (Exception e) {
            logger.error("logonError", e);
            throw e;
        }
    }
}
