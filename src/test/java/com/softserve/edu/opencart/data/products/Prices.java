package com.softserve.edu.opencart.data.products;

public class Prices {

	private int symbolAsciiCode;
	private double value;
	
	public Prices(int symbolAsciiCode, double value) {
		this.symbolAsciiCode = symbolAsciiCode;
		this.value = value;
	}

	public int getSymbolAsciiCode() {
		return symbolAsciiCode;
	}

	public double getValue() {
		return value;
	}

	public void getSymbolAsciiCode(char symbolAsciiCode) {
		this.symbolAsciiCode = symbolAsciiCode;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
}
