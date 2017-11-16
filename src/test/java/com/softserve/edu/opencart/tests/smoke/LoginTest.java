package com.softserve.edu.opencart.tests.smoke;

import com.softserve.edu.opencart.pages.user.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {


    WebDriver driver;

    @BeforeTest
    public void runWebDriver() {
        System.setProperty("webdriver.gecko.driver",
                "D:/Eclipse/geckodriver-v0.19.0-win64/geckodriver.exe");

        driver = new FirefoxDriver();
        driver.get("http://server7.pp.ua");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterTest
    public void closeWebDriver() {
        driver.quit();
    }

    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {

        return new Object[][]{{"lv_269_test@ukr.net", "269lv269lv"}
                , {"test_wrong_login@email.com", "269lv269lv"}
                , {"mfj14401@sqoai.com", "qwerty123456"}};

    }


    @Test(dataProvider = "Authentication")
    public void checkSuccessfulLogin(String sUsername, String sPassword) throws Exception {

        new HomePage(driver).gotoLoginPageFromMyAccount()
                .loginForLoginPageToMyAccountPage(sUsername, sPassword)
                .gotoLogoutPage()
                .gotoHomePage();

    }
}
