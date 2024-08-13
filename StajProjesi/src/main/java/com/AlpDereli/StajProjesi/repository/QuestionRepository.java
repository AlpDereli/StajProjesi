package com.AlpDereli.StajProjesi.repository;


import com.AlpDereli.StajProjesi.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
