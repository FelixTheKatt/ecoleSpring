package com.example.ecole.repositories;

import com.example.ecole.model.entities.Interro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterroRepository extends JpaRepository<Interro,Long> {
}
