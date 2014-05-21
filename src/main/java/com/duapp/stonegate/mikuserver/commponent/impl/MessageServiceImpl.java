package com.duapp.stonegate.mikuserver.commponent.impl;

import com.duapp.stonegate.mikuserver.serilize.Message;
import com.duapp.stonegate.mikuserver.service.MessageService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by chao.zhu 14-5-12 上午11:40
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {
    Logger logger= LoggerFactory.getLogger(getClass());
    private Map<String, List<Message>> map = Maps.newHashMap();

    @Override
    public void putMessage(Message message) {
        synchronized (map) {
            List<Message> list = map.get(message.getTargetUserName());
            if (list == null) {
                list = Lists.newArrayList();
            }
            list.add(message);
            map.put(message.getTargetUserName(), list);
        }
    }
    @Override
    public List<Message> getMessageList(String userName) {
        synchronized (map) {
            logger.debug("map=:{}",map);
            return map.remove(userName);
        }
    }
}
