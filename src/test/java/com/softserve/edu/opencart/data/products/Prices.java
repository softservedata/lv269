package com.softserve.edu.opencart.data.products;

public class Prices {

	private String symbol;
	private double value;
	
	public Prices(String symbol, double value) {
		this.symbol = symbol;
		this.value = value;
	}

	public String getSymbol() {
		return symbol;
	}

	public double getValue() {
		return value;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
}
