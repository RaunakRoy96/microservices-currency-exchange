package com.mindtree.currencyexchangeservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.mindtree.currencyexchangeservice.entity.CurrencyExchange;
import com.mindtree.currencyexchangeservice.exception.CurrencyExchangeNotFoundException;
import com.mindtree.currencyexchangeservice.repository.CurrencyExchangeRepo;
import com.mindtree.currencyexchangeservice.service.CurrencyExchangeService;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {
	
	@Autowired
	private CurrencyExchangeRepo currencyExchangeRepo;
	@Autowired
	private Environment environment;
	
	/* (non-Javadoc)
	 * @see com.mindtree.currencyexchangeservice.service.impl.CurrencyExchange#getExchangeValue(java.lang.String, java.lang.String)
	 */
	@Override
	public CurrencyExchange getExchangeValue(String from, String to) throws CurrencyExchangeNotFoundException {
		CurrencyExchange currencyExchange = currencyExchangeRepo.findByFromCurrecyAndToCurrency(from, to).orElseThrow(()->  new CurrencyExchangeNotFoundException("Currencies could not be found"));
		currencyExchange.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return currencyExchange;
	}

}
