package com.softserve.edu.opencart.db.service;

import java.util.List;

import com.softserve.edu.opencart.data.users.IUser;
import com.softserve.edu.opencart.db.entity.CustomerDB;

public class CustomerService {

    private IUser adminUserToAdminUserDB(CustomerDB customerDB) {
//        return new AdminUserDB(0L, adminUser.getFirstname(),
//                adminUser.getLastname(), adminUser.getMail(),
//                adminUser.getUsername(), adminUser.getPassword());
        return null;
    }

    public IUser getCustomertByEmail(String email) {
//        return AdminUserRepository.get().adminUserConvert(AdminUserDao.get()
//                .getByFieldName(AdminUserDBFields.USERNAME.toString(), login).get(0));
        return null;
    }

    public List<IUser> getAllCustomers() {
//        List<IAdminUser> adminUsers = new ArrayList<IAdminUser>(); 
//        for (AdminUserDB adminUserDB : AdminUserDao.get().getAll()) {
//            adminUsers.add(AdminUserRepository.get().adminUserConvert(adminUserDB));
//        }
//        return adminUsers;
        return null;
    }

    public void updateCustomer(IUser user) {}
    
    public boolean deleteCustomerByEmail(String email) {
        //return deleteUsersById(getAdminUserIdByLogin(login));
        return false;
    }

    public boolean deleteUsersById(Long id) {
        //return AdminUserDao.get().deleteById(id);
        return false;
   }

    public boolean delete(IUser user) {
        //return deleteUsersByLogin(adminUser.getUsername());
        return false;
    }

}
