package com.example.Tutorial.Application.service;

import com.example.Tutorial.Application.Entity.Tutorial;
import com.example.Tutorial.Application.models.TutorialRequest;
import com.example.Tutorial.Application.models.TutorialResponse;
import reactor.core.publisher.Mono;

public interface TutorialService {

public Mono<TutorialResponse> createTutorial(TutorialRequest tutorialRequest);

}
