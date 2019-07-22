package com.billennium.petproject.service;

import com.billennium.petproject.model.QuestionEntity;

import java.util.List;

public interface QuestionService {
    List<QuestionEntity> getAllQuestions();

    QuestionEntity getQuestionById(long questionId);

    boolean addQuestion(QuestionEntity question);

    void updateQuestion(QuestionEntity question);

    void deleteQuestion(long questionId);

    List<QuestionEntity> getQuestionsByContent(String content);

    List<QuestionEntity> getQuestionsByCategoryId(long categoryId);
}