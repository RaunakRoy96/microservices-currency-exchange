package com.mindtree.currencyexchangeservice.service;

import org.springframework.stereotype.Service;

import com.mindtree.currencyexchangeservice.entity.CurrencyExchange;
import com.mindtree.currencyexchangeservice.exception.CurrencyExchangeNotFoundException;
import com.netflix.discovery.provider.Serializer;

@Service
public interface CurrencyExchangeService {

	CurrencyExchange getExchangeValue(String from, String to) throws CurrencyExchangeNotFoundException;

}