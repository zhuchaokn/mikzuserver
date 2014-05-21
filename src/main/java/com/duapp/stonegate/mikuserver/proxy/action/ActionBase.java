package com.duapp.stonegate.mikuserver.proxy.action;

import com.duapp.stonegate.mikuserver.serilize.InstructionDTO;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;



public abstract class ActionBase {
	protected InstructionDTO instructionDTO;
	public void setInstructionDTO(InstructionDTO instructionDTO) {
		this.instructionDTO = instructionDTO;
	}
	public InstructionDTO getResult()
	{
        return this.instructionDTO;
	}
	public abstract void handle();
}
