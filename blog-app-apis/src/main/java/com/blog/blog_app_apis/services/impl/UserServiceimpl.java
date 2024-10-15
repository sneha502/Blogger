package com.blog.blog_app_apis.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blog.blog_app_apis.entites.*;
import com.blog.blog_app_apis.exceptions.ResourceNotFoundException;
import com.blog.blog_app_apis.payloads.UserDto;
import com.blog.blog_app_apis.repositories.UserRepo;
import com.blog.blog_app_apis.services.UserService;
import java.util.stream.Collectors;

@Service
public class UserServiceimpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public UserDto createUser(UserDto userDto) {
        User user = dtoToUser(userDto);
        User savedUser = userRepo.save(user);
        return userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
       User user = userRepo.findById(userId)
       .orElseThrow(()-> new ResourceNotFoundException("User Not Found"));

       user.setName(userDto.getName());
       user.setEmail(userDto.getEmail());
       user.setPassword(userDto.getPassword());
       user.setAbout(userDto.getAbout());

       User updatedUser = userRepo.save(user);
       UserDto userDto1 = userToDto(updatedUser);

       return userDto1;

    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = userRepo.findById(userId)
        .orElseThrow(()-> new ResourceNotFoundException("User Not Found"));

        return userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepo.findAll();
        List<UserDto> userDtos = users.stream().map(user -> userToDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void deleteUser(Integer userId) {
        User user = userRepo.findById(userId)
        .orElseThrow(() -> new ResourceNotFoundException("User Not Found"));

        userRepo.delete(user);

    }

    private User dtoToUser(UserDto userDto){
        User user = modelMapper.map(userDto, User.class);
        return user;
    }

    public UserDto userToDto(User user){
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }

}
