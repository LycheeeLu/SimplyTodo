package com.it.simplytodo.controller;


import com.it.simplytodo.Service.UserService;
import com.it.simplytodo.entity.TodoUser;
import com.it.simplytodo.enums.TodoErrorStatus;
import com.it.simplytodo.errors.TodoException;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Todo user controller", description = "operations on Todo users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

    }

    @GetMapping("/users/id/{id}")
    public TodoUser getUserById(@PathVariable int id) throws TodoException {
        return userService.getUserById(id);
    }

    @GetMapping("/users")
    public List<?> getALlUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/email/{email}")
    public TodoUser getUserByEmail(@PathVariable String email)  {
        return userService.getUserByEmail(email);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id)  {
        userService.deleteUser(id);
    }


    @PostMapping("/users")
    public TodoUser createOrUpdateUser(@RequestBody @Valid TodoUser todoUser, BindingResult bindingResult) throws Exception{
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getFieldErrors().stream()
                    .map(error -> error.getField() + ":" + error.getDefaultMessage())
                    .toList();

            String errorMessage = String.join(", ", errors);

            throw new TodoException(TodoErrorStatus.VALIDATION_ERROR, errorMessage);

        }

        return  userService.createOrUpdate(todoUser);
    }


    @GetMapping("/users/title/{title}")
    public List<TodoUser> getUserByTaskTitle(@PathVariable String title){
        return userService.getAllUserWithTaskTitle(title);
    }

}
