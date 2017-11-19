package com.softserve.edu.opencart.data.products;

import java.util.List;

public class SearchProduct implements ISearchProduct{

    private String productName;
    private String productDescription;
    private String productCategory;
    private List<String> products;

    public SearchProduct(String productName, List<String> products) {
        this.productName = productName;
        this.products = products;
    }

    public SearchProduct(String productName, String productCategory){
        this.productName = productName;
        this.productCategory = productCategory;
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

    public String getProductCategory(){
        return productCategory;
    }

    public List<String> getProducts() {
        return products;
    }

    // setters
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }
}