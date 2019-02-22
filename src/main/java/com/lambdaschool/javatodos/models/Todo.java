package com.lambdaschool.javatodos.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
@Table(name="todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false)
    private int todoid;

    @Column(nullable = false)
    private String description;

    private DateTimeFormat datestarted;

    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "user", nullable=false)
    @JsonIgnore
    private User user;

    public Todo(){
    }

    public int getTodoid() {
        return todoid;
    }

    public void setTodoid(int todoid) {
        this.todoid = todoid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DateTimeFormat getDatestarted() {
        return datestarted;
    }

    public void setDatestarted(DateTimeFormat datestarted) {
        this.datestarted = datestarted;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
