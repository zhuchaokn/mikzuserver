package com.duapp.stonegate.mikuserver.commponent;

import com.duapp.stonegate.mikuserver.entity.Answer;
import com.duapp.stonegate.mikuserver.entity.Question;
import com.duapp.stonegate.mikuserver.serilize.AnswerDTO;
import com.duapp.stonegate.mikuserver.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * Created by chao.zhu
 * 14-4-27
 * 下午3:52
 */
@Service
public class StaticAnswerManager {
    static AnswerService answerService;

    public static AnswerDTO getMaxRefDBAnswerByQuestionId(int questionId) {
        return answerService.getMaxRefAnswer(questionId);
    }
    @Autowired(required = true)
    public void setAnswerService(AnswerService answerService){
        StaticAnswerManager.answerService=answerService;
    }

    public static void saveAnswer(AnswerDTO answerDTO) {
        answerService.saveAnswer(answerDTO);
    }

    public static AnswerDTO findAnswer(int questionId,String[] recogResults) {
        List<AnswerDTO> list=answerService.getAllAnswer(questionId);
        if(list==null||list.isEmpty()){
            return null;
        }
        for(AnswerDTO answerDTO:list){
            if(answerDTO.getAnswer().equals(recogResults[0])){
                return answerDTO;
            }
        }
        return  null;
    }

    public static void updateAnswer(AnswerDTO answerDTO) {
        answerService.updateAnswer(answerDTO);
    }
}
