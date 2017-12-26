package com.softserve.edu.opencart.tests.address;

import com.softserve.edu.opencart.data.field.ListOfFieldsRepository;
import com.softserve.edu.opencart.data.users.IUser;
import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.db.service.CustomerService;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.user.RegisterPage;
import com.softserve.edu.opencart.tests.TestRunnerFireFox;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.testng.annotations.*;

import java.util.Iterator;
import java.util.List;
@Epic("CheckRegistrationUser")
public class CheckRegistrationUser extends TestRunnerFireFox {
    CustomerService customerService;

    @BeforeClass
    public void beforDB(){
        customerService = new CustomerService();
    }

    @AfterMethod
    public void clenDB(){
        customerService.deleteCustomerByEmail(UserRepository.get().userTestRegistration().getEmail());
    }


    @DataProvider(name = "ValidRegistration")
    public Iterator<Object[]> userData() {
        List<Object[]> data = ListOfFieldsRepository.get().fieldsForRegistration().getData();
        return data.iterator();
    }
    @Description("CheckRegistrationUser; checkRegistrationUser()")
    @Test(dataProvider = "ValidRegistration")
    public void checkRegistrationUser(IUser user){
        logger.info(String.format("check registration:  of User: %s", user.getClass().getName()));
        reporter.info(String.format("check registration:  of User: %s", user.getClass().getName()));

        RegisterPage registerPage = Application.get().loadHomePage().gotoRegistePageFromMyAccount();

        registerPage.registrateUser(user);
        registerPage.gotoRegisterSuccessPage();

        flexAssert.assertEquals(customerService.getEmailFromCustomer(user.getEmail()), user.getEmail());

    }


}
