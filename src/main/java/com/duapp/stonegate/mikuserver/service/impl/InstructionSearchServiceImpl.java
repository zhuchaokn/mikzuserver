package com.duapp.stonegate.mikuserver.service.impl;

import com.duapp.stonegate.mikuserver.dao.InstructionDao;
import com.duapp.stonegate.mikuserver.entity.Instruction;
import com.duapp.stonegate.mikuserver.serilize.InstructionDTO;
import com.duapp.stonegate.mikuserver.service.InstructionSearchService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by chao.zhu
 * 14-4-23
 * 下午11:25
 */
@Service("instructionSearchService")
public class InstructionSearchServiceImpl implements InstructionSearchService {
    @Resource
    InstructionDao instructionDao;
    @Override
    public String getInstructionNum(InstructionDTO instructionDTO) {
        Instruction instruction=instructionDao.getInstructionByKey(instructionDTO.getRecogResults()[0]);
        instructionDTO.update(instruction);
        return instruction==null?null:instruction.getAction();
    }
}
