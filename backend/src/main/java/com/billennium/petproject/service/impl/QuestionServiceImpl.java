package com.billennium.petproject.service.impl;

import com.billennium.petproject.model.QuestionEntity;
import com.billennium.petproject.repository.QuestionRepository;
import com.billennium.petproject.service.QuestionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Service
public class QuestionServiceImpl implements QuestionService {

    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());

    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<QuestionEntity> getAllQuestions() {
        return newArrayList(questionRepository.findAll());
    }

    @Override
    public QuestionEntity getQuestionById(long questionId) {
        return questionRepository.findById(questionId)
                .orElseThrow(() -> new IllegalStateException("No question found for id: " + questionId));
    }

    @Override
    public boolean addQuestion(QuestionEntity question) {
        try {
            questionRepository.save(question);
        } catch (DataAccessException exception) {
            log.error("Question save exception. Details: " + exception.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public void updateQuestion(QuestionEntity question) {
        try {
            questionRepository.save(question);
        } catch (DataAccessException exception) {
            log.error("Question update exception. Details: " + exception.getMessage());
        }
    }

    @Override
    public void deleteQuestion(long questionId) {
        questionRepository.delete(getQuestionById(questionId));
    }

    @Override
    public List<QuestionEntity> getQuestionsByContent(String content) {
        return questionRepository.findByContentContaining(content);
    }

    @Override
    public List<QuestionEntity> getQuestionsByCategoryId(long categoryId) {
        return questionRepository.findByCategories_Id(categoryId);
    }
}
