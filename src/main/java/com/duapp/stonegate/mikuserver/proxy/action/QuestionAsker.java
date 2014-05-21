package com.duapp.stonegate.mikuserver.proxy.action;


import com.duapp.stonegate.mikuserver.commponent.StaticInstructionManager;
import com.duapp.stonegate.mikuserver.commponent.StaticQuestionManager;
import com.duapp.stonegate.mikuserver.serilize.InstructionDTO;
import com.duapp.stonegate.mikuserver.serilize.QuestionDTO;

public class QuestionAsker extends ActionBase {
	private final String askTag="AskQuestion";
	private final String preString="我可以问你一个问题吗?";
	private final int askMikuType=1;
	@Override
	public void handle() {
		// TODO Auto-generated method stub
		prepareInstruction();
	}
	public void prepareInstruction()
	{
		QuestionDTO question=StaticQuestionManager.getMinAnswerQuestion();
		InstructionDTO ins= StaticInstructionManager.getInstructionByKey(askTag);
		instructionDTO=new InstructionDTO();
		instructionDTO.setAction(ins.getAction());
		instructionDTO.setInstruction(ins.getInstruction());
		instructionDTO.setLines(preString+question.getQuestion());
		instructionDTO.setCommand(null);
		instructionDTO.setParam(""+question.getQuestionId());
	}
}
