package com.billennium.petproject.service;

import com.billennium.petproject.model.CategoryEntity;

import java.util.List;

public interface CategoryService {
    CategoryEntity getCategoryByName(String name);
    List<CategoryEntity> getAllCategories();
    CategoryEntity getCategoryById(long categoryId);
    boolean addCategory(CategoryEntity category);
    void updateCategory(CategoryEntity category);
    void deleteCategory(long categoryId);
}