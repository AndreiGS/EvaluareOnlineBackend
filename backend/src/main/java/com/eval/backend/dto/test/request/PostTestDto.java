package com.eval.backend.dto.test.request;

import com.eval.backend.dto.questions.request.PostQuestionDto;

import java.util.List;

public class PostTestDto {

    private List<PostQuestionDto> questionsList;

    public PostTestDto() {
    }

    public List<PostQuestionDto> getQuestionsList() {
        return questionsList;
    }

    public PostTestDto setQuestionsList(List<PostQuestionDto> questionsList) {
        this.questionsList = questionsList;
        return this;
    }

}
