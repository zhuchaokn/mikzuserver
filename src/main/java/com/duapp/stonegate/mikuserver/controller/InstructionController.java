package com.duapp.stonegate.mikuserver.controller;

import com.duapp.stonegate.mikuserver.commponent.InstructionManager;
import com.duapp.stonegate.mikuserver.serilize.InstructionDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by chao.zhu
 * 14-4-24
 * 下午8:39
 */
@Controller
@RequestMapping("/instruction")
public class InstructionController {
    @Resource
    InstructionManager instructionManager;
    @RequestMapping(value = "/recognize.json",method = RequestMethod.POST)
    @ResponseBody
    public Object recognize(@RequestBody InstructionDTO instructionDTO){
        return instructionManager.recognize(instructionDTO);
    }
}
