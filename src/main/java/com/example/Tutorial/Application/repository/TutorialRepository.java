package com.example.Tutorial.Application.repository;


import com.example.Tutorial.Application.Entity.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, UUID> {

    public Optional<Tutorial> findByIsbnNo(String isbnNo);

}
