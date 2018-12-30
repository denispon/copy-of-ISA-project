package com.ftn.isa.projekat.purchases.purchasesCore.converter;

import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.purchases.purchasesApi.dto.BonusPointsDTO;
import com.ftn.isa.projekat.purchases.purchasesCore.bonusPoints.model.BonusPoints;

@Component
public class DTOBonusPointsConverter {


	public BonusPointsDTO convertToDTO(BonusPoints bonusPoints) {
		
		BonusPointsDTO dto = new BonusPointsDTO();
		
		dto.setId(bonusPoints.getId());
		dto.setPoints(bonusPoints.getPoints());
		dto.setUserId(bonusPoints.getUserId());
		
		
		return dto;
		
	}
	
	public BonusPoints convertFromDTO (BonusPointsDTO dto) {
		
		BonusPoints bean = new BonusPoints();
		
		bean.setId(dto.getId());
		bean.setPoints(dto.getPoints());
		bean.setUserId(dto.getUserId());
		
		return bean;
		
	}
}
