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
import java.util.Optional;

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

    @PutMapping("/users/userid/{userid}")
    public User changeUser(@RequestBody User newuser, @PathVariable int id){

        User updateUser = userrepos.findById(id);
        if(updateUser != null){
            newuser.setUserid(id);
            userrepos.save(newuser);

            return newuser;
        }

        else
        {
            return null;
        }
    }

    @PutMapping("/todos/todoid/{todoid}")
    public Todo changeTodo(@RequestBody Todo newtodo, @PathVariable int id){

        Todo updateTodo = todorepos.findById(id);
        if(updateTodo != null){
            newtodo.setTodoid(id);
            todorepos.save(newtodo);

            return newtodo;
        }

        else
        {
            return null;
        }
    }

    @DeleteMapping("/users/userid/{userid}")
    public User deleteUser(@PathVariable int id){
        var foundUser = userrepos.findById(id);
        if(foundUser != null){
            userrepos.deleteByUserid(id);
            return foundUser;
        }

        else
            return null;
    }

    @DeleteMapping("/todos/todoid/{todoid}")
    public Todo deleteTodo(@PathVariable int id){
        var foundTodo = todorepos.findById(id);
        if(foundTodo != null){
            todorepos.deleteByTodoid(id);
            return foundTodo;
        }

        else
            return null;
    }




}
