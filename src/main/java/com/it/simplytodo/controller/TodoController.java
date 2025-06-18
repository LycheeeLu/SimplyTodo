package com.it.simplytodo.controller;

import com.it.simplytodo.Service.TodoService;
import com.it.simplytodo.entity.TodoTask;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Todo Task Controller", description = "Operations on Todo Tasks")
public class TodoController {


    @Autowired
    private TodoService todoService;
    // injected the TodoService beans;

    @GetMapping("/task/{id}")
    @Operation(summary = "Get a task by ID", description = "Provide an ID to look up specific task")
    public TodoTask getTask(@PathVariable int id){
        return todoService.getTask(id);
    }
    @GetMapping("/tasks")
    @Operation(summary = "List all tasks", description = "Provide all tasks")
    public List<?> getAllTasks(){
        return  todoService.getAllTasks();
    }
    @DeleteMapping("/task/{id}")
    @Operation(summary =  "Delete the todo task based on task id", description = "Pass in task id to delete task" )
    public void deleteTask(@PathVariable int id){
        todoService.deleteTask(id);
    }

    @PostMapping("/task")
    @Operation(summary = "update or create a task", description = "create a new task or update an old one(with specified id)")
    public TodoTask createTask(@RequestBody TodoTask todoTask){
        return todoService.createOrUpdate(todoTask);
    }
}
