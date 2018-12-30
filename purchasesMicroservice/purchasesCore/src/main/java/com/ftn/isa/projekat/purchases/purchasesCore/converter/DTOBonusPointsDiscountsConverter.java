package com.ftn.isa.projekat.purchases.purchasesCore.converter;

import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.purchases.purchasesApi.dto.BonusPointsDiscountsDTO;
import com.ftn.isa.projekat.purchases.purchasesCore.bonusPointsDiscounts.model.BonusPointsDiscounts;

@Component
public class DTOBonusPointsDiscountsConverter {
	
	public BonusPointsDiscountsDTO convertToDTO(BonusPointsDiscounts bonusPoints) {
		
		BonusPointsDiscountsDTO dto = new BonusPointsDiscountsDTO();
		
		dto.setId(bonusPoints.getId());
		dto.setPoints(bonusPoints.getPoints());
		dto.setDiscount(bonusPoints.getDiscount());
		
		
		return dto;
		
	}
	
	public BonusPointsDiscounts convertFromDTO (BonusPointsDiscountsDTO dto) {
		
		BonusPointsDiscounts bean = new BonusPointsDiscounts();
		
		bean.setId(dto.getId());
		bean.setPoints(dto.getPoints());
		bean.setDiscount(dto.getDiscount());
		
		return bean;
		
	}

}
