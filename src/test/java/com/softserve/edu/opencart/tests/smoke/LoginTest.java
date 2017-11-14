package com.softserve.edu.opencart.tests.smoke;

import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {


    @Test
    public void checkLogin() throws Exception {

        System.setProperty("webdriver.gecko.driver",
                "D:/Eclipse/geckodriver-v0.19.0-win64/geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.get("http://server7.pp.ua");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        LoginPage loginPage = new HomePage(driver).gotoLoginPageFromMyAccountByPartialName()
                .inputCredentialsUserPage("lv_269_test@ukr.net","269lv269lv");



        loginPage.gotoLoginUserPage().clickMyAccountByPartialName("logout");
//        Assert.assertEquals( , );



        Thread.sleep(1000);

        driver.quit();
    }
}
