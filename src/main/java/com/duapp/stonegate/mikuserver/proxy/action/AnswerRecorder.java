package com.duapp.stonegate.mikuserver.proxy.action;

import com.duapp.stonegate.mikuserver.commponent.StaticAnswerManager;
import com.duapp.stonegate.mikuserver.commponent.StaticInstructionManager;
import com.duapp.stonegate.mikuserver.commponent.StaticQuestionManager;
import com.duapp.stonegate.mikuserver.serilize.AnswerDTO;
import com.duapp.stonegate.mikuserver.serilize.InstructionDTO;
import com.duapp.stonegate.mikuserver.serilize.QuestionDTO;

public class AnswerRecorder extends ActionBase {
    private final String THNAKS = "谢谢你的回答，现在你可以问我问题了。";

    @Override
    public void handle() {
        // TODO Auto-generated method stub
        recorderAnswer();
        preparedDTO();
    }

    /**
     * 解析收到的答案，将答案写入数据库中
     */
    private void recorderAnswer() {
          int questionId = Integer.parseInt(instructionDTO.getParam());
        QuestionDTO questionDTO= StaticQuestionManager.getQuestionById(questionId);
        if (questionDTO == null){
            return;
        }
        questionDTO.setAnswerCount(questionDTO.getAnswerCount()+1);
        if (questionDTO.getAnswerCount() == 0) {
            AnswerDTO answerDTO=new AnswerDTO(0,questionId,instructionDTO.getRecogResults()[0],1);
            StaticAnswerManager.saveAnswer(answerDTO);
        } else {
            AnswerDTO answerDTO=StaticAnswerManager.findAnswer(questionId,instructionDTO.getRecogResults());
            if (answerDTO != null) {
                answerDTO.setRefCount(answerDTO.getRefCount() + 1);
               StaticAnswerManager.updateAnswer(answerDTO);
            } else {
                AnswerDTO answer=new AnswerDTO(0,questionId,instructionDTO.getRecogResults()[0],1);
                StaticAnswerManager.saveAnswer(answer);
            }
        }
        questionDTO.setAnswerCount(questionDTO.getAnswerCount() + 1);
        StaticQuestionManager.updateQuestion(questionDTO);
    }

    public void preparedDTO() {
        InstructionDTO ins=StaticInstructionManager.getInstruction(instructionDTO.getNextInstruction());
        this.instructionDTO.setInstruction(ins.getInstruction());
        this.instructionDTO.setCommand(null);
        this.instructionDTO.setParam(null);
        this.instructionDTO.setAction(ins.getAction());
        this.instructionDTO.setLines(THNAKS);
    }
}
