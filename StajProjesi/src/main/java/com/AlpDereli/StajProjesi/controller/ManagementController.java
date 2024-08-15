package com.AlpDereli.StajProjesi.controller;


import com.AlpDereli.StajProjesi.model.*;
import com.AlpDereli.StajProjesi.service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/management")
public class ManagementController {

    private final ManagementService managementService;

    @Autowired
    public ManagementController(ManagementService managementService) {
        this.managementService = managementService;
    }


    @PostMapping("/organisations")
    public ResponseEntity<Organisation> addOrganisation(@RequestBody Organisation organisation) {
        boolean isAdmin = isAdmin();
        Organisation savedOrganisation = managementService.addOrganisation(organisation,isAdmin);
        return ResponseEntity.ok(savedOrganisation);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateAdmin(@PathVariable int id,@RequestBody AdminDto adminDto) {
        boolean isAdmin = isAdmin();
        managementService.updateAdmin(id, adminDto,isAdmin);
        return ResponseEntity.ok("Admin updated");

    }


    @PutMapping("/organization/update/{id}")
    public ResponseEntity<String> updateOrganization(@PathVariable long id, @RequestBody OrganizationDto organizationDto) {
        managementService.updateOrganisation(id,organizationDto);
        return ResponseEntity.ok("Organization updated");
    }

    @PostMapping("/organization/sendmail/{id}")
    public String sendMail(@RequestBody SendEmailDto sendEmailDto, @PathVariable long id) {
        return (managementService.sendMail(sendEmailDto,id));
    }


    private boolean isAdmin(){
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return true;//authentication.getAuthorities().stream()
        //.anyMatch(role -> role.getAuthority().equals("ADMIN"));

    }
}
