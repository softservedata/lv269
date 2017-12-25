package com.softserve.edu.opencart.db.dao;

import com.softserve.edu.opencart.db.entity.CurrencyDB;
import com.softserve.edu.opencart.db.entity.CurrencyDB.CurrencyDBQueries;

public class CurrencyDao extends ADaoCRUD<CurrencyDB>{
	
	protected void init() {
        System.out.println("***CurrencyDao init()");
        for (CurrencyDBQueries currencyDBQueries : CurrencyDBQueries.values()) {
            sqlQueries.put(currencyDBQueries.getQueryName(), currencyDBQueries);
        }
        System.out.println("***CurrencyDao sqlQueries: " + sqlQueries);
    }

    public CurrencyDB createInstance(String[] args) {
        return new CurrencyDB(Long.parseLong(args[0] == null ? "0" : args[0]),
                args[1] == null ? new String() : args[1],
                args[2] == null ? new String() : args[2],
                args[3] == null ? new String() : args[3],
                args[4] == null ? new String() : args[4],
                Double.parseDouble(args[5] == null ? "0" : args[5]));
    }

    public String[] getFields(CurrencyDB entity) {
        String[] fields = new String[6];
        fields[0] = entity.getCurrencyId().toString();
        fields[1] = entity.getTitle();
        fields[2] = entity.getCode();
        fields[3] = entity.getSymbolLeft();
        fields[4] = entity.getSymbolRight();
        fields[5] = entity.getValue().toString();
        return fields;
    }

}
