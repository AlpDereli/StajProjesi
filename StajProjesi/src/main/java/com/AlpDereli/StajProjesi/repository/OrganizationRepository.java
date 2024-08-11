package com.AlpDereli.StajProjesi.repository;


import com.AlpDereli.StajProjesi.model.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organisation, Long> {


}
