package com.AlpDereli.StajProjesi.model;

import java.util.List;

public class QuestionDto {
    private String question;
    private List<String> answer;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswer() {
        return answer;
    }

    public void setAnswer(List<String> answer) {
        this.answer = answer;
    }
}
