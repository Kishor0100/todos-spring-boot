/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.jdbc.core.JdbcTemplate;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 *
 */

// Write your code here
package com.example.todo.service;
import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import com.example.todo.model.TodoRowMapper;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;
import java.util.*;

@Service
public class TodoH2Service implements TodoRepository {
    
    @Autowired
    private JdbcTemplate db;

    /*@Override
    public void deleteTodo(int todoId) {

        db.update("delete from todolist where id = ?", todoId);
      
    }

    @Override
    public Todo updateTodo(int todoId, Todo todo) {

        if(todo.getTodo() != null){
            db.update("update todolist set todo = ? where id = ?", todo.getTodo(), todoId);
        }
        
        if(todo.getStatus() != null){
            db.update("update todolist set status = ? where id = ?", todo.getStatus(), todoId);
        }
        if(todo.getPriority() != null){
            db.update("update todolist set priority = ? where id = ?", todo.getPriority(), todoId);
        }
        
        return getTodoById(todoId);
    }

    @Override
    public Todo addTodo(Todo todo) {

        db.update("insert into todolist(todo, status, priority) values (?, ?, ?)", todo.getTodo(), todo.getStatus(), todo.getPriority());

            Todo savedTodo = db.queryForObject("select * from todolist where todo = ? and status = ? and priority = ?",
		                                    new TodoRowMapper(), todo.getTodo(), todo.getStatus(), todo.getPriority());


            return savedTodo;
    }

    @Override
    public Todo getTodoById(int todoId) {

      try{
        
        Todo todo = db.queryForObject("select * from todolist where id = ?", new TodoRowMapper(), todoId);
        
        return todo;
        }
      catch (Exception e){

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
      }
      
    }*/

    @Override
    public ArrayList<Todo> getTodos() {

        List<Todo> todoList = db.query("select * from TODOLIST", new TodoRowMapper());
        ArrayList<Todo> todos = new ArrayList<>(todoList);
        return todos;

    }

}