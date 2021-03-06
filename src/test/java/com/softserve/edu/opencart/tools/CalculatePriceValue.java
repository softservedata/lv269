package com.softserve.edu.opencart.tools;

public class CalculatePriceValue {

	private static final double DOLLAR_VALUE = 1.00000000;
	private static final double EURO_VALUE = 0.86012626;
	private static final double POUND_VALUE = 0.75803518;

	public static double euroPrice(double defaultValue) {
		return Double.parseDouble(String.format("%.2f", defaultValue * EURO_VALUE).replace(",","."));
	}
	
	public static double poundPrice(double defaultValue) {
		return Double.parseDouble(String.format("%.2f", defaultValue * POUND_VALUE).replace(",","."));
	}
	
	public static double dollarPrice(double defaultValue) {
		return Double.parseDouble(String.format("%.2f", defaultValue * DOLLAR_VALUE).replace(",","."));
	}
	
	public static double euroPrice(double defaultValue, double euroValue) {
		return Double.parseDouble(String.format("%.2f", defaultValue * euroValue).replace(",","."));
	}
	
	public static double poundPrice(double defaultValue, double poundValue) {
		return Double.parseDouble(String.format("%.2f", defaultValue * poundValue).replace(",","."));
	}
	
	public static double dollarPrice(double defaultValue, double dollarValue) {
		return Double.parseDouble(String.format("%.2f", defaultValue * dollarValue).replace(",","."));
	}
	
}
