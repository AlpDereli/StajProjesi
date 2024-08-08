package com.AlpDereli.StajProjesi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.AlpDereli.StajProjesi.model.Question;


public interface QuestionRepository extends JpaRepository<Question, Long> {
}
