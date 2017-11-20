package com.softserve.edu.opencart.tests.login;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.data.users.IUser;
import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.user.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;




public class TestLoginPage {

    @BeforeClass
    public void beforeClass()   {
//        Application.get(ApplicationSourceRepository.get().chromeServer7());
        Application.get(ApplicationSourceRepository.get().firefoxServer7());
    }

    @AfterClass
    public void afterClass() {
        Application.remove();
    }

    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][]{{UserRepository.get().userTestLogin()}};

    }

    @Test(dataProvider = "Authentication")
    public void checkImpossibilityOfCopyingPassword(IUser user) throws Exception {
        LoginPage loginPage = Application.get().login();
        loginPage.inputPassword(user.getPassword());
        Assert.assertNotEquals(loginPage.getPasswordFieldText(), user.getPassword());
    }
    @Test(dataProvider = "Authentication")
    public void checkLoginField(IUser user) throws Exception {
        LoginPage loginPage = Application.get().login();
        loginPage.inputEMailAdress(user.getEmail());
        Assert.assertNotEquals(loginPage.getEmailAddressFieldText(), user.getEmail());
    }


}
