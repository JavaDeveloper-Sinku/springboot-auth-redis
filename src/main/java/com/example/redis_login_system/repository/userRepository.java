package com.example.redis_login_system.repository;

import com.example.redis_login_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface userRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail (String email);

}
