package com.softserve.edu.opencart.db.service;

import java.util.ArrayList;
import java.util.List;

import com.softserve.edu.opencart.data.users.IUser;
import com.softserve.edu.opencart.db.dao.CustomerDao;
import com.softserve.edu.opencart.db.entity.CustomerDB;
import com.softserve.edu.opencart.db.entity.CustomerDB.CustomerDBFields;

public class CustomerService {
    private CustomerDao customerDao;
    // private AdressDao adressDao;

    public CustomerService() {
        customerDao = new CustomerDao();
    }

    public String[] getCustomerByEmail(String email) {
        return customerDao.getFields(customerDao
                .getByFieldName(CustomerDBFields.EMAIL.toString(), email).get(0));
    }

    public List<String[]> getAllCustomers() {
        List<String[]> result = new ArrayList<>();
        for (CustomerDB customerDB : customerDao.getAll()) {
            result.add(customerDao.getFields(customerDB));
        }
        return result;
    }

    public void updateCustomer(IUser user) {
        // TODO
        customerDao.updateByFieldName(CustomerDBFields.FIRSTNAME.toString(), user.getFirstname(),
                CustomerDBFields.EMAIL.toString(), user.getEmail());
        customerDao.updateByFieldName(CustomerDBFields.LASTNAME.toString(), user.getLastname(),
                CustomerDBFields.EMAIL.toString(), user.getEmail());
        customerDao.updateByFieldName(CustomerDBFields.TELEPHONE.toString(), user.getPhoneNumber(),
                CustomerDBFields.EMAIL.toString(), user.getEmail());
    }

    public boolean deleteCustomerByEmail(String email) {
        return customerDao.deleteByFieldName(CustomerDBFields.EMAIL.toString(), email);
    }

    public boolean deleteUsersById(Long id) {
        return customerDao.deleteById(id);
    }

    public boolean delete(IUser user) {
        return deleteCustomerByEmail(user.getEmail());
    }

}
