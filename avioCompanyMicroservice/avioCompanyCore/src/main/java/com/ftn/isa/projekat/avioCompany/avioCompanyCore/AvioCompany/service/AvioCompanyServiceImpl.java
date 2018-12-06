package com.ftn.isa.projekat.avioCompany.avioCompanyCore.AvioCompany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.AvioCompanyDTO;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.AvioCompany.repository.AvioCompanyRepository;

@Component
public class AvioCompanyServiceImpl implements IAvioCompanyService
{//ovde sam stao
	
//	@Autowired
//	AvioCompanyRepository avioCompanyRepository;
//	@Autowired
//	RentACarServiceRepository rentACarServiceRepository;
//	
//	@Autowired
//	DTOBranchOfficeConverter branchOfficeConverter;
//	@Autowired
//	DTORentACarServiceConverter rentServiceConverter;

	@Override
	public AvioCompanyDTO findOneById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AvioCompanyDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AvioCompanyDTO save(AvioCompanyDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AvioCompanyDTO deleteById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AvioCompanyDTO changeAvioCompany(Long id, AvioCompanyDTO avioDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
