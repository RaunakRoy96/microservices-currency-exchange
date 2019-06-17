package com.mindtree.currencyconversionservice.service;

import org.springframework.stereotype.Service;

import com.mindtree.currencyconversionservice.entity.CurrencyConversion;

@Service
public interface CurrencyExchangeService {

	

	CurrencyConversion getCalculatedValue(String from, String to, int quantity);

	CurrencyConversion getCalculatedValueWithRestTemplate(String from, String to, int quantity);

}
