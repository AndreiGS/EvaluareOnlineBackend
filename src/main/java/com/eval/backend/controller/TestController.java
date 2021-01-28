package com.eval.backend.controller;

import com.eval.backend.dto.results.request.PostResultsDto;
import com.eval.backend.dto.test.request.PostTestDto;
import com.eval.backend.dto.results.response.GetResultsDto;
import com.eval.backend.dto.test.response.GetTestDto;
import com.eval.backend.exception.CannotFindTestException;
import com.eval.backend.service.implementation.TestServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/test")
@AllArgsConstructor
public class TestController {

    private TestServiceImpl testService;

    @PostMapping("/postTest")
    private ResponseEntity<String> postTest(@RequestBody PostTestDto postTestDto) {
        return testService.postTest(postTestDto);
    }

    @GetMapping("/getTest/{id}")
    private ResponseEntity<GetTestDto> getTest(@PathVariable String id) throws CannotFindTestException {
        return testService.getTest(id);
    }

    @GetMapping("/getResults/{id}")
    private ResponseEntity<List<GetResultsDto>> getResults(@PathVariable String id) throws CannotFindTestException {
        return testService.getResults(id);
    }

    @PostMapping("/postResult")
    private ResponseEntity<Integer> postResult(@RequestParam("testId") String testId, @RequestBody PostResultsDto postResultsDto) {
        return testService.postResult(postResultsDto, testId);
    }

}
