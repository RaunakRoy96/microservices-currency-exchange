package com.mindtree.currencyexchangeservice.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.currencyexchangeservice.dto.CurrencyExchangeDto;
import com.mindtree.currencyexchangeservice.entity.CurrencyExchange;
import com.mindtree.currencyexchangeservice.exception.CurrencyExchangeNotFoundException;
import com.mindtree.currencyexchangeservice.service.CurrencyExchangeService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value="/v1/currencyExchange")
@CrossOrigin(origins="*")
public class CurrencyExchangeController {
	
	@Autowired
	private CurrencyExchangeService currencyExchangeService;
	@Autowired
	private ModelMapper modelMapper;
	
	
	@GetMapping(value="/from/{from}/to/{to}")
	@HystrixCommand(fallbackMethod="returnFallBackValue")
	public ResponseEntity<CurrencyExchangeDto> getExchangeValue(@PathVariable String from, @PathVariable String to) throws CurrencyExchangeNotFoundException {
		CurrencyExchange currencyExchange =  currencyExchangeService.getExchangeValue(from, to);
		CurrencyExchangeDto currencyExchangeDto = modelMapper.map(currencyExchange, CurrencyExchangeDto.class);
		return new ResponseEntity<CurrencyExchangeDto>(currencyExchangeDto, HttpStatus.OK);
	}
	
	public ResponseEntity<CurrencyExchangeDto> returnFallBackValue(String from, String to) {
		CurrencyExchangeDto currencyExchangeDto = modelMapper.map(new CurrencyExchange(404,from, to, 1, 404), CurrencyExchangeDto.class);
		return new ResponseEntity<CurrencyExchangeDto>(currencyExchangeDto, HttpStatus.OK);
	}
	

}