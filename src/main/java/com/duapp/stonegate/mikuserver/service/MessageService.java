package com.duapp.stonegate.mikuserver.service;

import com.duapp.stonegate.mikuserver.serilize.Message;

import java.util.List;

/**
 * Created by chao.zhu
 * 14-5-12
 * 上午11:39
 */

public interface MessageService {
    void putMessage(Message message);

    List<Message> getMessageList(String userName);
}
