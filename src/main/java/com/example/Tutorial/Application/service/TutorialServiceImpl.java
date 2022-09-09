package com.example.Tutorial.Application.service;

import com.example.Tutorial.Application.Entity.Tutorial;
import com.example.Tutorial.Application.exception.DuplicateEntityException;
import com.example.Tutorial.Application.models.TutorialRequest;
import com.example.Tutorial.Application.models.TutorialResponse;
import com.example.Tutorial.Application.repository.TutoralRepositoryManagementImpl;
import com.example.Tutorial.Application.repository.TutorialRepositoryManagement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class TutorialServiceImpl implements TutorialService {

    @Autowired
    TutorialRepositoryManagement tutorialRepositoryManagement;

    @Override
    public Mono<TutorialResponse> createTutorial(TutorialRequest tutorialRequest) {

        Optional<Tutorial> tutorialOptional = tutorialRepositoryManagement.findByIsbnNo(tutorialRequest.getIsbn_no().trim());
        if (tutorialOptional.isPresent()) {
            return Mono.error(new DuplicateEntityException(tutorialRequest.getIsbn_no().trim()));
        }

        Tutorial tutorial = Tutorial.builder().tutorialName(tutorialRequest.getTutorialName()).isbnNo(tutorialRequest.getIsbn_no().trim()).build();
        tutorial.populateCreatedFields();
        tutorial.populateUpdatedFields();

        Tutorial tutorial1 = tutorialRepositoryManagement.createTutorial(tutorial);
        TutorialResponse tutorialResponse = new ModelMapper().map(tutorial1, TutorialResponse.class);
        return Mono.just(tutorialResponse);
    }
}
