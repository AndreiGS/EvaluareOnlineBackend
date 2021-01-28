package com.eval.backend.dto.results.request;

public class Answer {

    private String question;
    private String answer;

    public Answer() {
    }

    public String getQuestion() {
        return question;
    }

    public Answer setQuestion(String question) {
        this.question = question;
        return this;
    }

    public String getAnswer() {
        return answer;
    }

    public Answer setAnswer(String answer) {
        this.answer = answer;
        return this;
    }
}
