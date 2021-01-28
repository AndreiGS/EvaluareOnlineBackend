package com.eval.backend.dto.questions.request;

public class PostQuestionDto {

    private String questionType;
    private String question;
    private String answers;

    public PostQuestionDto() {
    }

    public String getQuestionType() {
        return questionType;
    }

    public PostQuestionDto setQuestionType(String questionType) {
        this.questionType = questionType;
        return this;
    }

    public String getQuestion() {
        return question;
    }

    public PostQuestionDto setQuestion(String question) {
        this.question = question;
        return this;
    }

    public String getAnswers() {
        return answers;
    }

    public PostQuestionDto setAnswers(String answers) {
        this.answers = answers;
        return this;
    }
}
