package com.softserve.edu.opencart.tests.address;

import com.softserve.edu.opencart.data.users.IUser;
import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.db.service.CustomerService;
import com.softserve.edu.opencart.pages.AlertsText;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.TagAttribute;
import com.softserve.edu.opencart.pages.user.LoginPage;
import com.softserve.edu.opencart.pages.user.ResetPasswordPage;
import com.softserve.edu.opencart.tests.TestContextAttributes;
import com.softserve.edu.opencart.tests.TestRunnerFireFox;
import com.softserve.edu.opencart.tools.CheckingMails;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
@Epic("ForgottenPassword")
public class ForgottenPasswordTest extends TestRunnerFireFox {

    private CustomerService customerService;


    @BeforeClass
    public void beforDB(){
       customerService = new CustomerService();
    }

    @DataProvider(name = "mailAPI")
    public static Object[][] positiveValues() {
        return new Object[][]{{UserRepository.get().userForChangePass()}};

    }
    @BeforeMethod
    @Step("get default pass")
    public void savePass(ITestContext context){
        context.setAttribute(TestContextAttributes.CUSTOMER_PASS.toString(),
                customerService.getPassHashByEmail(UserRepository.get().userForChangePass().getEmail()));
    }
    @AfterMethod
    @Step("set to default pass")
    public void setDefaultPass(ITestContext context){
        customerService.updateCustomerPass(UserRepository.get().userForChangePass(),
                context.getAttribute(TestContextAttributes.CUSTOMER_PASS.toString()).toString());
    }
    @Description("Test Description: class ForgottenPassword; checkForgottenPassword()")
    @Test(dataProvider ="mailAPI" )
    @Step("change password")
    public void checkForgottenPassword(IUser user, ITestContext context){
        logger.info(String.format("check Forgotten password: %s",user.getEmail()));
        reporter.info(String.format("check Forgotten password: %s", user.getEmail()));
        LoginPage loginPage = Application.get()
                .loadHomePage()
                .gotoLoginPageFromMyAccount()
                .gotoForgotPasswordPageRightColumn()
                .sendEmailWithUrl(user.getEmail())
                .changePass(user)
                .saveChangesAccount(user);

        String actual = customerService.getPassHashByEmail(user.getEmail());
        System.out.println(actual);
        flexAssert.assertNotEquals(actual,
                context.getAttribute(TestContextAttributes.CUSTOMER_PASS.toString()).toString());
    }
}
