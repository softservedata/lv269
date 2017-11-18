package com.softserve.edu.opencart.data.products;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

public class ProductRepository {
	
	private static final double EURO_VALUE = 0.86012626;
	private static final double POUND_VALUE = 0.75803518;

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
    
    public IProduct iPhone() {
    	
    	double dollarPrice = 101.00;
    	double euroPrice = Double.parseDouble(String.format("%.2f", dollarPrice * EURO_VALUE).replace(",","."));
        double poundPrice = Double.parseDouble(String.format("%.2f", dollarPrice * POUND_VALUE).replace(",","."));
        
        Map<String, Double> macBookPrices = new HashedMap<>();    
        macBookPrices.put("Euro", euroPrice);
        macBookPrices.put("Pound Sterling", poundPrice);
        macBookPrices.put("US Dollar", dollarPrice);
        return new Product("iPhone",
                "iPhone is a revolutionary new mobile phone that allows you to make a call by simply tapping a nam..",
                macBookPrices);
    }
    
    public IProduct canonEOS5D() {
        Map<String, Double> macBookPrices = new HashedMap<>();
        macBookPrices.put("Euro", 68.81);
        macBookPrices.put("Pound Sterling", 60.64);
        macBookPrices.put("US Dollar", 80.00);
        return new Product("Canon EOS 5D",
                "Canon's press material for the EOS 5D states that it 'defines (a) new D-SLR category', while we'r..",
                macBookPrices);
    }

}
