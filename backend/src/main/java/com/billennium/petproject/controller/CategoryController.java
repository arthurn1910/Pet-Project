package com.billennium.petproject.controller;

import com.billennium.petproject.model.CategoryEntity;
import com.billennium.petproject.service.CategoryService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("category")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("name/{name}")
    public ResponseEntity categoryByName(@PathVariable String name) {
        CategoryEntity category = categoryService.getCategoryByName(name);
        return new ResponseEntity(category, HttpStatus.OK);
    }

    @GetMapping("list")
    public ResponseEntity<List<CategoryEntity>> getAllCategories() {
        List<CategoryEntity> list = categoryService.getAllCategories();
        return new ResponseEntity<List<CategoryEntity>>(list, HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<Void> addCategory(@RequestBody CategoryEntity category, UriComponentsBuilder builder) {
        boolean added = categoryService.addCategory(category);
        if (!added) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("id/{id}").buildAndExpand(category.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @PutMapping("update")
    public ResponseEntity<CategoryEntity> updateCategory(@RequestBody CategoryEntity category) {
        categoryService.updateCategory(category);
        return new ResponseEntity<CategoryEntity>(category, HttpStatus.OK);
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") Integer id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
