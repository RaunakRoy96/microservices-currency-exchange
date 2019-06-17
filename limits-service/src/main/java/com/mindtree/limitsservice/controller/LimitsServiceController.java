package com.mindtree.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.limitsservice.config.Configuration;
import com.mindtree.limitsservice.entity.LimitConfiguration;

@RestController
public class LimitsServiceController {
	
	@Autowired
	private Configuration configuration;
	
	@GetMapping(value="/limits")
	public ResponseEntity<LimitConfiguration> getLimits() {
		LimitConfiguration limitConfiguration = new LimitConfiguration(configuration.getMinimum(), configuration.getMaximum());
		return new ResponseEntity<LimitConfiguration>(limitConfiguration, HttpStatus.OK);
	}

}
