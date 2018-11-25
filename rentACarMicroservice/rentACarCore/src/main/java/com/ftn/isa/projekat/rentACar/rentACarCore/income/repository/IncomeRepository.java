package com.ftn.isa.projekat.rentACar.rentACarCore.income.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.isa.projekat.rentACar.rentACarCore.income.model.Income;

public interface IncomeRepository extends JpaRepository< Income, Long> {

}
