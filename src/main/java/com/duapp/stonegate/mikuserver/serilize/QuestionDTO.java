package com.duapp.stonegate.mikuserver.serilize;

import com.duapp.stonegate.mikuserver.entity.Question;
import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * Created by chao.zhu
 * 14-4-27
 * 下午4:31
 */
public class QuestionDTO implements Serializable {

    private static final long serialVersionUID = -9166563301793309729L;
    private int questionId;
    private String question;
    private int answerCount;
    private int askCount;

    public QuestionDTO(String question) {
        this.question = question;
        this.answerCount=0;
        this.askCount=1;
    }

    public QuestionDTO(Question questionDO) {
        this.setQuestionId(questionDO.getQuestionId());
        this.setQuestion(questionDO.getQuestion());
        this.setAnswerCount(questionDO.getAnswerCount());
        this.setAskCount(questionDO.getAskCount());
    }

    public void setAskCount(int askCount) {
        this.askCount = askCount;
    }

    public int getAskCount() {
        return askCount;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public void setAnswerCount(int answerCount) {
        this.answerCount = answerCount;
    }

    public int getAnswerCount() {
        return answerCount;
    }

    public String getQuestion() {
        return question;
    }

    public int getQuestionId() {
        return questionId;
    }

    public static List<QuestionDTO> toList(List<Question> allQuestion) {
        if(allQuestion==null||allQuestion.isEmpty()){
            return Collections.emptyList();
        }
        List<QuestionDTO> questionDTOList= Lists.newArrayList();
        for(Question que:allQuestion){
            questionDTOList.add(new QuestionDTO(que));
        }
        return questionDTOList;
    }

    public Question toQuestion() {

        Question que=new Question();
        que.setQuestion(this.getQuestion());
        que.setQuestionId(this.getQuestionId());
        que.setAnswerCount(this.getAnswerCount());
        que.setAskCount(this.askCount);
        return que;
    }
}
