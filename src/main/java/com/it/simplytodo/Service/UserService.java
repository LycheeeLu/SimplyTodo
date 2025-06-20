package com.it.simplytodo.Service;


import com.it.simplytodo.dao.UserDAO;
import com.it.simplytodo.entity.TodoUser;
import com.it.simplytodo.enums.TodoErrorStatus;
import com.it.simplytodo.errors.TodoException;
import com.it.simplytodo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDAO userDAO;

    public TodoUser getUserById(int id) throws TodoException {
        return userRepository.findById(id)
                .orElseThrow(() -> new TodoException(TodoErrorStatus.NOT_FOUND, "user with this id is not found"));
    }
    public TodoUser getUserByEmail(String email){
        var o_user = userRepository.findByEmail(email);
        return o_user.orElse(null);
    }

    public TodoUser createOrUpdate(TodoUser todoUser) {
        var db_user = getUserByEmail(todoUser.getEmail());
        if(db_user != null){
            // user already exits, only update a few new fields
            db_user.setUsername(todoUser.getUsername());
            db_user.setPhone(todoUser.getPhone());
            db_user.setPassword(todoUser.getPassword());
            return userRepository.saveAndFlush(db_user);

        }

        // user do not exist, create a new one
        return userRepository.saveAndFlush(todoUser);
    }

    public void deleteUser(int id){
        userRepository.deleteById(id);
    }

    public List<TodoUser> getAllUsers(){
        return userRepository.findAll();
    }

    public List<TodoUser> getAllUserWithTaskTitle(String taskTitle){
        return userDAO.getAllUsersWithTaskTitle(taskTitle);
    }


}
