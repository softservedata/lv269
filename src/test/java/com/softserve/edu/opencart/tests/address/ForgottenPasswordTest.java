package com.softserve.edu.opencart.tests.address;

import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.user.LoginPage;
import com.softserve.edu.opencart.pages.user.ResetPasswordPage;
import com.softserve.edu.opencart.tests.TestRunnerFireFox;
import com.softserve.edu.opencart.tools.CheckingMails;
import org.testng.annotations.Test;

public class ForgottenPasswordTest extends TestRunnerFireFox {

    @Test
    public void checkForgottenPassword(){
        LoginPage loginPage = Application.get().loadHomePage().gotoLoginPageFromMyAccount()
                .gotoForgotPasswordPageRightColumn().sendEmailWithUrl("zvartestopen@gmail.com");
        Application.get().browser()
                .openUrl(CheckingMails.getMessageUrlFromMail("pop.gmail.com","pop3","zvartestopen@gmail.com","vitochka24"));

        loginPage = new ResetPasswordPage().saveChangesAccount("vitochka24");
    }
}
