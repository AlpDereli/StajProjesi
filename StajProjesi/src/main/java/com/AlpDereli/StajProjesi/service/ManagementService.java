package com.AlpDereli.StajProjesi.service;


import com.AlpDereli.StajProjesi.model.Admin;
import com.AlpDereli.StajProjesi.model.AdminDto;
import com.AlpDereli.StajProjesi.model.Organisation;
import com.AlpDereli.StajProjesi.repository.AdminRepository;
import com.AlpDereli.StajProjesi.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagementService {

    private final OrganizationRepository organizationRepository;
    private final AdminRepository adminRepository;

    @Autowired
    public ManagementService(OrganizationRepository organizationRepository, AdminRepository adminRepository) {
        this.organizationRepository = organizationRepository;
        this.adminRepository = adminRepository;
    }

    public Organisation addOrganisation(Organisation organisation) {
        return organizationRepository.save(organisation);
    }


    public void updateAdmin(int id, AdminDto adminDto){
        if (adminDto.getName() == null || adminDto.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        Admin find = adminRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        find.setName(adminDto.getName());
        find.setPassword(adminDto.getPassword());
        adminRepository.save(find);
    }
}

