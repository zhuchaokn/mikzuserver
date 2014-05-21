package com.duapp.stonegate.mikuserver.proxy.action;

import com.duapp.stonegate.mikuserver.commponent.StaticInstructionManager;
import com.duapp.stonegate.mikuserver.commponent.StaticUserManager;
import com.duapp.stonegate.mikuserver.serilize.InstructionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import weibo4j.Timeline;
import weibo4j.model.WeiboException;

import java.io.OutputStream;

public class WeiboCommiter extends ActionBase {
    Logger logger = LoggerFactory.getLogger(getClass());
    private String accessToken;
    private String content;

    @Override
    public void handle() {
        // TODO Auto-generated method stub
        prepare();
        Timeline tm = new Timeline();
        logger.debug("Token=:{}",accessToken);
        tm.setToken(accessToken);
        try {
            weibo4j.model.Status status = tm.UpdateStatus(content);
        } catch (WeiboException e) {
            logger.error("sendWeiboError", e);
        }
        prepareDTO();
    }

    private void prepare() {
        logger.debug("user=:{}",instructionDTO.getSender());
        accessToken = StaticUserManager.getSinaToken(instructionDTO.getSender());
        String[] tmps = this.instructionDTO.getRecogResults();
        content = "#初音说#" + tmps[0];
    }

    private void prepareDTO() {
          InstructionDTO ins= StaticInstructionManager.getInstruction(instructionDTO.getNextInstruction());
          this.instructionDTO.setInstruction(ins.getInstruction());
          this.instructionDTO.setCommand(null);
          this.instructionDTO.setParam(null);
          this.instructionDTO.setAction(ins.getAction());
    }
}
