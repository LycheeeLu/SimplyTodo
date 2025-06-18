package com.it.simplytodo.errors;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;

@ControllerAdvice
public class TodoErrorController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<TodoErrorResponse> handleException (Exception e){
        TodoErrorResponse
    }
}



