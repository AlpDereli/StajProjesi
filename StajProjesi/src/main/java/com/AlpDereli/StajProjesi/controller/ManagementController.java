package com.AlpDereli.StajProjesi.controller;


import com.AlpDereli.StajProjesi.model.*;
import com.AlpDereli.StajProjesi.repository.OrganizationRepository;
import com.AlpDereli.StajProjesi.service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/management")
public class ManagementController {

    private final ManagementService managementService;

    @Autowired
    public ManagementController(ManagementService managementService, OrganizationRepository organizationRepository) {
        this.managementService = managementService;
    }

    //  /admin yapısına güvenlik sağlanır mı sor
    @PostMapping("/organisations")
    public ResponseEntity<Organisation> addOrganisation(@RequestBody Organisation organisation) {
        boolean b = isAdmin();
        Organisation savedOrganisation = managementService.addOrganisation(organisation,b);
        return ResponseEntity.ok(savedOrganisation);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateAdmin(@PathVariable int id,@RequestBody AdminDto adminDto) {
        boolean b = isAdmin();
        managementService.updateAdmin(id, adminDto,b);
        return ResponseEntity.ok("Admin updated");

    }


    @PutMapping("/organization/update/{id}")
    public ResponseEntity<String> updateOrganization(@PathVariable long id, @RequestBody OrganizationDto organizationDto) {
        managementService.updateOrganisation(id,organizationDto);
        return ResponseEntity.ok("Organization updated");
    }

    @PostMapping("/organization/sendmail/{id}")
    public String sendMail(@RequestBody SendEmailDto sendEmailDto, @PathVariable long id) {
        String s = managementService.sendMail(sendEmailDto,id);
        return (s);
    }


    private boolean isAdmin(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return true;//authentication.getAuthorities().stream()
        //.anyMatch(role -> role.getAuthority().equals("ADMIN"));

    }
}
