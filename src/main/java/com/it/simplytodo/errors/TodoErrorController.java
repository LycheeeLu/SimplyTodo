package com.it.simplytodo.errors;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class TodoErrorController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<TodoErrorResponse> handleException (Exception e){
        TodoErrorResponse errorResponse = new TodoErrorResponse();
        errorResponse.setMessage(e.getMessage());
        errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
         return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(TodoException.class)
    public ResponseEntity<TodoErrorResponse> handleTodoException (TodoException e){
        HttpStatus httpStatus;

        switch (e.getStatus()) {
            case NOT_FOUND:
                httpStatus = HttpStatus.NOT_FOUND;
                break;
            case BAD_REQUEST:
                httpStatus = HttpStatus.BAD_REQUEST;
                break;
            default:
                httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
                break;
        }

        TodoErrorResponse errorResponse = new TodoErrorResponse();
        errorResponse.setMessage(e.getMessage());
        errorResponse.setStatus(httpStatus);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}



