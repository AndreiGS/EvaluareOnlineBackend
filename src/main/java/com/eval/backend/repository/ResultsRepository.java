package com.eval.backend.repository;

import com.eval.backend.entity.Results;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultsRepository extends JpaRepository<Results, String> {
}
