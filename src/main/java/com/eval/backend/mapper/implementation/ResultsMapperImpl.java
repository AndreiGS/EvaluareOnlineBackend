package com.eval.backend.mapper.implementation;

import com.eval.backend.dto.results.request.Answer;
import com.eval.backend.dto.results.request.PostResultsDto;
import com.eval.backend.dto.results.response.GetResultsDto;
import com.eval.backend.entity.Questions;
import com.eval.backend.entity.Results;
import com.eval.backend.entity.Test;
import com.eval.backend.mapper.repository.ResultsMapper;
import com.eval.backend.repository.QuestionsRepository;
import com.eval.backend.utils.AnswersTable;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@AllArgsConstructor
public class ResultsMapperImpl implements ResultsMapper {

    private ModelMapper modelMapper;
    private QuestionsRepository questionsRepository;

    @Override
    public List<GetResultsDto> convertResultsToGetResultsDto(List<Results> resultsList) {
        List<GetResultsDto> resultsDtoList = new ArrayList<>();
        for(Results result : resultsList) {
            resultsDtoList.add(modelMapper.map(result, GetResultsDto.class));
        }
        Collections.sort(resultsDtoList);
        return resultsDtoList;
    }

    @Override
    public Results convertPostResultsDtoToResults(PostResultsDto postResultsDto, Test test) {
        Results results = modelMapper.map(postResultsDto, Results.class);
        results.setTest(test);
        results.setResult(reviewSubmit(postResultsDto.getAnswers(), test));

        return results;
    }

    private Integer reviewSubmit(List<Answer> actualAnswers, Test test) {
        int grade=0;
        for(Answer answer : actualAnswers) {
            String question = answer.getQuestion();
            String actualAnswer = answer.getAnswer();
            String expectedAnswer = findAnswerByQuestion(question);
            if(isOk(actualAnswer, expectedAnswer))
                grade++;
        }

        return grade;
    }

    private String findAnswerByQuestion(String question) {
        Questions questionClass = questionsRepository.findByQuestion(question).orElseGet(Questions::new);

        return questionClass.getAnswers();
    }

    private boolean isOk(String actualAnswer, String expectedAnswer) {
        String[] actualAnswersArray = actualAnswer.split("\\|");
        String[] expectedAnswerFromDb = expectedAnswer.split("\\|");
        String[] expectedAnswerArray = new String[1];
        int k=0;
        int okAns=0;
        for (String answer : expectedAnswerFromDb) {
            if (answer.contains("`")) {
                expectedAnswerArray[k++] = answer;
            }
        }
        for(int j=0; j<actualAnswersArray.length; j++) {
            String answer=actualAnswersArray[j];

            if(answer == null)
                continue;

            answer = answer.toLowerCase();
            for(int i=0; i<expectedAnswerArray.length; i++) {
                String expected = expectedAnswerArray[i];
                if(expected == null)
                    continue;
                expected = expected.toLowerCase();
                if(answer.equals(expected))
                    okAns++;
            }
        }

        return okAns == expectedAnswerArray.length;
    }
}
