package com.softserve.edu.opencart.data.products;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yurii Ivanytskyi
 */
public class PriceSymbolProduct implements IPriceSymbolProduct{

	private String name;
	private String description;
	private Map<String, String> symbols;

	public PriceSymbolProduct(String name, String description, Map<String, String> symbols) {
		this.name = name;
		this.description = description;
		this.symbols = symbols;
	}

	public PriceSymbolProduct(String name, String description) {
		this.name = name;
		this.description = description;
		this.symbols = new HashMap<>();
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getDescription(String key) {
		return getSymbols().get(key);
	}

	public Map<String, String> getSymbols() {
		return symbols;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(String currency, String symbol) {
		getSymbols().put(currency, symbol);
	}

	public void setPrices(Map<String, String> symbols) {
		this.symbols = symbols;
	}

}
