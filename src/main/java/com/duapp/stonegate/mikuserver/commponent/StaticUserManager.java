package com.duapp.stonegate.mikuserver.commponent;

import com.duapp.stonegate.mikuserver.serilize.AnswerDTO;
import com.duapp.stonegate.mikuserver.serilize.UserDTO;
import com.duapp.stonegate.mikuserver.service.AnswerService;
import com.duapp.stonegate.mikuserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chao.zhu 14-5-6 下午4:07
 */
@Service
public class StaticUserManager {

    static UserService userService;

    @Autowired(required = true)
    public void setUserService(UserService userService) {
        StaticUserManager.userService = userService;
    }

    public static String getSinaToken(String userName) {
        UserDTO userDTO = userService.getUserByName(userName);
        if (userDTO == null) {
            return null;
        }
        return userDTO.getSinaToken();
    }
}
