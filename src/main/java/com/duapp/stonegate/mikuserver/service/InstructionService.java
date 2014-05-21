package com.duapp.stonegate.mikuserver.service;

import com.duapp.stonegate.mikuserver.serilize.InstructionDTO;

/**
 * Created by chao.zhu
 * 14-4-25
 * 上午12:52
 */
public interface InstructionService {
    /**
     * 根据命令编号获取命令数据
     */
    String  getInstructionByCommand(InstructionDTO instructionDTO);

    InstructionDTO getInstructionByKey(String askTag);

    InstructionDTO getInstructionByNum(int instructionId);
}

