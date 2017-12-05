package com.softserve.edu.opencart.data.products;

import java.util.HashMap;
import java.util.Map;

public class Product implements IProduct {

    private String name;
    private String description;
    private Map<String, Prices> prices;
    
    public Product(String name, String description, Map<String, Prices> prices) {
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

    public Prices getDescription(String key) {
        return getPrices().get(key);
    }

    public Map<String, Prices> getPrices() {
        return prices;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(String currency, Prices price) {
        getPrices().put(currency, price);
    }

    public void setPrices(Map<String, Prices> prices) {
        this.prices = prices;
    }
    
}
