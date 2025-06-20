package com.it.simplytodo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.it.simplytodo.annotation.Password;
import com.it.simplytodo.annotation.Phone;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "TodoUser")
@Table(name = "todo_user")
@Data
public class TodoUser {

    @Id
    @JsonIgnore //avoid exposing id to user, username is the identifier
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name cannot be empty")
    private String username;

    @Password(message = "invalid password, password must be at least 8 characters long, contain an uppercase letter, a number, and a special character.")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Email
    private String email;

    @Phone(message = "invalid phone number")
    private String phone;


    @Transient // this field will not be persisted in the database
    private List<TodoTask> tasks;

}
