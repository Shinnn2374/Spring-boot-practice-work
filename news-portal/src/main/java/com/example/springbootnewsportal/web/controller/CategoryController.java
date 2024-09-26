package com.example.springbootnewsportal.web.controller;

import com.example.springbootnewsportal.mapper.CategoryMapper;
import com.example.springbootnewsportal.model.Category;
import com.example.springbootnewsportal.service.CategoryService;
import com.example.springbootnewsportal.web.model.category.CategoryListResponse;
import com.example.springbootnewsportal.web.model.category.CategoryResponse;
import com.example.springbootnewsportal.web.model.category.UpsertCategoryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController
{
    @Autowired
    private CategoryService service;
    @Autowired
    private CategoryMapper mapper;

    @GetMapping
    public ResponseEntity<CategoryListResponse> findAll()
    {
        return ResponseEntity.ok(mapper.categoryListToCategoryListResponse(service.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> findById(@PathVariable("id") Long categoryId)
    {
        return ResponseEntity.ok(mapper.categoryToResponse(service.findById(categoryId)));
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> create(@RequestBody UpsertCategoryRequest request)
    {
        Category newCategory = service.save(mapper.requestToCategory(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.categoryToResponse(newCategory));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> update(@PathVariable("id") Long categoryId, UpsertCategoryRequest request)
    {
        Category updatedCategory = service.update(mapper.requestToCategory(request));
        return ResponseEntity.ok(mapper.categoryToResponse(updatedCategory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long categoryId)
    {
        service.deleteById(categoryId);
        return ResponseEntity.noContent().build();
    }
}
