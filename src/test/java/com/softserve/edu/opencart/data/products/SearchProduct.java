package com.softserve.edu.opencart.data.products;

import java.util.List;

public class SearchProduct {

    private String productName;
    private List<Product> products;
    
    public SearchProduct(String productName, List<Product> products) {
        this.productName = productName;
        this.products = products;
    }

    // setters

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // getters
    
    public String getProductName() {
        return productName;
    }

    public List<Product> getProducts() {
        return products;
    }

}
