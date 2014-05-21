package com.duapp.stonegate.mikuserver.commponent;

import com.duapp.stonegate.mikuserver.entity.Question;
import com.duapp.stonegate.mikuserver.serilize.QuestionDTO;
import com.duapp.stonegate.mikuserver.service.QuestionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * Created by chao.zhu
 * 14-4-27
 * 下午4:28
 */
@Service
public class StaticQuestionManager {
    static QuestionService questionService;
    public static QuestionDTO findQuestion(String[] recogResults) {
        //暂时使用全文匹配
        List<QuestionDTO> questionDTOList=questionService.getAllQuestion();
        for(QuestionDTO dto:questionDTOList){
            if(recogResults[0].equals(dto.getQuestion())){
                return dto;
            }
        }
        return  null;
    }

    public static void saveQuestion(QuestionDTO newQuestion) {
        questionService.saveQuestion(newQuestion);
    }

    public static void updateQuestion(QuestionDTO questionDTO) {
        questionService.updateQuestion(questionDTO);
    }

    public static QuestionDTO getMinAnswerQuestion() {
        return questionService.getMInAnswerQuestion();
    }
    @Resource
    public void setQuestionService(QuestionService questionService){
        StaticQuestionManager.questionService=questionService;
    }

    public static QuestionDTO getQuestionById(int questionId) {
        return  questionService.getQuestionById(questionId);
    }
}
