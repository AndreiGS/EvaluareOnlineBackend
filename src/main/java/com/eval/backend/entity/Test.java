package com.eval.backend.entity;

import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
public class Test {

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    @NotNull
    private String id;

    @OneToMany(mappedBy = "test", cascade = CascadeType.REMOVE)
    @NotNull
    private List<Questions> questionsList;

    @OneToMany(mappedBy = "test", cascade = CascadeType.REMOVE)
    @NotNull
    private List<Results> resultsList;

    public Test() {
    }

    public String getId() {
        return id;
    }

    public Test setId(String id) {
        this.id = id;
        return this;
    }

    public List<Questions> getQuestionsList() {
        return questionsList;
    }

    public Test setQuestionsList(List<Questions> questionsList) {
        this.questionsList = questionsList;
        return this;
    }

    public List<Results> getResultsList() {
        return resultsList;
    }

    public Test setResultsList(List<Results> resultsList) {
        this.resultsList = resultsList;
        return this;
    }
}
