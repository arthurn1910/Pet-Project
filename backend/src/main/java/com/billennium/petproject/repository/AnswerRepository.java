package com.billennium.petproject.repository;

import com.billennium.petproject.model.AnswerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends CrudRepository<AnswerEntity, Long> {

    List<AnswerEntity> findByContentContaining(String content);

    List<AnswerEntity> findByQuestionId(long id);
}
