package com.eval.backend.mapper.implementation;

import com.eval.backend.dto.questions.response.GetQuestionsDto;
import com.eval.backend.dto.test.response.GetTestDto;
import com.eval.backend.entity.Test;
import com.eval.backend.mapper.repository.TestMapper;
import lombok.AllArgsConstructor;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TestMapperImpl implements TestMapper {

    private QuestionsMapperImpl questionsMapper;

    @Override
    public GetTestDto convertTestToGetTestDto(Test test) {
        return new GetTestDto(questionsMapper.convertQuestionsToGetQuestionsDto(test.getQuestionsList()));
    }
}
