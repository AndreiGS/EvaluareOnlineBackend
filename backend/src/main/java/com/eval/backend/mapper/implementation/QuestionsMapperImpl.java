package com.eval.backend.mapper.implementation;

import com.eval.backend.dto.questions.request.PostQuestionDto;
import com.eval.backend.dto.questions.response.GetQuestionsDto;
import com.eval.backend.entity.Questions;
import com.eval.backend.mapper.repository.QuestionsMapper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Component
@AllArgsConstructor
public class QuestionsMapperImpl implements QuestionsMapper {

    private ModelMapper modelMapper;

    @Override
    public List<Questions> convertPostQuestionsDtoToQuestions(List<PostQuestionDto> postQuestionDtoList) {
        List<Questions> questionsList = new ArrayList<>();
        for(PostQuestionDto postQuestionDto : postQuestionDtoList) {
            questionsList.add(modelMapper.map(postQuestionDto, Questions.class));
        }

        return questionsList;
    }

    @Override
    public List<GetQuestionsDto> convertQuestionsToGetQuestionsDto(List<Questions> questionsList) {
        List<GetQuestionsDto> questionsDtoList = new ArrayList<>();
        for(Questions questions : questionsList) {
            questionsDtoList.add(modelMapper.map(questions, GetQuestionsDto.class));
        }
        Collections.shuffle(questionsDtoList, new Random());
        return questionsDtoList;
    }
}
