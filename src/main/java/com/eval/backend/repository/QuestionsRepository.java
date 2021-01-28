package com.eval.backend.repository;

import com.eval.backend.entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionsRepository extends JpaRepository<Questions, String> {

    Optional<Questions> findByQuestion(String question);

}
