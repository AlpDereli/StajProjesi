package com.AlpDereli.StajProjesi.service;


import com.AlpDereli.StajProjesi.model.Question;
import com.AlpDereli.StajProjesi.model.QuestionDto;
import com.AlpDereli.StajProjesi.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public String deleteQuestion(int id) {
        questionRepository.deleteById(id);
        return "Question deleted";
    }

    public Question updateQuestion(QuestionDto questionDto, int id) {
        Question findQuestion = questionRepository.findById(id).orElse(null);
        if (findQuestion != null) {
            findQuestion.setQuestion(questionDto.getQuestion());
            findQuestion.setAnswer(questionDto.getAnswer());
            return questionRepository.save(findQuestion);
        }
        return questionRepository.save(findQuestion);
    }
}
