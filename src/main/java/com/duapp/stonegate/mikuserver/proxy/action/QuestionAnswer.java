package com.duapp.stonegate.mikuserver.proxy.action;

import com.duapp.stonegate.mikuserver.commponent.StaticAnswerManager;
import com.duapp.stonegate.mikuserver.commponent.StaticInstructionManager;
import com.duapp.stonegate.mikuserver.commponent.StaticQuestionManager;
import com.duapp.stonegate.mikuserver.serilize.AnswerDTO;
import com.duapp.stonegate.mikuserver.serilize.InstructionDTO;
import com.duapp.stonegate.mikuserver.serilize.QuestionDTO;
import com.duapp.stonegate.mikuserver.util.MikuConst;

import java.util.Random;


public class QuestionAnswer extends ActionBase {
    private final String  unknownQuestion="对不起，人家知道的还太少,没办法回答这个问题";
    private final String askTag="AskQuestion";
    private final String preString="现在让我来问你一个问题好吗，";
	@Override
	public void handle() {
		findAnswer();
		Random random=new Random(System.currentTimeMillis());
		int factor=random.nextInt()% MikuConst.RAND_LIMIT;
		if(factor<=MikuConst.RAND_FACTOR)
		  askQuestion();
	}
	private void findAnswer(){
        QuestionDTO questionDTO = StaticQuestionManager.findQuestion(instructionDTO.getRecogResults());
	 if(questionDTO==null)
	 {
		 instructionDTO.setLines(unknownQuestion);
		 QuestionDTO newQuestion=new QuestionDTO(instructionDTO.getRecogResults()[0]);
		 StaticQuestionManager.saveQuestion(newQuestion);
	 }
	 else {
		 AnswerDTO answerDTO= StaticAnswerManager.getMaxRefDBAnswerByQuestionId(questionDTO.getQuestionId());
		 instructionDTO.setLines(answerDTO.getAnswer());
		 questionDTO.setAskCount(questionDTO.getAnswerCount()+1);
		 StaticQuestionManager.updateQuestion(questionDTO);
	  }
	}
	public void askQuestion()
	{
		QuestionDTO  question=StaticQuestionManager.getMinAnswerQuestion();
		InstructionDTO dbInstruction= StaticInstructionManager.getInstructionByKey(askTag);
		String line=instructionDTO.getLines()+"."+preString+question.getQuestion();
		instructionDTO.setAction(dbInstruction.getAction());
		instructionDTO.setInstruction(dbInstruction.getInstruction());
		instructionDTO.setNextInstruction(dbInstruction.getNextInstruction());
		instructionDTO.setLines(line);
		instructionDTO.setCommand(null);
		instructionDTO.setParam(""+question.getQuestionId());
	}
}
