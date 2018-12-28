package com.ftn.isa.projekat.purchases.purchasesCore.converter;

import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.purchases.purchasesApi.dto.ShoppingCartDTO;
import com.ftn.isa.projekat.purchases.purchasesCore.shoppingCart.model.ShoppingCart;

@Component
public class DTOShoppingCartConverter {

	public ShoppingCartDTO convertToDTO (ShoppingCart bean) {
		
		ShoppingCartDTO dto = new ShoppingCartDTO();
		
		dto.setCarReservationId(bean.getCarReservationId());
		dto.setId(bean.getId());
		dto.setUserId(bean.getUserId());
		
		return dto;
		
	}
	
	public ShoppingCart convertFromDTO (ShoppingCartDTO dto) {
		
		ShoppingCart bean = new ShoppingCart();
		
		bean.setCarReservationId(dto.getCarReservationId());
		bean.setId(dto.getId());
		bean.setUserId(dto.getUserId());
		
		return bean;
	}
	
}
