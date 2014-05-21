package com.duapp.stonegate.mikuserver.entity;

public class Answer {
    private int answerId;
    private int questionId;
    private String answer;
    private int refCount;

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public void setRefCount(int refCount) {
        this.refCount = refCount;
    }

    public String getAnswer() {
        return answer;
    }

    public int getAnswerId() {
        return answerId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public int getRefCount() {
        return refCount;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerId=" + answerId +
                ", questionId=" + questionId +
                ", answer='" + answer + '\'' +
                ", refCount=" + refCount +
                '}';
    }
}
