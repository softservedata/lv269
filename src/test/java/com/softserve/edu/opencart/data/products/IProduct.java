package com.softserve.edu.opencart.data.products;

public interface IProduct {
    String getName();

    String getDescription();

    Prices getDescription(String key);

}
