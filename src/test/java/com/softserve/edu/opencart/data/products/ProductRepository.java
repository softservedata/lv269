package com.softserve.edu.opencart.data.products;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

import com.softserve.edu.opencart.pages.Application;

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
    
    //???
    public IProduct iPhone() {
    	double defaultValue = 101.0;
        Map<String, Double> iPhonePrices = new HashedMap<>();    
        iPhonePrices.put("Euro", PriceValue.euroPrice(defaultValue));
        iPhonePrices.put("Pound Sterling", PriceValue.poundPrice(defaultValue));
        iPhonePrices.put("US Dollar", PriceValue.dollarPrice(defaultValue));
        return new Product("iPhone",
                "iPhone is a revolutionary new mobile phone that allows you to make a call by simply tapping a nam..",
                iPhonePrices);
    }
    
    public IProduct canonEOS5D() {
        Map<String, Double> canonEOS5DPrices = new HashedMap<>();
        canonEOS5DPrices.put("Euro", 68.81);
        canonEOS5DPrices.put("Pound Sterling", 60.64);
        canonEOS5DPrices.put("US Dollar", 80.00);
        return new Product("Canon EOS 5D",
                "Canon's press material for the EOS 5D states that it 'defines (a) new D-SLR category', while we'r..",
                canonEOS5DPrices);
    }

}
