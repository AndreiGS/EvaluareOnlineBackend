package com.eval.backend.dto.results.response;

import org.springframework.stereotype.Component;

@Component
public class GetResultsDto implements Comparable<GetResultsDto> {

    private String name;
    private Integer result;

    public GetResultsDto() {
    }

    public String getName() {
        return name;
    }

    public GetResultsDto setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getResult() {
        return result;
    }

    public GetResultsDto setResult(Integer result) {
        this.result = result;
        return this;
    }

    @Override
    public int compareTo(GetResultsDto o) {
        return this.name.compareTo(o.name);
    }
}
