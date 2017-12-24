package com.softserve.edu.opencart.tests.address;

import com.softserve.edu.opencart.data.users.IUser;
import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.pages.AlertsText;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.user.LoginPage;
import com.softserve.edu.opencart.pages.user.ResetPasswordPage;
import com.softserve.edu.opencart.tests.TestRunnerFireFox;
import com.softserve.edu.opencart.tools.CheckingMails;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ForgottenPasswordTest extends TestRunnerFireFox {

    @DataProvider(name = "mailAPI")
    public static Object[][] positiveValues() {
        return new Object[][]{{UserRepository.get().userForChangePass(), AlertsText.SUCCESS_PASSWORD.toString()}};

    }

    @Test(dataProvider ="mailAPI" )
    public void checkForgottenPassword(IUser user, String expected){
        LoginPage loginPage = Application.get()
                .loadHomePage()
                .gotoLoginPageFromMyAccount()
                .gotoForgotPasswordPageRightColumn()
                .sendEmailWithUrl(user.getEmail())
                .changePass(user)
                .saveChangesAccount(user);

        String actual = loginPage.getAlertSuccessText();
        Assert.assertEquals(actual, expected);
    }
}
