package com.example.springbootnewsportal.web.controllers;

import com.example.springbootnewsportal.mapper.CategoryMapper;
import com.example.springbootnewsportal.model.Category;
import com.example.springbootnewsportal.service.CategoryService;
import com.example.springbootnewsportal.web.model.category.CategoryListResponse;
import com.example.springbootnewsportal.web.model.category.CategoryResponse;
import com.example.springbootnewsportal.web.model.category.UpsertCategoryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController
{
    private final CategoryService categoryWithDataBaseService;
    private final CategoryMapper mapper;

    @GetMapping
    public ResponseEntity<CategoryListResponse> findAll()
    {
        return ResponseEntity.ok(mapper.categoryListToCategoryResponseList(categoryWithDataBaseService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> findById(@PathVariable("id") Long categoryId)
    {
        return ResponseEntity.ok(mapper.categoryToResponse(categoryWithDataBaseService.findById(categoryId)));
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> create(@RequestBody UpsertCategoryRequest request)
    {
        Category newCategory = categoryWithDataBaseService.save(mapper.requestToCategory(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.categoryToResponse(newCategory));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> update(@PathVariable("id") Long categoryId, @RequestBody UpsertCategoryRequest request)
    {
        Category updatedCategory = categoryWithDataBaseService.update(mapper.requestToCategory(categoryId, request));
        return ResponseEntity.ok(mapper.categoryToResponse(updatedCategory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long userId)
    {
        categoryWithDataBaseService.delete(userId);
        return ResponseEntity.noContent().build();
    }
}
