package com.duapp.stonegate.mikuserver.controller;

import com.duapp.stonegate.mikuserver.commmon.JsonErrorData;
import com.duapp.stonegate.mikuserver.commponent.UserManager;
import com.duapp.stonegate.mikuserver.serilize.UserDTO;
import com.duapp.stonegate.mikuserver.util.MikuConst;
import com.duapp.stonegate.mikuserver.util.UserMonitor;
import com.duapp.stonegate.mikuserver.util.UserState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;

/**
 * Created by chao.zhu 14-4-22 下午5:50
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    UserManager userManager;
    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/logon.json", method = RequestMethod.POST)
    @ResponseBody
    public Object logon(@RequestBody UserDTO userDTO) {
        try {
            return userManager.logon(userDTO);
        } catch (Exception e) {
            return new JsonErrorData(e.getMessage());
        }
    }

    @RequestMapping(value = "/register.json", method = RequestMethod.POST)
    @ResponseBody
    public Object register(@RequestBody UserDTO userDTO) {
        try {
            return userManager.register(userDTO);
        } catch (Exception e) {
            logger.error("registerError", e);
            userDTO.setState("Failed");
            return userDTO;
        }
    }

}
