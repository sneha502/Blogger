package com.blog.blog_app_apis.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blog.blog_app_apis.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHnadler(ResourceNotFoundException ex){
        String message = ex.getMessage();
        ApiResponse apiResponse = new ApiResponse(message,false);
        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
    }
}
