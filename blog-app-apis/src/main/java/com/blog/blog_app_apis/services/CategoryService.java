package com.blog.blog_app_apis.services;

import com.blog.blog_app_apis.payloads.CategoryDto;
import java.util.*;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    CategoryDto getCategory(Integer categoryId);

    void deleteCategory(Integer categoryId);

    List<CategoryDto> getCategories();

}
