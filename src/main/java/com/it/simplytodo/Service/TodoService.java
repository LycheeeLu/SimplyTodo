package com.it.simplytodo.Service;

import com.it.simplytodo.entity.TodoTask;
import com.it.simplytodo.errors.TodoException;
import com.it.simplytodo.repository.TodoTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.it.simplytodo.enums.TodoErrorStatus.NOT_FOUND;

@Service
public class TodoService {

    @Autowired
    private TodoTaskRepository todoTaskRepository;

    public TodoTask createOrUpdate(TodoTask todoTask) throws TodoException {
        //autobox int id into Integer
        Integer taskId = todoTask.getId();
        todoTaskRepository.save(todoTask);
        // different from sample code
        return todoTask;
    }

    //id is int but key is integer
    public TodoTask getTask(int id) throws TodoException{
        TodoTask task = todoTaskRepository.findById(id)
                .orElseThrow(() -> new TodoException(NOT_FOUND,"Task not found"));
        return task;
    }

    //extra feature: throw execptions
    public void deleteTask(int id) throws TodoException {
         todoTaskRepository.deleteById(id);
    }

    //otherwise have to iterate through Hashmap
    public List<TodoTask> getAllTasks() throws TodoException{
        return todoTaskRepository.findAll();
    }

}
