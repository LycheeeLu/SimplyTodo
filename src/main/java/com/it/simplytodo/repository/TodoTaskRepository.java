package com.it.simplytodo.repository;

import com.it.simplytodo.entity.TodoTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TodoTaskRepository extends JpaRepository<TodoTask, Integer> {
    // instead of redefining the methods, only define new ones needed
    List<TodoTask> findByStatus(String status);

    // TodoTask findById(int id);
    // void deleteById(int id);
    //TodoTask save(TodoTask todoTask);

}
