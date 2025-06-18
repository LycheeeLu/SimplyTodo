package com.it.simplytodo.entity;

import com.it.simplytodo.enums.TodoTaskStatus;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;


public class TodoTask {

    @Getter
    private static int idCounter = 0;

    @Getter
    private int id = idCounter ++;

    @Getter @Setter
    private String title;

    @Getter @Setter
    private String description;

    @Getter @Setter
    private TodoTaskStatus status = TodoTaskStatus.Not_STARTED;

    @Getter @Setter
    private Date dueDate;

    @Getter
    private Date createdAt = Date.from(java.time.Instant.now());

}
