package com.softserve.edu.opencart.db.service;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.opencart.db.dao.CustomerLoginDao;
import com.softserve.edu.opencart.db.entity.CustomerLoginDB;
import com.softserve.edu.opencart.db.entity.CustomerLoginDB.CustomerLoginDBFields;
import com.softserve.edu.opencart.tools.TimeUtils;
import com.softserve.edu.opencart.tools.TimeUtils.TimeTemplates;

public class CustomerLoginService {
    private CustomerLoginDao customerLoginDao;

    public CustomerLoginService() {
        customerLoginDao = new CustomerLoginDao();
    }

    public List<String[]> getAllCustomerLogins() {
        List<String[]> result = new ArrayList<>();
        for (CustomerLoginDB customerLoginDB : customerLoginDao.getAll()) {
            result.add(customerLoginDao.getFields(customerLoginDB));
        }
        return result;
    }

    public Long getTotalByEmail(String email) {
        return customerLoginDao.getByFieldName(CustomerLoginDBFields.EMAIL.toString(), email)
                .get(0).getTotal();
    }

    public void updateTotalByEmail(Long total, String email) {
        customerLoginDao.updateByFieldName(CustomerLoginDBFields.TOTAL.toString(), total.toString(),
                CustomerLoginDBFields.EMAIL.toString(), email);
    }

    public void unlockCustomerLoginByEmail(String email) {
        TimeUtils timeUtils = new TimeUtils(TimeTemplates.TIME_DB);
        customerLoginDao.updateByFieldName(CustomerLoginDBFields.DATE_ADDED.toString(),
                timeUtils.getTimeText(System.currentTimeMillis()-3600001),
                CustomerLoginDBFields.EMAIL.toString(), email);
        customerLoginDao.updateByFieldName(CustomerLoginDBFields.DATE_MODIFIED.toString(),
                timeUtils.getTimeText(System.currentTimeMillis()-3600000),
                CustomerLoginDBFields.EMAIL.toString(), email);
    }

    public boolean deleteCustomerLoginByEmail(String email) {
        return customerLoginDao.deleteByFieldName(CustomerLoginDBFields.EMAIL.toString(), email);
    }

}
