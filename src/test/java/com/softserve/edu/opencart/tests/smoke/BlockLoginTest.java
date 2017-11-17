package com.softserve.edu.opencart.tests.smoke;

import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class BlockLoginTest {
    WebDriver driver;
    private static Connection connection = null;


    public void connectToDB() throws SQLException {
        String jdbcUrl = "jdbc:mysql://77.120.103.50:3310/pekelis_db";
        String user = "pekelis_usr";
        String password = "B6y0N7i5";
        connection = DriverManager.getConnection(jdbcUrl, user, password);
    }

    public void unblockInDatabase(String emailToUnlock) {
        try {
            connectToDB();

            String query1 = " UPDATE oc_customer_login SET total = '0' WHERE email  = ?;";
            PreparedStatement pst1 = connection.prepareStatement(query1);
            pst1.setString(1, emailToUnlock);
            pst1.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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

        return new Object[][]{
        {UserRepository.get().userTestWrongPassword().getEmail(), UserRepository.get().userTestWrongPassword().getPassword()}};

    }


    @Test(dataProvider = "Authentication")
    public void checkSuccessfulLogin(String sUsername, String sPassword) throws Exception {
        unblockInDatabase(sUsername);
        String actual;
        String expectedFirstWarning = "Warning: No match for E-Mail Address and/or Password.";
        String expectedSecondWarning = "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.";
///     "Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.
//      "Warning: No match for E-Mail Address and/or Password."
        LoginPage loginPage = new HomePage(driver).gotoLoginPageFromMyAccount();
        for (int i = 0; i < 5; i++) {
            loginPage = loginPage
                    .loginForLoginPageToWarning(sUsername, sPassword);
            actual = loginPage.getWarningDangerText();

            Assert.assertEquals(actual, expectedFirstWarning);
        }
        loginPage = loginPage
                .loginForLoginPageToWarning(sUsername, sPassword);
        actual = loginPage.getWarningDangerText();
        Assert.assertEquals(actual, expectedSecondWarning);

//TODO change to correct password
        loginPage = loginPage
                .loginForLoginPageToWarning(sUsername, sPassword);
        actual = loginPage.getWarningDangerText();
        Assert.assertEquals(actual, expectedSecondWarning);

        unblockInDatabase(sUsername);
    }
}
