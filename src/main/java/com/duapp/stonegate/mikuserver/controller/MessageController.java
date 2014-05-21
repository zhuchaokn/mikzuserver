package com.duapp.stonegate.mikuserver.controller;

import com.duapp.stonegate.mikuserver.commponent.StaticMessageManager;
import com.duapp.stonegate.mikuserver.serilize.Message;
import com.duapp.stonegate.mikuserver.serilize.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
/**
 * Created by chao.zhu
 * 14-5-12
 * 上午11:52
 */
@Controller
@RequestMapping("/message")
public class MessageController {
    Logger logger= LoggerFactory.getLogger(getClass());
    @RequestMapping(value = "/get.json",method = RequestMethod.POST)
    @ResponseBody
    public Object getMessage(@RequestBody UserDTO userDTO){
        logger.debug("Name=:{}",userDTO.getUserName());
        List<Message>list=StaticMessageManager.getMessageList(userDTO.getUserName());
        logger.debug("Message=:{}",list);
        return list;
    }
}
