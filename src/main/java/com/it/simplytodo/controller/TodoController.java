package com.it.simplytodo.controller;

import com.it.simplytodo.Service.TodoService;
import com.it.simplytodo.entity.TodoTask;
import com.it.simplytodo.enums.TodoErrorStatus;
import com.it.simplytodo.errors.TodoException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Todo Task Controller", description = "Operations on Todo Tasks")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @GetMapping("/task/{id}")
    @Operation(summary = "Get a task by ID", description = "Provide an ID to look up specific task")
    public TodoTask getTask(@PathVariable int id) throws TodoException {
        return todoService.getTask(id);
    }
    @GetMapping("/tasks")
    @Operation(summary = "List all tasks", description = "Provide all tasks")
    public List<?> getAllTasks() throws  TodoException {
        return  todoService.getAllTasks();
    }
    @DeleteMapping("/task/{id}")
    @Operation(summary =  "Delete the todo task based on task id", description = "Pass in task id to delete task" )
    public void deleteTask(@PathVariable int id) throws  TodoException{
        todoService.deleteTask(id);
    }

    @PostMapping("/task")
    @Operation(summary = "update or create a task", description = "create a new task or update an old one(with specified id)")
    public TodoTask createTask(@RequestBody @Valid TodoTask todoTask, BindingResult bindingResult) throws TodoException{
       if (bindingResult.hasErrors()) {

           //handle validation errors
           List<String> errors = bindingResult.getFieldErrors().stream()
                   .map(error ->error.getField() + ": " + error.getDefaultMessage())
                   .toList();

           String errorMessage = String.join(", ", errors);

            // throw new exception
           throw new TodoException(TodoErrorStatus.VALIDATION_ERROR, errorMessage);
       }

        return todoService.createOrUpdate(todoTask);
    }
}
