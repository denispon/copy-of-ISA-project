package com.ftn.isa.projekat.rentACar.rentACarCore.branchOffice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.isa.projekat.rentACar.rentACarCore.branchOffice.model.BranchOffice;

public interface BranchOfficeRepository extends JpaRepository < BranchOffice , Long > {

	Optional<BranchOffice> findOneById (Long id);
}
