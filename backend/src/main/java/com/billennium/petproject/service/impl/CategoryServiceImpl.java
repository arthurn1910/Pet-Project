package com.billennium.petproject.service.impl;

import com.billennium.petproject.model.CategoryEntity;
import com.billennium.petproject.repository.CategoryRepository;
import com.billennium.petproject.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryEntity getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public List<CategoryEntity> getAllCategories() {
        return newArrayList(categoryRepository.findAll());
    }

    @Override
    public CategoryEntity getCategoryById(long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalStateException("No category found for id: " + categoryId));
    }

    @Override
    public boolean addCategory(CategoryEntity category) {
        try {
            categoryRepository.save(category);
        } catch (DataAccessException exception) {
            log.error("Category save exception. Details: " + exception.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public void updateCategory(CategoryEntity category) {
        try {
            categoryRepository.save(category);
        } catch (DataAccessException exception) {
            log.error("Category update exception. Details: " + exception.getMessage());
        }
    }

    @Override
    public void deleteCategory(long categoryId) {
        categoryRepository.delete(getCategoryById(categoryId));
    }
}
