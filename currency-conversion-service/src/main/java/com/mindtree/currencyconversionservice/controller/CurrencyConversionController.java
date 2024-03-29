package com.mindtree.currencyconversionservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.currencyconversionservice.entity.CurrencyConversion;
import com.mindtree.currencyconversionservice.service.CurrencyExchangeService;

@RestController
@RequestMapping(value="/v1/currencyConversion")
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeService currencyExchangeService;
	
	@GetMapping(value="/from/{from}/to/{to}/quantity/{quantity}")
	public ResponseEntity<CurrencyConversion> getCalculatedValue(
			@PathVariable String from, @PathVariable String to, @PathVariable int quantity) {
		
		return new ResponseEntity<CurrencyConversion>(
				currencyExchangeService.getCalculatedValue(from, to, quantity), HttpStatus.OK);
	}
	
	@GetMapping(value="/from/{from}/to/{to}/quantity/{quantity}",params="RestTemplate")
	public ResponseEntity<CurrencyConversion> getCalculatedValueWithRestTemplate(
			@PathVariable String from, @PathVariable String to, @PathVariable int quantity) {
		
		return new ResponseEntity<CurrencyConversion>(
				currencyExchangeService.getCalculatedValueWithRestTemplate(from, to, quantity), HttpStatus.OK);
	}
	
	

}
