package com.lambdaschool.javatodos.repositories;

import com.lambdaschool.javatodos.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
