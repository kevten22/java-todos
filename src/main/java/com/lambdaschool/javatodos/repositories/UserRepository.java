package com.lambdaschool.javatodos.repositories;

import com.lambdaschool.javatodos.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByName(String name);

    public User findById(int id);
    public User deleteByUserid(int id);
}
