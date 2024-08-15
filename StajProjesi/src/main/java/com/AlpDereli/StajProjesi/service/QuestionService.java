package com.AlpDereli.StajProjesi.service;


import com.AlpDereli.StajProjesi.model.Question;
import com.AlpDereli.StajProjesi.model.QuestionDto;
import com.AlpDereli.StajProjesi.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public void deleteQuestion(int id, int organizationId, boolean isAdmin) {
        Question question = questionRepository.findById(id).orElse(null);
        if (question == null) {
            throw new RuntimeException("Question not found");
        }
        else{
            if (!isAdmin || question.getOrganizationId() != organizationId) {
                throw new RuntimeException("Unauthorized attempt to delete the question");
            } else {
                questionRepository.delete(question);
            }
        }
    }

    public void updateQuestion(QuestionDto questionDto, int id, int organizationId, boolean isAdmin) {
        Question findQuestion = questionRepository.findById(id).orElse(null);
        if (findQuestion == null) {
            throw new RuntimeException("Question not found");
        }
        else {
            if(findQuestion.getOrganizationId() != organizationId || !isAdmin){
                throw new RuntimeException("Unauthorized attempt to update the question");

            }
            else {
                findQuestion.setQuestion(questionDto.getQuestion());
                findQuestion.setAnswer(questionDto.getAnswer());
                questionRepository.save(findQuestion);
            }
        }
    }
}
