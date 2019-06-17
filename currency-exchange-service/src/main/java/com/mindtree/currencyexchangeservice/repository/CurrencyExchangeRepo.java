package com.mindtree.currencyexchangeservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.currencyexchangeservice.entity.CurrencyExchange;

@Repository
public interface CurrencyExchangeRepo extends JpaRepository<CurrencyExchange, Integer> {
	
	public Optional<CurrencyExchange> findByFromCurrecyAndToCurrency(String from, String to);

}
