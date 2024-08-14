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

    public String deleteQuestion(int id, int organizationId, boolean isAdmin) {
        Question question = questionRepository.findById(id).orElse(null);
        if (question == null) {
            throw new RuntimeException("Question not found");
        }

            if (isAdmin || question.getOrganizationId() == organizationId) {
                questionRepository.delete(question);
            } else {
                throw new RuntimeException("Unauthorized attempt to delete the question");
            }


        return ".";
    }

    public Question updateQuestion(QuestionDto questionDto, int id, int organizationId, boolean isAdmin) {
        Question findQuestion = questionRepository.findById(id).orElse(null);
        if (findQuestion != null) {
            if(findQuestion.getOrganizationId() == organizationId || isAdmin){
                findQuestion.setQuestion(questionDto.getQuestion());
                findQuestion.setAnswer(questionDto.getAnswer());
                return questionRepository.save(findQuestion);
            }
            else {
                throw new RuntimeException("Unauthorized attempt to update the question");
            }
        }
        else {
            throw new RuntimeException("Question not found");
        }
    }
}
