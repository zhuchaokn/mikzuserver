package com.duapp.stonegate.mikuserver.service.impl;

import com.duapp.stonegate.mikuserver.dao.InstructionDao;
import com.duapp.stonegate.mikuserver.entity.Instruction;
import com.duapp.stonegate.mikuserver.serilize.InstructionDTO;
import com.duapp.stonegate.mikuserver.service.InstructionService;
import com.duapp.stonegate.mikuserver.util.MikuConst;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by chao.zhu
 * 14-4-25
 * 上午1:21
 */
@Service("instructionService")
public class InstructionServiceImpl implements InstructionService {
    @Resource
    InstructionDao instructionDao;
    @Override
    public String  getInstructionByCommand(InstructionDTO instructionDTO) {
        Instruction instruction=instructionDao.getInstructionByCommandNum(instructionDTO.getNextInstruction());
        if(instruction!=null){
            instructionDTO.update(instruction);
         return  instruction.getAction();
        }else {
            instructionDTO.setInstruction(MikuConst.NO_COMMAND_ERROR);
            instructionDTO.setNextInstruction(0);
            instructionDTO.setAction("DefaultAction");
            return MikuConst.DEFAULT_HANDLER;
        }
    }

    @Override
    public InstructionDTO getInstructionByKey(String key) {
        return new InstructionDTO(instructionDao.getInstructionByKey(key));
    }

    @Override
    public InstructionDTO getInstructionByNum(int instructionId) {
        Instruction instruction=instructionDao.getInstructionByCommandNum(instructionId);
        return new InstructionDTO(instruction);
    }
}
