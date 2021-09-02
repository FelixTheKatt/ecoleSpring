package com.example.ecole.repositories;

import com.example.ecole.model.entities.UserCours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCoursRepository extends JpaRepository<UserCours,Long> {
}
