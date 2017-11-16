package com.softserve.edu.opencart.data.products;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

public class ProductRepository {

    private static volatile ProductRepository instance = null;

    private ProductRepository() {
    }

    public static ProductRepository get() {
        if (instance == null) {
            synchronized (ProductRepository.class) {
                if (instance == null) {
                    instance = new ProductRepository();
                }
            }
        }
        return instance;
    }

    public IProduct macBook() {
        Map<String, Double> macBookPrices = new HashedMap<>();
        macBookPrices.put("Euro", 430.06);
        macBookPrices.put("Pound Sterling", 379.02);
        macBookPrices.put("US Dollar", 500.0);
        return new Product("MacBook",
                "Intel Core 2 Duo processor Powered by an Intel Core 2 Duo processor at speeds up to 2.1..",
                macBookPrices);
    }

}
