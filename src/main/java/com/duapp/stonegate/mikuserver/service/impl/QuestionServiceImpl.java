package com.duapp.stonegate.mikuserver.service.impl;

import com.duapp.stonegate.mikuserver.dao.QuestionDao;
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
@Service("questionService")
public class QuestionServiceImpl implements QuestionService {
    @Resource
    QuestionDao questionDao;
    @Override
    public List<QuestionDTO> getAllQuestion() {
        return QuestionDTO.toList(questionDao.getAllQuestion());
    }

    @Override
    public void saveQuestion(QuestionDTO newQuestion) {
        questionDao.insertQuestion(newQuestion.toQuestion());
    }

    @Override
    public void updateQuestion(QuestionDTO questionDTO) {
        questionDao.updateQuestion(questionDTO.toQuestion());
    }

    @Override
    public QuestionDTO getMInAnswerQuestion() {
        List<Question> list=questionDao.getMinAnswerDbQuestion();
        if(list==null||list.isEmpty()){
            return null;
        }
        return new QuestionDTO(list.get(0));
    }

    @Override
    public QuestionDTO getQuestionById(int questionId) {
        Question question=questionDao.getQuestionById(questionId);
        return new QuestionDTO(question);
    }
}
