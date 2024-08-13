package com.AlpDereli.StajProjesi.controller;


import com.AlpDereli.StajProjesi.model.*;
import com.AlpDereli.StajProjesi.repository.OrganizationRepository;
import com.AlpDereli.StajProjesi.service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/management")
public class ManagementController {

    private final ManagementService managementService;

    @Autowired
    public ManagementController(ManagementService managementService, OrganizationRepository organizationRepository) {
        this.managementService = managementService;
    }


    @PostMapping("/admin/organisations")
    public ResponseEntity<Organisation> addOrganisation(@RequestBody Organisation organisation) {
        System.out.println("Received organisation: " + organisation);
        Organisation savedOrganisation = managementService.addOrganisation(organisation);
        return ResponseEntity.ok(savedOrganisation);
    }

    @PutMapping("/admin/update/{id}")
    public ResponseEntity<String> updateAdmin(@PathVariable int id,@RequestBody AdminDto adminDto) {
        managementService.updateAdmin(id, adminDto);
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
}
