package com.it.simplytodo.Service;

import com.it.simplytodo.entity.TodoTask;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class TodoService {
    //create HashMap structure to store tasks
    private static HashMap<Integer, TodoTask> todoTaskStore =
            new HashMap<>();

    public TodoTask createOrUpdate(TodoTask todoTask){
        //autobox int id into Integer
        Integer taskId = todoTask.getId();
        todoTaskStore.put(taskId, todoTask);
        // different from sample code
        return todoTask;
    }

    //id is int but key is integer
    public TodoTask getTask(int id) {
        return todoTaskStore.get(id);
    }

    //extra feature: throw execptions
    public void deleteTask(int id) {
        if(todoTaskStore.remove(id) == null){
            throw new IllegalArgumentException("Task id not found");
        }
    }

    //otherwise have to iterate through Hashmap
    public List<TodoTask> getAllTasks(){
        return todoTaskStore.values().stream().toList();
    }

}
