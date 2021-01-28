package com.eval.backend.entity;

import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Results{

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @GeneratedValue(generator = "uuid")
    @NotNull
    private String id;

    private String name;
    private Integer result;

    @ManyToOne
    private Test test;

    public Results() {
    }

    public String getId() {
        return id;
    }

    public Results setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Results setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getResult() {
        return result;
    }

    public Results setResult(Integer result) {
        this.result = result;
        return this;
    }

    public Test getTest() {
        return test;
    }

    public Results setTest(Test test) {
        this.test = test;
        return this;
    }
}
