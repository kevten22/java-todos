package com.lambdaschool.javatodos.repositories;

import com.lambdaschool.javatodos.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    @Query(value = "Select t.description, u.name FROM todo t, user u WHERE t.userid = u.id ORDER BY u.name", nativeQuery = true)
    List<Object[]> todoUsers();

    List<Todo> findByCompleted(int completed);
}
