package com.it.simplytodo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class User {

    @Id
    private int user_id;
    private String username;
    private String password;
    private String email;

    @OneToMany
    List<TodoTask> tasks = new ArrayList<>();

}
