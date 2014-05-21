package com.duapp.stonegate.mikuserver.proxy.action;

import com.duapp.stonegate.mikuserver.commponent.StaticMessageManager;
import com.duapp.stonegate.mikuserver.serilize.Message;
import com.duapp.stonegate.mikuserver.util.UserMonitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MessageTransmiter extends ActionBase {
    private Logger logger= LoggerFactory.getLogger(getClass());
    public static final String PRE_STRING = "发来消息说";

    @Override
    public void handle() {
        // TODO Auto-generated method stub
        prepareLine();
        Message msg = new Message(instructionDTO);
        StaticMessageManager.putMessage(msg);
        instructionDTO.setLines("发送成功");
        instructionDTO.setInstruction(instructionDTO.getNextInstruction());
    }

    private void prepareLine() {
        logger.debug("insto=:{}",instructionDTO);
        String[] tmp = instructionDTO.getRecogResults();
        tmp[0] = instructionDTO.getSender() + PRE_STRING + tmp[0];
        instructionDTO.setLines(tmp[0]);
    }
}
