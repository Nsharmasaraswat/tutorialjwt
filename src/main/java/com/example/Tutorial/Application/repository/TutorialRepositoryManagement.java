package com.example.Tutorial.Application.repository;

import com.example.Tutorial.Application.Entity.Tutorial;

import java.util.Optional;

public interface TutorialRepositoryManagement {


    public Tutorial createTutorial(Tutorial tutorial);

    public Optional<Tutorial> findByIsbnNo(String isbnno);

}
