package com.it.simplytodo.repository;

import com.it.simplytodo.entity.TodoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<TodoUser, Integer> {
    //TodoUser findById(int user_id);
    Optional<TodoUser> findByEmail(String email);
    //void deleteById(int user_id);
    //TodoUser save(TodoUser user);
    //List<TodoUser> findAll();

}
