package com.it.simplytodo.repository;

import com.it.simplytodo.entity.TodoTask;
import com.it.simplytodo.enums.TodoTaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TodoTaskRepository extends JpaRepository<TodoTask, Integer> {
    // instead of redefining the methods, only define new ones needed
    List<TodoTask> findByStatus(TodoTaskStatus status);


    // NAMED PARAMS can be used like like :keyword
    @Query("SELECT t FROM TodoTask  t WHERE t.title LIKE %:keyword%")
    List<TodoTask> findByKeyword(String keyword);


    @Query("SELECT t FROM TodoTask  t WHERE t.description LIKE %:kw%")
    List<TodoTask> findByKeyWordInDescription(@Param("kw") String keywordInDescription);


    @Query("SELECT t FROM TodoTask t WHERE t.status = ?1")
    List<TodoTask> findAllByStatus(TodoTaskStatus status);


}
