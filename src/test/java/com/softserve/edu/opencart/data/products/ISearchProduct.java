package com.softserve.edu.opencart.data.products;

import java.util.List;

public interface ISearchProduct {

    String getProductName();

    String getProductCategory();

    String getProductDescription();

    List<String> getProducts();
}