package com.mindtree.currencyexchangeservice.dto;

import javax.persistence.Transient;

public class CurrencyExchangeDto {

	private int id;
	private String toCurrency;
	private String fromCurrecy;
	private double exchangeValue;
	private int port;
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
	public void setFromCurrecy(String fromCurrecy) {
		this.fromCurrecy = fromCurrecy;
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
