package com.billennium.petproject.service.impl;

import com.billennium.petproject.model.AnswerEntity;
import com.billennium.petproject.repository.AnswerRepository;
import com.billennium.petproject.service.AnswerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Service
public class AnswerServiceImpl implements AnswerService {

    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());

    private final AnswerRepository answerRepository;

    public AnswerServiceImpl(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public List<AnswerEntity> getAllAnswers() {
        return newArrayList(answerRepository.findAll());
    }

    @Override
    public AnswerEntity getAnswerById(long answerId) {
        return answerRepository.findById(answerId)
                .orElseThrow(() -> new IllegalStateException("No answer found for id: " + answerId));
    }

    @Override
    public boolean addAnswer(AnswerEntity answer) {
        try {
            answerRepository.save(answer);
        } catch (DataAccessException exception) {
            log.error("Answer save exception. Details: " + exception.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public void updateAnswer(AnswerEntity answer) {
        try {
            answerRepository.save(answer);
        } catch (DataAccessException exception) {
            log.error("Answer update exception. Details: " + exception.getMessage());
        }
    }

    @Override
    public void deleteAnswer(long answerId) {
        answerRepository.delete(getAnswerById(answerId));
    }

    @Override
    public List<AnswerEntity> getAnswersByContent(String content) {
        return answerRepository.findByContentContaining(content);
    }

    @Override
    public List<AnswerEntity> getAnswersByQuestionId(long questionId) {
        return answerRepository.findByQuestionId(questionId);
    }
}
