package com.example.springbootnewsportal.mapper;

import com.example.springbootnewsportal.model.Category;
import com.example.springbootnewsportal.web.model.category.CategoryListResponse;
import com.example.springbootnewsportal.web.model.category.CategoryRequest;
import com.example.springbootnewsportal.web.model.category.CategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper
{
    Category requestToCategory(CategoryRequest request);

    @Mapping(source = "categoryId", target = "id")
    Category requestToCategory(Long categoryId, CategoryRequest request);

    CategoryResponse categoryToResponse(Category category);

    List<CategoryResponse> categoryListToResponseList(List<Category> categories);

    default CategoryListResponse categoryListToResponse(List<Category> categories)
    {
        CategoryListResponse response = new CategoryListResponse();
        response.setCategoryResponses(categoryListToResponseList(categories));
        return response;
    }
}
