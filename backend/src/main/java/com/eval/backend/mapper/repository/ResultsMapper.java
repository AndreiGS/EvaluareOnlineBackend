package com.eval.backend.mapper.repository;

import com.eval.backend.dto.results.request.PostResultsDto;
import com.eval.backend.dto.results.response.GetResultsDto;
import com.eval.backend.entity.Results;
import com.eval.backend.entity.Test;

import java.util.List;

public interface ResultsMapper {

    List<GetResultsDto> convertResultsToGetResultsDto(List<Results> resultsList);
    Results convertPostResultsDtoToResults(PostResultsDto postResultsDto, Test test);

}
