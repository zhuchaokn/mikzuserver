package com.duapp.stonegate.mikuserver.controller;

import com.duapp.stonegate.mikuserver.commponent.UserManager;
import com.duapp.stonegate.mikuserver.dao.UserDao;
import com.duapp.stonegate.mikuserver.serilize.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by chao.zhu
 * 14-4-28
 * 上午12:39
 */
@Controller
@RequestMapping("/check")
public class CheckController {
    @Resource
    UserManager userManager;
    @RequestMapping("/user.json")
    @ResponseBody
    public Object check(){
        UserDTO userDTO=new UserDTO();
        userDTO.setUserName("123");
        userDTO.setPassWord("123");
        try {
            return userManager.logon(userDTO);
        } catch (Exception e) {
            return  e;
        }
    }
}
