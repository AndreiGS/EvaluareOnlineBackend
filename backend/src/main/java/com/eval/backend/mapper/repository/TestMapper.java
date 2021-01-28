package com.eval.backend.mapper.repository;

import com.eval.backend.dto.test.response.GetTestDto;
import com.eval.backend.entity.Test;

public interface TestMapper {

    GetTestDto convertTestToGetTestDto(Test test);

}
