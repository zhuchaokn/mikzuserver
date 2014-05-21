package com.duapp.stonegate.mikuserver.service.impl;

import com.duapp.stonegate.mikuserver.dao.AnswerDao;
import com.duapp.stonegate.mikuserver.entity.Answer;
import com.duapp.stonegate.mikuserver.serilize.AnswerDTO;
import com.duapp.stonegate.mikuserver.service.AnswerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * Created by chao.zhu
 * 14-4-27
 * 下午4:09
 */
@Service("answerService")
public class AnswerServiceImpl implements AnswerService {
    @Resource
    AnswerDao answerDao;
    @Override
    public AnswerDTO getMaxRefAnswer(int questionId) {
        List<Answer> list=answerDao.getMaxRefDBAnswerByQuestionId(questionId);
        if(list==null||list.isEmpty()){
            return null;
        }
        return new AnswerDTO(list.get(0));
    }

    @Override
    public void saveAnswer(AnswerDTO answerDTO) {
        answerDao.insertAnswer(answerDTO.toAnswer());
    }

    @Override
    public List<AnswerDTO> getAllAnswer(int questionId) {
        return AnswerDTO.toAnswerDTOList(answerDao.getAllAnswerByQuestionId(questionId));
    }

    @Override
    public void updateAnswer(AnswerDTO answerDTO) {
        answerDao.updateAnswer(answerDTO.toAnswer());
    }
}
