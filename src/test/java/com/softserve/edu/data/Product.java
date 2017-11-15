package com.softserve.edu.data;

import java.util.Map;

public class Product {

    private String name;
    private String description;
    private Map<String, Double> prices;
    
    public Product(String name, String description, Map<String, Double> prices) {
        this.name = name;
        this.description = description;
        this.prices = prices;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
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

    public void setPrices(Map<String, Double> prices) {
        this.prices = prices;
    }
    
}
