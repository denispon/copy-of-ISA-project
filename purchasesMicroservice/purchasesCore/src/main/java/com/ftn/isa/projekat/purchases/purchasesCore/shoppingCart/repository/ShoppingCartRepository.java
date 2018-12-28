package com.ftn.isa.projekat.purchases.purchasesCore.shoppingCart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftn.isa.projekat.purchases.purchasesCore.shoppingCart.model.ShoppingCart;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

}
