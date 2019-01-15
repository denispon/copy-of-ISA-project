package com.ftn.isa.projekat.avioCompany.avioCompanyCore.TransferLocation.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.TransferLocationDTO;

@Component
public interface ITransferLocationService {

	TransferLocationDTO findOneById(Long id);

	List<TransferLocationDTO> findAll();

	TransferLocationDTO save(TransferLocationDTO dto);

	TransferLocationDTO deleteById(Long id);

	TransferLocationDTO changeLocation(Long id, TransferLocationDTO transferLocationDTO);

}
