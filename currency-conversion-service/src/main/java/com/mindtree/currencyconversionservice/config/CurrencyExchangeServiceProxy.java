package com.mindtree.currencyconversionservice.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mindtree.currencyconversionservice.entity.CurrencyConversion;

@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	
	@GetMapping(value="/currency-exchange-service/v1/currencyExchange/from/{from}/to/{to}")
	public CurrencyConversion getExchangeValue(
			@PathVariable("from") String from, @PathVariable("to") String to);

}
