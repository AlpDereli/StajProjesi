package com.AlpDereli.StajProjesi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private int id;

    @Size(max = 2000, message = "Question text can be at most 2000 characters long")
    private String question;

    @ElementCollection
    //@Column(name="answers")
    @Size(min = 2, max = 5, message = "A question must have between 2 and 5 options")
    private List<@Size(max = 500, message = "Option text can be at most 500 characters long")String> answer = new ArrayList<String>();

    private int organizationId;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @Size(max = 2000, message = "Question text can be at most 2000 characters long") String getQuestion() {
        return question;
    }

    public void setQuestion(@Size(max = 2000, message = "Question text can be at most 2000 characters long") String question) {
        this.question = question;
    }

    public @Size(min = 2, max = 5, message = "A question must have between 2 and 5 options") List<@Size(max = 500, message = "Option text can be at most 500 characters long") String> getAnswer() {
        return answer;
    }

    public void setAnswer(@Size(min = 2, max = 5, message = "A question must have between 2 and 5 options") List<@Size(max = 500, message = "Option text can be at most 500 characters long") String> answer) {
        this.answer = answer;
    }

    public int getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(int organizationId) {
        this.organizationId = organizationId;
    }
}
