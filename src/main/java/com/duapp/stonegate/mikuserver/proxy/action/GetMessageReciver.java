package com.duapp.stonegate.mikuserver.proxy.action;


public class GetMessageReciver extends ActionBase{
	public void checkName()
	{
		String[] names=this.instructionDTO.getRecogResults();
		this.instructionDTO.setCommand(null);
		this.instructionDTO.setParam(names[0]);
	}
    @Override
    public void handle() {
        checkName();
    }
}
