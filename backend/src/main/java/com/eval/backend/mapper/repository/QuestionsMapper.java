package com.eval.backend.mapper.repository;

import com.eval.backend.dto.questions.request.PostQuestionDto;
import com.eval.backend.dto.questions.response.GetQuestionsDto;
import com.eval.backend.entity.Questions;
import java.util.List;

public interface QuestionsMapper {

    List<Questions> convertPostQuestionsDtoToQuestions(List<PostQuestionDto> postQuestionDtoList);
    List<GetQuestionsDto> convertQuestionsToGetQuestionsDto(List<Questions> questionsList);

}
