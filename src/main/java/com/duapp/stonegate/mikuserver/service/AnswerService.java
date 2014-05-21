package com.duapp.stonegate.mikuserver.service;

import com.duapp.stonegate.mikuserver.entity.Answer;
import com.duapp.stonegate.mikuserver.serilize.AnswerDTO;

import java.util.List;

/**
 * Created by chao.zhu
 * 14-4-27
 * 下午3:53
 */
public interface AnswerService {
    public AnswerDTO getMaxRefAnswer(int questionId);

    void saveAnswer(AnswerDTO answerDTO);

    List<AnswerDTO> getAllAnswer(int questionId);

    void updateAnswer(AnswerDTO answerDTO);
}
