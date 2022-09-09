package com.example.Tutorial.Application.repository;

import com.example.Tutorial.Application.Entity.Tutorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TutoralRepositoryManagementImpl implements TutorialRepositoryManagement {

    @Autowired
    private TutorialRepository tutorialRepository;


    @Override
    public Tutorial createTutorial(Tutorial tutorial) {
        return tutorialRepository.save(tutorial);
    }

    @Override
    public Optional<Tutorial> findByIsbnNo(String isbnno) {
        return tutorialRepository.findByIsbnNo(isbnno);
    }
}
