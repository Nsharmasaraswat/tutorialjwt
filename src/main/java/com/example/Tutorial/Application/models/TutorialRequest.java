package com.example.Tutorial.Application.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TutorialRequest {

    @JsonProperty("tutorial_Name")
    private String tutorialName;

    @JsonProperty("isbn_no")
    private String isbn_no;

}
