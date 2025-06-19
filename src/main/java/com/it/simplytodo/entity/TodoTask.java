package com.it.simplytodo.entity;

import com.it.simplytodo.enums.TodoTaskStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

import java.util.Date;



@Data
@Entity
public class TodoTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Ttile canont be null")
    private String title;
    private String description;
    private TodoTaskStatus status = TodoTaskStatus.Not_STARTED;
    private Date dueDate;

    @NotNull(message = "Created date cannot be null")
    private Date createdAt = Date.from(java.time.Instant.now());

}
