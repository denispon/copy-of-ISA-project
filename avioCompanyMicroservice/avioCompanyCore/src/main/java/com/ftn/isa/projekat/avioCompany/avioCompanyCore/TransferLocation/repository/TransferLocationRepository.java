package com.ftn.isa.projekat.avioCompany.avioCompanyCore.TransferLocation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.isa.projekat.avioCompany.avioCompanyCore.TransferLocation.model.TransferLocation;

@Repository
public interface TransferLocationRepository extends JpaRepository<TransferLocation, Long>
{

}
