package com.duapp.stonegate.mikuserver.commponent;

import com.duapp.stonegate.mikuserver.serilize.Message;
import com.duapp.stonegate.mikuserver.service.MessageService;
import com.sun.swing.internal.plaf.metal.resources.metal;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
/**
 * Created by chao.zhu
 * 14-5-12
 * 上午11:32
 */
@Service
public class StaticMessageManager {
    static MessageService messageService;
    @Resource
    public void setMessageService(MessageService messageService){
        StaticMessageManager.messageService=messageService;
    }
    public static void putMessage(Message message){
        messageService.putMessage(message);
    }
    public static List<Message> getMessageList(String userName){
        List<Message> list=messageService.getMessageList(userName);
        if(list==null){
            return Collections.emptyList();
        }
        return list;
    }
}
