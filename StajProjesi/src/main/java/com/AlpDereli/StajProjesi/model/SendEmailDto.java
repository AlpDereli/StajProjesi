package com.AlpDereli.StajProjesi.model;

import java.util.List;

public class SendEmailDto {
    private List<String> to;
    private String subject;

    public List<String> getTo() {
        return to;
    }

    public void setTo(List<String> to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
