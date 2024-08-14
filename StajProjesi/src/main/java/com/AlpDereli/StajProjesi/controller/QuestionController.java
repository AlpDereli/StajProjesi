package com.AlpDereli.StajProjesi.controller;

import com.AlpDereli.StajProjesi.model.Organisation;
import com.AlpDereli.StajProjesi.model.Question;
import com.AlpDereli.StajProjesi.model.QuestionDto;
import com.AlpDereli.StajProjesi.repository.QuestionRepository;
import com.AlpDereli.StajProjesi.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question")
public class QuestionController {

    //@Autowired
    //private JWTutil jwTutil;

    /*
    public int getAuthenticatedOrganizationId() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
        String jwtToken = (String) authentication.getCredentials(); // Assume JWT is stored in credentials
        Claims claims = jwtutil.extractClaims(jwtToken);

        if (claims != null) {
            return (int) claims.get("organizationId"); // Extract organizationId from JWT claims
        }
    }
    throw new RuntimeException("Organization ID not found in token or user is not authenticated");
}
     */

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }


    @DeleteMapping("/question_delete/{id}")
    public void deleteQuestion(@PathVariable int id) {
        int orgId = organisationId();
        boolean b = isAdmin();
        questionService.deleteQuestion(id, orgId, b);
    }

    @PutMapping("/question_update/{id}")
    public void updateQuestion(@RequestBody QuestionDto questionDto, @PathVariable int id) {
        int orgId = organisationId();
        boolean b = isAdmin();
        questionService.updateQuestion(questionDto, id, orgId, b);
    }

    private int organisationId(){
        //int organizationId = getAuthenticatedOrganizationId();
        return 1;  //returnu güncelle
    }

    private boolean isAdmin(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return true;//authentication.getAuthorities().stream()
                //.anyMatch(role -> role.getAuthority().equals("ADMIN"));

    }
}
