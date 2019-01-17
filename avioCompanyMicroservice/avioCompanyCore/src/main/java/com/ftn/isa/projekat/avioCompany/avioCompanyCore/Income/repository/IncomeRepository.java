package com.ftn.isa.projekat.avioCompany.avioCompanyCore.Income.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Income.model.Income;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long>  {

}
