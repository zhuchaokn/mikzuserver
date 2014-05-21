package com.duapp.stonegate.mikuserver.service;

import com.duapp.stonegate.mikuserver.serilize.QuestionDTO;

import java.util.List;

/**
 * Created by chao.zhu
 * 14-4-27
 * 下午4:27
 */
public interface QuestionService {
    List<QuestionDTO> getAllQuestion();

    void saveQuestion(QuestionDTO newQuestion);

    void updateQuestion(QuestionDTO questionDTO);

    QuestionDTO getMInAnswerQuestion();

    QuestionDTO getQuestionById(int questionId);
}
