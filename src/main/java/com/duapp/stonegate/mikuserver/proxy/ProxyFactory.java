package com.duapp.stonegate.mikuserver.proxy;

import com.duapp.stonegate.mikuserver.proxy.action.ActionBase;
import com.duapp.stonegate.mikuserver.serilize.InstructionDTO;
import com.duapp.stonegate.mikuserver.util.MikuConst;

/**
 * Created by chao.zhu
 * 14-4-25
 * 上午1:11
 */
public class ProxyFactory {
    public static  InstructionDTO execute(String handler,InstructionDTO instructionDTO){
        String  actionPath=ProxyFactory.class.getPackage().getName()+".action."+handler;
        try {
            ActionBase actionBase= (ActionBase) Class.forName(actionPath).newInstance();
            actionBase.setInstructionDTO(instructionDTO);
            actionBase.handle();
            return actionBase.getResult();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            instructionDTO.setLines(MikuConst.NO_ACION_ERR_MSG);
            e.printStackTrace();
        }
        return  new InstructionDTO();
    }
}
