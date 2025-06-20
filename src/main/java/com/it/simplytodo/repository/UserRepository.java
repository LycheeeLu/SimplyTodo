package com.it.simplytodo.repository;

import com.it.simplytodo.entity.TodoUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<TodoUser, Integer> {
    List<TodoUser> findByUser_id(int user_id);
    List<TodoUser> findByEmail(String email);

}
