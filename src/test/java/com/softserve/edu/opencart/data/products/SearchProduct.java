package com.softserve.edu.opencart.data.products;

import java.util.List;

public class SearchProduct implements ISearchProduct{

    private String productName;
    private String productDescription;
    private List<String> products;

    public SearchProduct(String productName, List<String> products) {
        this.productName = productName;
        this.products = products;
    }

    public SearchProduct(String productName, String productDescription, List<String> products) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.products = products;
    }

    // getters
    public String getProductName() {
        return productName;
    }

    public String getProductDescription(){
        return productDescription;
    }

    public List<String> getProducts() {
        return products;
    }

    // setters
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }
}