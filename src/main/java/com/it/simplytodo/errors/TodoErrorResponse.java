package com.it.simplytodo.errors;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter @Setter
public class TodoErrorResponse {

    private HttpStatus status;
    private String message;

}
