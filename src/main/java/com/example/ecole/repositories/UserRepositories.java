package com.example.ecole.repositories;

import com.example.ecole.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositories extends JpaRepository<User,Long> {
    User findByEmailAndPassword(String email, String password);
}
