package com.ftn.isa.projekat.avioCompany.avioCompanyCore.AvioCompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.isa.projekat.avioCompany.avioCompanyCore.AvioCompany.model.AvioCompany;

@Repository
public interface AvioCompanyRepository extends JpaRepository<AvioCompany, Long>
{
	
}
