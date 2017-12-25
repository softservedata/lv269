package com.softserve.edu.opencart.db.dao;

import com.softserve.edu.opencart.db.entity.ProductDB;
import com.softserve.edu.opencart.db.entity.ProductDB.ProductDBQueries;

public class ProductDao extends ADaoCRUD<ProductDB>{

	protected void init() {
        System.out.println("***CurrencyDao init()");
        for (ProductDBQueries productDBQueries : ProductDBQueries.values()) {
            sqlQueries.put(productDBQueries.getQueryName(), productDBQueries);
        }
        System.out.println("***CurrencyDao sqlQueries: " + sqlQueries);
    }
	
	public ProductDB createInstance(String[] args) {
        return new ProductDB(Long.parseLong(args[0] == null ? "0" : args[0]),
                Double.parseDouble(args[1] == null ? "0" : args[1]));
    }

    public String[] getFields(ProductDB entity) {
        String[] fields = new String[6];
        fields[0] = entity.getProductId().toString();
        fields[1] = entity.getPrice().toString();
        return fields;
    }
}
