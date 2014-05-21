package com.duapp.stonegate.mikuserver.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.duapp.stonegate.mikuserver.entity.Instruction;

public interface InstructionDao {

	public int getCommand(String command);
	public Instruction getInstructionByKey(String key);
	public Instruction getInstructionByCommandNum(int comNum);
}
