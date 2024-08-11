package com.AlpDereli.StajProjesi.service;


import com.AlpDereli.StajProjesi.model.Organisation;
import com.AlpDereli.StajProjesi.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagementService {

    private final OrganizationRepository organizationRepository;

    @Autowired
    public ManagementService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public Organisation addOrganisation(Organisation organisation) {
        return organizationRepository.save(organisation);
    }
}
