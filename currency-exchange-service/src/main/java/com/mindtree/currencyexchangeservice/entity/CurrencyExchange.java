package com.mindtree.currencyexchangeservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class CurrencyExchange {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String toCurrency;
	private String fromCurrecy;
	private double exchangeValue;
	@Transient
	private int port;
	
	public CurrencyExchange() {
		
	}
	
	

	public CurrencyExchange(int id, String toCurrency, String fromCurrecy, double exchangeValue, int port) {
		super();
		this.id = id;
		this.toCurrency = toCurrency;
		this.fromCurrecy = fromCurrecy;
		this.exchangeValue = exchangeValue;
		this.port = port;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}

	public String getFromCurrecy() {
		return fromCurrecy;
	}

	public void setFromCurrecy(String from) {
		this.fromCurrecy = from;
	}

	

	public double getExchangeValue() {
		return exchangeValue;
	}

	public void setExchangeValue(double exchangeValue) {
		this.exchangeValue = exchangeValue;
	}


	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	
	

}
