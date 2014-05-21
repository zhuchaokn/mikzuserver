package com.duapp.stonegate.mikuserver.commponent;

import com.duapp.stonegate.mikuserver.serilize.InstructionDTO;
import com.duapp.stonegate.mikuserver.service.InstructionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by chao.zhu
 * 14-4-27
 * 下午4:40
 */
@Service
public class StaticInstructionManager {
    static InstructionService instructionService;
    public static InstructionDTO getInstructionByKey(String askTag) {
        return instructionService.getInstructionByKey(askTag);
    }
    @Resource
    public void setInstructionService(InstructionService instructionService){
        StaticInstructionManager.instructionService=instructionService;
    }

    public static InstructionDTO getInstruction(int instructionId) {
        return instructionService.getInstructionByNum(instructionId);
    }
}
