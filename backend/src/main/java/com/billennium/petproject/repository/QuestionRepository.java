package com.billennium.petproject.repository;

import com.billennium.petproject.model.QuestionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends CrudRepository<QuestionEntity, Long> {

    List<QuestionEntity> findByContentContaining(String content);

    List<QuestionEntity> findByCategories_Id(long id);
}
