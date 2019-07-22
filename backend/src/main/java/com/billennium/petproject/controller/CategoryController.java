package com.billennium.petproject.controller;

import com.billennium.petproject.model.CategoryEntity;
import com.billennium.petproject.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("category")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CategoryController extends BaseController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("name/{name}")
    public ResponseEntity categoryByName(@PathVariable String name) {
        CategoryEntity category = categoryService.getCategoryByName(name);
        return new ResponseEntity(category, OK);
    }

    @GetMapping("list")
    public ResponseEntity<List<CategoryEntity>> getAllCategories() {
        List<CategoryEntity> list = categoryService.getAllCategories();
        return new ResponseEntity<List<CategoryEntity>>(list, OK);
    }

    @PostMapping("save")
    public ResponseEntity<Void> addCategory(@RequestBody CategoryEntity category) {
        boolean created = categoryService.addCategory(category);
        return validateCreationAndCreateResponse(created, category);
    }

    @PutMapping("update")
    public ResponseEntity<CategoryEntity> updateCategory(@RequestBody CategoryEntity category) {
        categoryService.updateCategory(category);
        return new ResponseEntity<CategoryEntity>(category, OK);
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") Integer id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<Void>(NO_CONTENT);
    }
}
