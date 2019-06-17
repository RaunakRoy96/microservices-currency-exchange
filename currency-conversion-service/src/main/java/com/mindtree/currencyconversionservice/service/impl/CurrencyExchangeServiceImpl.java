package com.mindtree.currencyconversionservice.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mindtree.currencyconversionservice.config.CurrencyExchangeServiceProxy;
import com.mindtree.currencyconversionservice.entity.CurrencyConversion;
import com.mindtree.currencyconversionservice.service.CurrencyExchangeService;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {
	
	@Autowired
	private Environment environment;
	@Autowired
	private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public CurrencyConversion getCalculatedValue(String from, String to, int quantity) {
		
		CurrencyConversion currencyExchange = currencyExchangeServiceProxy.getExchangeValue(from, to);
		currencyExchange.setQuantity(quantity);
		currencyExchange.setTotalCalculatedAmount(currencyExchange.getExchangeValue() * currencyExchange.getQuantity());
		currencyExchange.setSecondPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return currencyExchange;
	}
	
	@Override
	public CurrencyConversion getCalculatedValueWithRestTemplate(String from, String to, int quantity) {
		
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		CurrencyConversion currencyExchange = restTemplate.getForObject("http://currency-exchange-service/v1/currencyExchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);
		currencyExchange.setQuantity(quantity);
		currencyExchange.setTotalCalculatedAmount(currencyExchange.getExchangeValue() * currencyExchange.getQuantity());
		currencyExchange.setSecondPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return currencyExchange;
	}
	
	

}
