package com.example.springbootnewsportal.mapper;

import com.example.springbootnewsportal.model.Category;
import com.example.springbootnewsportal.web.model.category.CategoryListResponse;
import com.example.springbootnewsportal.web.model.category.CategoryResponse;
import com.example.springbootnewsportal.web.model.category.UpsertCategoryRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper
{
    Category requestToCategory(UpsertCategoryRequest request);
    Category requestToCategory(Long categoryId, UpsertCategoryRequest request);
    CategoryResponse categoryToResponse(Category category);

    default CategoryListResponse categoryListToCategoryResponseList(List<Category> categories)
    {
        CategoryListResponse response = new CategoryListResponse();
        response.setCategoryResponses(categories.stream().map(this::categoryToResponse)
                .collect(Collectors.toList()));
        return response;
    }
}
