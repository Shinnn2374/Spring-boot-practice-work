package com.example.springbootnewsportal.web.controller;

import com.example.springbootnewsportal.mapper.CategoryMapper;
import com.example.springbootnewsportal.model.Category;
import com.example.springbootnewsportal.services.CategoryService;
import com.example.springbootnewsportal.web.model.category.CategoryListResponse;
import com.example.springbootnewsportal.web.model.category.CategoryRequest;
import com.example.springbootnewsportal.web.model.category.CategoryResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController
{
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<CategoryListResponse> findAll()
    {
        return ResponseEntity.ok(categoryMapper.categoryListToResponse(categoryService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> findById(@PathVariable Long id)
    {
        return ResponseEntity.ok(categoryMapper.categoryToResponse(categoryService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> create(@RequestBody @Valid CategoryRequest request)
    {
        Category newCategory = categoryService.save(categoryMapper.requestToCategory(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryMapper.categoryToResponse(newCategory));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> update(@PathVariable Long id, @RequestBody @Valid CategoryRequest request)
    {
        Category updatedCategory = categoryService.update(categoryMapper.requestToCategory(id, request));
        return ResponseEntity.ok(categoryMapper.categoryToResponse(updatedCategory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id)
    {
        categoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
