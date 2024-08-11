package com.AlpDereli.StajProjesi.controller;


import com.AlpDereli.StajProjesi.model.Organisation;
import com.AlpDereli.StajProjesi.service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class ManagementController {

    private final ManagementService managementService;

    @Autowired
    public ManagementController(ManagementService managementService) {
        this.managementService = managementService;
    }


    @PostMapping("/organisations")
    public ResponseEntity<Organisation> addOrganisation(@RequestBody Organisation organisation) {
        Organisation savedOrganisation = managementService.addOrganisation(organisation);
        return ResponseEntity.ok(savedOrganisation);
    }
}
