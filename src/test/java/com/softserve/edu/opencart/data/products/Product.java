package com.softserve.edu.opencart.data.products;

import java.util.HashMap;
import java.util.Map;

public class Product implements IProduct {

    private String name;
    private String description;
    private Map<String, Double> prices;
    
    // TODO Develop Builder
 
    public Product(String name, String description, Map<String, Double> prices) {
        this.name = name;
        this.description = description;
        this.prices = prices;
    }

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
        this.prices = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getDescription(String key) {
        return getPrices().get(key);
    }

    public Map<String, Double> getPrices() {
        return prices;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(String currency, double price) {
        getPrices().put(currency, price);
    }

    public void setPrices(Map<String, Double> prices) {
        this.prices = prices;
    }
    
}
