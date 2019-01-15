package com.ftn.isa.projekat.avioCompany.avioCompanyCore.AvioIncome.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.isa.projekat.avioCompany.avioCompanyCore.AvioIncome.model.AvioIncome;

@Repository
public interface AvioIncomeRepository extends JpaRepository<AvioIncome, Long>
{

	

}
