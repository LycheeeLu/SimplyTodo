package com.it.simplytodo.entity;

import java.util.Date;

public class TodoTask {
    private static int idCounter = 0;
    private int id = idCounter ++;
    private String title;
    private String description;

    private TodoTaskStatus status = TodoTaskStatus.Not_STARTED;
    private Date dueDate;
    private Date createdAt = Date.from(java.time.Instant.now());
}
