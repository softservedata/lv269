package com.softserve.edu.opencart.tests.smoke;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.users.IUser;
import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.db.service.CustomerLoginService;
import com.softserve.edu.opencart.db.service.CustomerService;
import com.softserve.edu.opencart.tests.TestRunner;

public class DBTest extends TestRunner {
    CustomerService customerService;
    CustomerLoginService customerLoginService;

    @BeforeClass
    public void beforeDB() {
        customerService = new CustomerService();
        customerLoginService = new CustomerLoginService();
        System.out.println("***beforeDB() done");
    }

    //@Test
    public void checkAllUsers() throws Exception {
        System.out.println("***Before ...");
        for (IUser user : UserRepository.get().fromDB()) {
            System.out.println("EMail = " + user.getEmail());
        }
        System.out.println("User Quantity = " + UserRepository.get().fromDB().size());
        System.out.println("Deleting gugik20062@ukr.net ...");
        customerService.deleteCustomerByEmail("gugik20062@ukr.net");
        System.out.println("***After Update ...");
        for (IUser user : UserRepository.get().fromDB()) {
            System.out.println("EMail = " + user.getEmail());
        }
        System.out.println("User Quantity = " + UserRepository.get().fromDB().size());
    }

    //@Test
    public void checkCustomerLogin() throws Exception {
        System.out.println("***Before ...");
        for (String[] current : customerLoginService.getAllCustomerLogins()) {
            //System.out.println("EMail = " + current[1] + " \tTotal = " + current[3]);
            for (int i = 0; i<current.length; i++) {
                System.out.print(current[i] + "\t");
            }
            System.out.println();
        }
        System.out.println("unlock aaaa ...");
//        customerLoginService.unlockCustomerLoginByEmail("aaaa");
        for (String[] current : customerLoginService.getAllCustomerLogins()) {
            //System.out.println("EMail = " + current[1] + " \tTotal = " + current[3]);
            for (int i = 0; i<current.length; i++) {
                System.out.print(current[i] + "\t");
            }
            System.out.println();
        }
    }
    @Test
    public void checkCustomer() throws Exception {
        customerService.deleteCustomerByEmail("testfordelete@mail.ru");
        System.out.println("***After Update ...");
        for (IUser user : UserRepository.get().fromDB()) {
            System.out.println("EMail = " + user.getEmail());
        }
        System.out.println("User Quantity = " + UserRepository.get().fromDB().size());
    }

}