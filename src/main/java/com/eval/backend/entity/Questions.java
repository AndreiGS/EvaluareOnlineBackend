package com.eval.backend.entity;

import com.eval.backend.utils.QuestionTypeEnum;
import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Questions {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    @NotNull
    private String id;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(nullable = false)
    private QuestionTypeEnum questionType;

    @NotNull
    @Column(nullable = false)
    private String question;

    @Column(length=5012, nullable = false)
    @NotNull
    private String answers;

    @ManyToOne
    private Test test;

    public Questions() {
    }

    public String getId() {
        return id;
    }

    public Questions setId(String id) {
        this.id = id;
        return this;
    }

    public QuestionTypeEnum getQuestionType() {
        return questionType;
    }

    public Questions setQuestionType(QuestionTypeEnum questionType) {
        this.questionType = questionType;
        return this;
    }

    public String getQuestion() {
        return question;
    }

    public Questions setQuestion(String question) {
        this.question = question;
        return this;
    }

    public String getAnswers() {
        return answers;
    }

    public Questions setAnswers(String answers) {
        this.answers = answers;
        return this;
    }

    public Test getTest() {
        return test;
    }

    public Questions setTest(Test test) {
        this.test = test;
        return this;
    }
}
