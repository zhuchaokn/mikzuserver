package com.duapp.stonegate.mikuserver.serilize;

import com.duapp.stonegate.mikuserver.entity.Answer;
import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * Created by chao.zhu
 * 14-4-27
 * 下午4:12
 */
public class AnswerDTO implements Serializable {

    private static final long serialVersionUID = 8973592003716035197L;
    private int answerId;
    private int questionId;
    private String answer;
    private int refCount;

    public AnswerDTO() {
    }

    public AnswerDTO(Answer answerDO) {
        this.setAnswer(answerDO.getAnswer());
        this.setAnswerId(answerDO.getAnswerId());
        this.setQuestionId(answerDO.getQuestionId());
        this.setRefCount(answerDO.getRefCount());
    }

    public AnswerDTO(int answerId, int questionId, String answer, int refCount) {
        this.answerId = answerId;
        this.questionId = questionId;
        this.answer = answer;
        this.refCount = refCount;
    }

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

    public Answer toAnswer() {
        Answer ans=new Answer();
        ans.setQuestionId(questionId);
        ans.setAnswer(answer);
        ans.setRefCount(refCount);
        return ans;
    }

    public static List<AnswerDTO> toAnswerDTOList(List<Answer> list) {
        if(list==null||list.isEmpty()){
            return Collections.emptyList();
        }
        List<AnswerDTO> res= Lists.newArrayList();
        for(Answer ans:list){
            res.add(new AnswerDTO(ans));
        }
        return res;
    }
}
