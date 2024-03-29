package com.mindtree.currencyexchangeservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mindtree.currencyexchangeservice.exception.CurrencyExchangeNotFoundException;

@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaRepositories
@EnableHystrix
@EnableCircuitBreaker
@ControllerAdvice
public class CurrencyExchangeServiceApplication extends ResponseEntityExceptionHandler{

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
	}
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest webRequest) {
		return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(CurrencyExchangeNotFoundException.class)
	public final ResponseEntity<Object> handleCurrencyExchangeNotFoundException(Exception exception, WebRequest webRequest) {
		return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

}
