package com.example.ecole.repositories;

import com.example.ecole.model.entities.UserCours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCoursRepository extends JpaRepository<UserCours,Long> {

    List<UserCours> findAllByUserId(Long userId);
}
