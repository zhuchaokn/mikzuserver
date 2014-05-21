package com.duapp.stonegate.mikuserver.commponent;

import com.duapp.stonegate.mikuserver.serilize.InstructionDTO;

/**
 * Created by chao.zhu
 * 14-4-23
 * 下午11:32
 */
public interface InstructionManager {
    InstructionDTO recognize(InstructionDTO instructionDTO);
}
