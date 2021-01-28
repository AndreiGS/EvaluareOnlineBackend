package com.eval.backend.service.repository;

import com.eval.backend.dto.results.request.PostResultsDto;
import com.eval.backend.dto.test.request.PostTestDto;
import com.eval.backend.dto.results.response.GetResultsDto;
import com.eval.backend.dto.test.response.GetTestDto;
import com.eval.backend.entity.Questions;
import com.eval.backend.entity.Results;
import com.eval.backend.entity.Test;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface TestService {
    //CONTROLLER
    ResponseEntity<String> postTest(PostTestDto postTestDto);
    ResponseEntity<GetTestDto> getTest(String id);
    ResponseEntity<List<GetResultsDto>> getResults(String id);
    ResponseEntity<Integer> postResult(PostResultsDto postResultsDto, String testId);

    //CUSTOM METHODS
    void saveAllQuestions(List<Questions> questionsList, Test test);

    //JPA
    Test saveTest(Test test);
    void saveQuestions(Questions questions);
    Test findTestById(String id);
    Results saveResult(Results results);
}
