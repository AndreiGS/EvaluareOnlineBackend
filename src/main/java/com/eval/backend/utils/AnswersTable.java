package com.eval.backend.utils;

public class AnswersTable {

    private String actualAnswer;
    private String expectedAnswer;

    public AnswersTable(String actualAnswer, String expectedAnswer) {
        this.actualAnswer = actualAnswer;
        this.expectedAnswer = expectedAnswer;
    }

    public String getActualAnswer() {
        return actualAnswer;
    }

    public AnswersTable setActualAnswer(String actualAnswer) {
        this.actualAnswer = actualAnswer;
        return this;
    }

    public String getExpectedAnswer() {
        return expectedAnswer;
    }

    public AnswersTable setExpectedAnswer(String expectedAnswer) {
        this.expectedAnswer = expectedAnswer;
        return this;
    }
}
