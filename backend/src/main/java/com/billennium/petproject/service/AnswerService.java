package com.billennium.petproject.service;

import com.billennium.petproject.model.AnswerEntity;

import java.util.List;

public interface AnswerService {
    List<AnswerEntity> getAllAnswers();

    AnswerEntity getAnswerById(long answerId);

    boolean addAnswer(AnswerEntity answer);

    void updateAnswer(AnswerEntity answer);

    void deleteAnswer(long answerId);

    List<AnswerEntity> getAnswersByContent(String content);

    List<AnswerEntity> getAnswersByQuestionId(long questionId);
}