package com.example.EmployeeManagementSystem.EMSProject.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceException.class)
    
    public ResponseEntity<String> handleException(Exception e){
    	System.out.println("Exception Reached");
    	return new ResponseEntity<>(e.getMessage() , HttpStatus.NOT_FOUND);
    }
}