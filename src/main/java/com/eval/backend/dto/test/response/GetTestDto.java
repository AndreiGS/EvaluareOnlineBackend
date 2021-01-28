package com.eval.backend.dto.test.response;

import com.eval.backend.dto.questions.response.GetQuestionsDto;
import java.util.List;

public class GetTestDto {

    private List<GetQuestionsDto> questionsDtoList;

    public GetTestDto() {
    }

    public GetTestDto(List<GetQuestionsDto> questionsDtoList) {
        this.questionsDtoList = questionsDtoList;
    }

    public List<GetQuestionsDto> getQuestionsDtoList() {
        return questionsDtoList;
    }

    public GetTestDto setQuestionsDtoList(List<GetQuestionsDto> questionsDtoList) {
        this.questionsDtoList = questionsDtoList;
        return this;
    }
}
