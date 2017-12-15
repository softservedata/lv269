package com.softserve.edu.opencart.db.dao;

import com.softserve.edu.opencart.db.entity.CustomerDB;
import com.softserve.edu.opencart.db.entity.CustomerLoginDB;
import com.softserve.edu.opencart.db.entity.CustomerLoginDB.CustomerLoginDBQueries;

public class CustomerLoginDao extends ADaoCRUD<CustomerLoginDB> {

    // TODO Create abstract method in ADao
    protected void init() {
        for (CustomerLoginDBQueries customerLoginDBQueries : CustomerLoginDBQueries.values()) {
            sqlQueries.put(customerLoginDBQueries.getQueryName(), customerLoginDBQueries);
        }
    }

    protected CustomerLoginDB createInstance(String[] args) {
        return new CustomerLoginDB(Long.parseLong(args[0] == null ? "0" : args[0]),
                args[1] == null ? new String() : args[1],
                args[2] == null ? new String() : args[2],
                Long.parseLong(args[3] == null ? "0" : args[3]),
                args[4] == null ? new String() : args[4],
                args[5] == null ? new String() : args[5]);
    }

    protected String[] getFields(CustomerLoginDB entity) {
        // String[] fields = new String[UserDB.class.getDeclaredFields().length];
        String[] fields = new String[6];
        fields[0] = entity.getCustomerLoginId().toString();
        fields[1] = entity.getEmail();
        fields[2] = entity.getIp();
        fields[3] = entity.getTotal().toString();
        fields[4] = entity.getDateAdded();
        fields[5] = entity.getDateModified();
        return fields;
    }

}
