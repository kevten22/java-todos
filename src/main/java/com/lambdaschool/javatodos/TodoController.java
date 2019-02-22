package com.lambdaschool.javatodos;


import com.lambdaschool.javatodos.models.Todo;
import com.lambdaschool.javatodos.models.User;
import com.lambdaschool.javatodos.repositories.TodoRepository;
import com.lambdaschool.javatodos.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(path = {}, produces = MediaType.APPLICATION_JSON_VALUE)
public class TodoController {

    @Autowired
    TodoRepository todorepos;

    @Autowired
    UserRepository userrepos;

    @GetMapping("/user")
    public List<User> alluser() {
        return userrepos.findAll();
    }

    @GetMapping("/todos")
    public List<Todo> alltodos() {
        return todorepos.findAll();
    }

    @GetMapping("/users/userid/{userid}")
    public User findUserId(@PathVariable Long id){
        var foundUser = userrepos.findById(id);
        if(foundUser.isPresent()){
            return foundUser.get();
        }
        else{
            return null;
        }
    }

    @GetMapping("/users/username/{username}")
    public User findUserName(@PathVariable String name){
        var foundUser = userrepos.findByName(name);
        if(foundUser != null){
            return foundUser;
        }
        else{
            return null;
        }
    }

    @GetMapping("/todos/todoid/{todoid}")
    public Todo findTodoId(@PathVariable Long id){
        var foundTodo = todorepos.findById(id);
        if(foundTodo.isPresent()){
            return foundTodo.get();
        }
        else{
            return null;
        }
    }

    @GetMapping("/todos/users")
    public List<Object[]> todoUsers(){
        return todorepos.todoUsers();
    }

    @GetMapping("/todos/active")
    public List<Todo> activeTodos(){
        return todorepos.findByCompleted(1);
    }

    @PostMapping("/users")
    public User newUser(@RequestBody User user) throws URISyntaxException{
        return userrepos.save(user);
    }

    @PostMapping("/todo")
    public Todo newTodo(@RequestBody Todo todo) throws URISyntaxException{
        return todorepos.save(todo);
    }




}
