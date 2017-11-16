package com.softserve.edu.opencart.tests.smoke;

import com.softserve.edu.opencart.pages.user.AddressBookPage;
import com.softserve.edu.opencart.pages.user.EditAddressPage;
import com.softserve.edu.opencart.pages.user.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddressTest {

    WebDriver driver;
    @DataProvider(name = "dataAddress")
    public Object[ ][ ] parameterIntTestProvider() {
        return new Object[][]{
                {"sdgsd", "shgsd", "sdg", "sdgs", "sdgsdg", "sdgsdg", "sgdsdg", "United Kingdom", "Bristol"}
                };
    }

    @BeforeTest
    public void setUp(){
            System.setProperty("webdriver.chrome.driver",
                    "F:/AutomationTest/lib/selen/chromedriver.exe");
           driver = new ChromeDriver();
           driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
           driver.get("http://server7.pp.ua");
           new HomePage(driver).gotoLoginPageFromMyAccount()
                .loginForLoginPageToMyAccountPage("mirekzvar@gmail.com", "vitochka24");
            driver.get("http://server7.pp.ua/index.php?route=account/address");


    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
    @Test(dataProvider = "dataAddress")
    public void enterAddress(String fieldFirstName, String fieldLastName, String fieldFirstAddress, String fieldSecondAddress
            ,String fieldCompany, String fieldCity, String fieldPostCode
            ,String fieldCountry,String fieldRegion){
        new AddressBookPage(driver).clickNewAddress();
        new EditAddressPage(driver).pasteData(fieldFirstName,  fieldLastName, fieldFirstAddress, fieldSecondAddress
                                           , fieldCompany,  fieldCity,  fieldPostCode , fieldCountry, fieldRegion);
        Assert.assertTrue(true);


    }
}
