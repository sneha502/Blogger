package com.blog.blog_app_apis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.blog_app_apis.entites.User;

public interface UserRepo extends JpaRepository <User, Integer> {

    
} 
