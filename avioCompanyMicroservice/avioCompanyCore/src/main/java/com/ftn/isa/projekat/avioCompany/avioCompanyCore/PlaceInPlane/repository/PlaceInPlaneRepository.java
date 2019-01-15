package com.ftn.isa.projekat.avioCompany.avioCompanyCore.PlaceInPlane.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.isa.projekat.avioCompany.avioCompanyCore.PlaceInPlane.model.PlaceInPlane;

@Repository
public interface PlaceInPlaneRepository extends JpaRepository<PlaceInPlane, Long>
{

}
