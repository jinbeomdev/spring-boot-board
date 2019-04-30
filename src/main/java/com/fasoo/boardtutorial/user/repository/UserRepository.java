package com.fasoo.boardtutorial.user.repository;

import com.fasoo.boardtutorial.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(String userId);
}
