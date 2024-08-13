package com.AlpDereli.StajProjesi.controller;


import com.AlpDereli.StajProjesi.model.Admin;
import com.AlpDereli.StajProjesi.model.AdminDto;
import com.AlpDereli.StajProjesi.model.Organisation;
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
}
