package com.duapp.stonegate.mikuserver.entity;

public class Question {
    private int questionId;
    private String question;
    private int answerCount;
    private int askCount;

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
}
