package com.softserve.edu.opencart.data.products;

import java.util.List;

public interface ISearchProduct {

    String getProductName();

    String getProductDescription();

    List<String> getProducts();
}