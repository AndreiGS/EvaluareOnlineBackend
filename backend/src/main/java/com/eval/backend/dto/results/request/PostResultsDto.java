package com.eval.backend.dto.results.request;

import java.util.List;

public class PostResultsDto {

    private String name;
    private List<Answer> answers;

    public PostResultsDto() {
    }

    public String getName() {
        return name;
    }

    public PostResultsDto setName(String name) {
        this.name = name;
        return this;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public PostResultsDto setAnswers(List<Answer> answers) {
        this.answers = answers;
        return this;
    }
}
