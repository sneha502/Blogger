package com.blog.blog_app_apis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.blog_app_apis.entites.Category;

import jakarta.persistence.Id;

public interface CategoryRepo extends JpaRepository<Category,Integer>{

}
