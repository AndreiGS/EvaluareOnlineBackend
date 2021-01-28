package com.eval.backend.dto.questions.response;

import com.eval.backend.dto.questions.request.PostQuestionDto;

public class GetQuestionsDto {

    private String questionType;
    private String question;
    private String answers;

    public GetQuestionsDto() {
    }

    public String getQuestionType() {
        return questionType;
    }

    public GetQuestionsDto setQuestionType(String questionType) {
        this.questionType = questionType;
        return this;
    }

    public String getQuestion() {
        return question;
    }

    public GetQuestionsDto setQuestion(String question) {
        this.question = question;
        return this;
    }

    public String getAnswers() {
        return answers;
    }

    public GetQuestionsDto setAnswers(String answers) {
        this.answers = answers;
        return this;
    }

}
