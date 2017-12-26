package com.softserve.edu.opencart.db.service;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.opencart.db.dao.ProductDao;
import com.softserve.edu.opencart.db.entity.ProductDB;
import com.softserve.edu.opencart.db.entity.ProductDB.ProductDBFields;

public class ProductService {

	private ProductDao productDao;

	public ProductService() {
		productDao = new ProductDao();
	}
	
	public String[] getProductById(Long id) {
        return productDao.getFields(productDao
                .getById(id));
    }
    
    public Double getProductPriceById(Long id) {
    	String[] fields = productDao.getFields(productDao
                .getById(id));
    	return Double.parseDouble(fields[1]);
    }

    public List<String[]> getAllProducts() {
        List<String[]> result = new ArrayList<>();
        for (ProductDB productDB : productDao.getAll()) {
            result.add(productDao.getFields(productDB));
        }
        return result;
    }
}
