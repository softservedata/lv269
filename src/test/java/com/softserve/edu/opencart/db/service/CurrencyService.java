package com.softserve.edu.opencart.db.service;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.opencart.db.dao.CurrencyDao;
import com.softserve.edu.opencart.db.entity.CurrencyDB;
import com.softserve.edu.opencart.db.entity.CurrencyDB.CurrencyDBFields;

public class CurrencyService {

	private CurrencyDao currencyDao;

    public CurrencyService() {
    	currencyDao = new CurrencyDao();
    }

    public String[] getCurrencyByCode(String code) {
        return currencyDao.getFields(currencyDao
                .getByFieldName(CurrencyDBFields.CODE.toString(), code).get(0));
    }
    
    public Double getCurrencyPriceValueByCode(String code) {
    	String[] fields = currencyDao.getFields(currencyDao
                .getByFieldName(CurrencyDBFields.CODE.toString(), code).get(0));
    	return Double.parseDouble(fields[5]);
    }
    
    public int getCurrencySymbolAsciiByCode(String code) {
    	String[] fields = currencyDao.getFields(currencyDao
                .getByFieldName(CurrencyDBFields.CODE.toString(), code).get(0));
    	if(code.equals("EUR")) {
    		return fields[4].charAt(0);
    	}else {
    		return fields[3].charAt(0);
    	}
    }

    public List<String[]> getAllCurrency() {
        List<String[]> result = new ArrayList<>();
        for (CurrencyDB currencyDB : currencyDao.getAll()) {
            result.add(currencyDao.getFields(currencyDB));
        }
        return result;
    }
}
