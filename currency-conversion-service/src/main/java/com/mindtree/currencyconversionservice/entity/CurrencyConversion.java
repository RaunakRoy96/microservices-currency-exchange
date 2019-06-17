package com.mindtree.currencyconversionservice.entity;

public class CurrencyConversion {

	private int id;
	private String toCurrency;
	private String fromCurrecy;
	private double exchangeValue;
	private int port;
	private int secondPort;
	private int quantity;
	private double totalCalculatedAmount;
	
	
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}
	public void setTotalCalculatedAmount(double totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}
	public int getSecondPort() {
		return secondPort;
	}
	public void setSecondPort(int secondPort) {
		this.secondPort = secondPort;
	}
	
	
	
}