package com.blog.blog_app_apis.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.blog.blog_app_apis.entites.Category;
import com.blog.blog_app_apis.exceptions.ResourceNotFoundException;
import com.blog.blog_app_apis.payloads.CategoryDto;
import com.blog.blog_app_apis.repositories.CategoryRepo;
import com.blog.blog_app_apis.services.CategoryService;

public class CategoryServiceimpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category cat = modelMapper.map(categoryDto, Category.class);
        Category addedcat = categoryRepo.save(cat);
        return modelMapper.map(addedcat, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category category = categoryRepo.findById(categoryId)
        .orElseThrow(() -> new ResourceNotFoundException("Category Not Found"));

        category.setCategoryTitle(categoryDto.getCategoryTitle());
        category.setCategoryDescription(categoryDto.getCategoryDescription());

        Category updatedcat = categoryRepo.save(category);
        return modelMapper.map(updatedcat, CategoryDto.class);
    }

    @Override
    public CategoryDto getCategory(Integer categoryId) {
        Category category = categoryRepo.findById(categoryId)
        .orElseThrow(() -> new ResourceNotFoundException("Category Not Found"));

        return modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category category = categoryRepo.findById(categoryId)
        .orElseThrow(() -> new ResourceNotFoundException("Category Not Found"));

        categoryRepo.delete(category);
    }

    @Override
    public List<CategoryDto> getCategories() {
       
    }

}
