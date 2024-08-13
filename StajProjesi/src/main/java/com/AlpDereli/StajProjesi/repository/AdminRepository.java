package com.AlpDereli.StajProjesi.repository;

import com.AlpDereli.StajProjesi.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
}
