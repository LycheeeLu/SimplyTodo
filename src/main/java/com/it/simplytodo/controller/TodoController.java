package com.it.simplytodo.controller;

import com.it.simplytodo.Service.TodoService;
import com.it.simplytodo.entity.TodoTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {


    @Autowired
    private TodoService todoService;
    // injected the TodoService beans;

    @GetMapping("/task/{id}")
    public TodoTask getTask(@PathVariable int id){
        return todoService.getTask(id);
    }
    @GetMapping("/tasks")
    public List<?> getAllTasks(){
        return  todoService.getAllTasks();
    }
    @DeleteMapping("/task/{id}")
    public void deleteTask(@PathVariable int id){
        todoService.deleteTask(id);
    }

    @PostMapping("/task")
    public TodoTask createTask(@RequestBody TodoTask todoTask){
        return todoService.createOrUpdate(todoTask);
    }
}
