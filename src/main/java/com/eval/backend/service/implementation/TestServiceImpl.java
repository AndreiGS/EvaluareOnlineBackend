package com.eval.backend.service.implementation;

import com.eval.backend.dto.results.request.PostResultsDto;
import com.eval.backend.dto.test.request.PostTestDto;
import com.eval.backend.dto.results.response.GetResultsDto;
import com.eval.backend.dto.test.response.GetTestDto;
import com.eval.backend.entity.Questions;
import com.eval.backend.entity.Results;
import com.eval.backend.entity.Test;
import com.eval.backend.exception.CannotFindTestException;
import com.eval.backend.mapper.implementation.QuestionsMapperImpl;
import com.eval.backend.mapper.implementation.ResultsMapperImpl;
import com.eval.backend.mapper.implementation.TestMapperImpl;
import com.eval.backend.repository.QuestionsRepository;
import com.eval.backend.repository.ResultsRepository;
import com.eval.backend.repository.TestRepository;
import com.eval.backend.service.repository.TestService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.util.List;

@Service
@AllArgsConstructor
public class TestServiceImpl implements TestService {

    private TestRepository testRepository;
    private ResultsRepository resultsRepository;
    private QuestionsRepository questionsRepository;
    private QuestionsMapperImpl questionsMapper;
    private ResultsMapperImpl resultsMapper;
    private TestMapperImpl testMapper;

    @Override
    public ResponseEntity<String> postTest(PostTestDto postTestDto) {
        Test test;
        try {
            List<Questions> questionsList = questionsMapper.convertPostQuestionsDtoToQuestions(postTestDto.getQuestionsList());
            test = saveTest(new Test());
            saveAllQuestions(questionsList, test);
        } catch (PersistenceException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.ok(test.getId());
    }

    @Override
    public ResponseEntity<GetTestDto> getTest(String id) throws CannotFindTestException {
        GetTestDto getTestDto;
        try {
            getTestDto = testMapper.convertTestToGetTestDto(findTestById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok(getTestDto);
    }

    @Override
    public ResponseEntity<List<GetResultsDto>> getResults(String id) throws CannotFindTestException {
        Test test = findTestById(id);
        return ResponseEntity.ok(resultsMapper.convertResultsToGetResultsDto(test.getResultsList()));
    }

    @Override
    public ResponseEntity<Integer> postResult(PostResultsDto postResultsDto, String testId) {
        Test test = findTestById(testId);
        Results results = resultsMapper.convertPostResultsDtoToResults(postResultsDto, test);
        try {
            return ResponseEntity.ok(saveResult(results).getResult());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public void saveAllQuestions(List<Questions> questionsList, Test test) {
        for(Questions questions : questionsList) {
            questions.setTest(test);
            saveQuestions(questions);
        }
    }

    @Override
    public void saveQuestions(Questions questions) {
        questionsRepository.save(questions);
    }

    @Override
    public Test saveTest(Test test) {
        return testRepository.save(test);
    }


    @Override
    public Test findTestById(String id) {
        return testRepository.findById(id).orElseThrow(CannotFindTestException::new);
    }

    @Override
    public Results saveResult(Results results) {
        return resultsRepository.save(results);
    }
}
