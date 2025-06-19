package com.it.simplytodo.dao;


import com.it.simplytodo.entity.TodoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //create much more complex queries with params through such methods
    public List<TodoUser> getAllUsersWithTaskTitle(String taskTitle) {
        StringBuffer sql = new StringBuffer();
        List<Object> params = new ArrayList<>();
        sql.append("select * from todo_user u where u.id IN(");
        sql.append("SELECT t.user_id FROM todo_task t WHERE t.title = ?)");
        params.add(taskTitle);
        return jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(TodoUser.class), params.toArray());
    }

}
