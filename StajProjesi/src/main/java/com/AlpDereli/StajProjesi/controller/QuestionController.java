package com.AlpDereli.StajProjesi.controller;

import com.AlpDereli.StajProjesi.model.Question;
import com.AlpDereli.StajProjesi.model.QuestionDto;
import com.AlpDereli.StajProjesi.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }


    @DeleteMapping("/admin/question_delete/{id}")
    public void deleteQuestion(@PathVariable int id) {
        questionService.deleteQuestion(id);
    }

    @PutMapping("/admin/question_update/{id}")
    public void updateQuestion(@RequestBody QuestionDto questionDto, @PathVariable int id) {
        questionService.updateQuestion(questionDto, id);
    }
}
