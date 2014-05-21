package com.duapp.stonegate.mikuserver.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.duapp.stonegate.mikuserver.entity.Question;

public interface QuestionDao {
    public int getQuestionCount();

    public Question getQuestionById(int questionId);

    public List<Question> getAllQuestion();

    public Question getMaxAnswerDBQuestion();

    public List<Question> getMinAnswerDbQuestion();

    public void insertQuestion(Question question);

    public void updateQuestion(Question question);
}
