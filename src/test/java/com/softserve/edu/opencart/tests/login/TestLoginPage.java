package com.softserve.edu.opencart.tests.login;

import com.softserve.edu.opencart.data.users.IUser;
import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.user.LoginPage;
import com.softserve.edu.opencart.tests.TestRunner;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestLoginPage extends TestRunner {


    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][]{{UserRepository.get().userTestLogin()}};

    }

    @Test(dataProvider = "Authentication")
    public void checkImpossibilityOfCopyingPassword(IUser user)  {
        logger.info(String.format("start check Impossibility Of Copying Password: %s of User: %s", user.getPassword(), user.getEmail()));
        reporter.info(String.format("start check Impossibility Of Copying Password: %s of User: %s", user.getPassword(), user.getEmail()));

        LoginPage loginPage = Application.get().login();
        loginPage.inputPassword(user.getPassword());
        Assert.assertNotEquals(loginPage.getPasswordFieldText(), user.getPassword());
        logger.info(String.format("finish check Impossibility Of Copying Password: %s of User: %s", user.getPassword(), user.getEmail()));
        reporter.info(String.format("finish check Impossibility Of Copying Password: %s of User: %s", user.getPassword(), user.getEmail()));

    }

    @Test(dataProvider = "Authentication")
    public void checkLoginField(IUser user){
        logger.info(String.format("start check Login field with login: %s",  user.getEmail()));
        reporter.info(String.format("start check Login field with login: %s",  user.getEmail()));

        LoginPage loginPage = Application.get().login();
        loginPage.inputEMailAdress(user.getEmail());
        Assert.assertNotEquals(loginPage.getEmailAddressFieldText(), user.getEmail());

        logger.info(String.format("finish check Login field with login: %s",  user.getEmail()));
        reporter.info(String.format("finish check Login field with login: %s",  user.getEmail()));

    }


}
