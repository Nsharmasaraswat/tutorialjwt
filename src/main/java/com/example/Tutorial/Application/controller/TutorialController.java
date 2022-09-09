package com.example.Tutorial.Application.controller;

import com.example.Tutorial.Application.exception.DuplicateEntityException;
import com.example.Tutorial.Application.models.TutorialRequest;
import com.example.Tutorial.Application.models.TutorialResponse;
import com.example.Tutorial.Application.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController("/tutorial")
public class TutorialController {
    @Autowired
    TutorialService tutorialService;

    @PostMapping
    public Mono<TutorialResponse> creteTutorial(@RequestBody TutorialRequest tutorialRequest) {

        return tutorialService.createTutorial(tutorialRequest)
                .onErrorResume(error -> {
                    if (error instanceof DuplicateEntityException)
                        return Mono.error(new DuplicateEntityException(error.getMessage()));
                    return null;
                });

    }


}
