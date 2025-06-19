package com.it.simplytodo.errors;

import com.it.simplytodo.enums.TodoErrorStatus;
import lombok.Getter;

public class TodoException extends Exception {

    @Getter
    private TodoErrorStatus status;

    public TodoException(TodoErrorStatus status, String message){
        super(message);
        this.status = status;
    }



}
