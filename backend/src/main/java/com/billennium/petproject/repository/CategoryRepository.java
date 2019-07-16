package com.billennium.petproject.repository;

import com.billennium.petproject.model.CategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {
    CategoryEntity findByName(String name);
}
