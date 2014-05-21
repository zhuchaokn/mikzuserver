package com.duapp.stonegate.mikuserver.dao;

import com.duapp.stonegate.mikuserver.entity.Answer;

import java.util.List;

public interface AnswerDao {

    public List<Answer> getAllAnswerByQuestionId(int questionId);

    public List<Answer> getMaxRefDBAnswerByQuestionId(int questionId);

    public void insertAnswer(Answer answer);

    public void updateAnswer(Answer answer);
}
