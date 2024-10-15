package com.blog.blog_app_apis.services;

import com.blog.blog_app_apis.payloads.UserDto;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto, Integer userId);
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUsers();
    void deleteUser(Integer userId);
}
