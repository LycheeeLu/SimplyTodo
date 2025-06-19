package com.it.simplytodo.entity;

import com.it.simplytodo.enums.TodoTaskStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

import java.util.Date;
import java.util.Set;


@Data
@Entity
public class TodoTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Title cannot be null")
    private String title;
    private String description;

    private TodoTaskStatus status = TodoTaskStatus.Not_STARTED;

    @FutureOrPresent(message = "Due date cannot be in the past")
    private Date dueDate;

    @NotNull(message = "Created date cannot be null")
    private Date createdAt = Date.from(java.time.Instant.now());

    @ElementCollection
    private Set<String> tags;
}
