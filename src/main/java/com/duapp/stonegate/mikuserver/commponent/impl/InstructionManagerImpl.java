package com.duapp.stonegate.mikuserver.commponent.impl;

import com.duapp.stonegate.mikuserver.commponent.InstructionManager;
import com.duapp.stonegate.mikuserver.proxy.ProxyFactory;
import com.duapp.stonegate.mikuserver.serilize.InstructionDTO;
import com.duapp.stonegate.mikuserver.service.InstructionSearchService;
import com.duapp.stonegate.mikuserver.service.InstructionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by chao.zhu 14-4-24 下午8:47
 */
@Service("instructionManager")
public class InstructionManagerImpl implements InstructionManager {
    Logger logger= LoggerFactory.getLogger(getClass());
    @Resource
    InstructionSearchService instructionSearchService;
    @Resource
    InstructionService instructionService;

    @Override
    public InstructionDTO recognize(InstructionDTO instructionDTO) {
        logger.debug("instructionDTO=:{}",instructionDTO);
        String  handler = null;
        if (instructionDTO.getInstruction() == 0 || instructionDTO.getNextInstruction() == 0)
            handler = instructionSearchService.getInstructionNum(instructionDTO);
        else {
            handler = instructionService.getInstructionByCommand(instructionDTO);
        }
        instructionDTO.setLines(null);
        logger.debug("after instructionDTO=:{},handler=:{}",instructionDTO,handler);
        return ProxyFactory.execute(handler,instructionDTO);
    }
}
