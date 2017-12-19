package com.softserve.edu.opencart.tests.smoke;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.users.IUser;
import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.user.RegAccBlg;
import com.softserve.edu.opencart.pages.user.StartBlg;
import com.softserve.edu.opencart.tests.TestRunner;

public class StartTest extends TestRunner {
    
    @DataProvider//(parallel = true)
    public Object[][] searchData() {
        return new Object[][] { 
            { "MacBook"},
            { "iPhone"},
            //{ "Canon EOS 5D"},
            };
    }

    //@Test(dataProvider = "searchData")
    public void checkSearchProduct(String text) throws Exception {
        //
        // Precondition
        //
        //System.setProperty("webdriver.chrome.driver",
        //        "C:/Program Files/Java/Selenium360/chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //
        //driver.get("http://server7.pp.ua");
        //Thread.sleep(1000);
        //
        Application.get().loadHomePage();
        StartBlg startBlg = new StartBlg();
        Thread.sleep(1000);
        //
        // Steps
        //
        startBlg = startBlg.searchBytext(text);
        Thread.sleep(1000);
        //
        // Check
        //
        //Assert.assertEquals(actualPrice, expectedPrice, 0.001);
        // TODO getPrices(detailCurency)
        Assert.assertEquals(startBlg.getStartOpr().getSearchProductFieldText(), text);
        Thread.sleep(1000);
        //
        // Return to previous state
        //
        //Thread.sleep(2000);
        //driver.quit();
    }

    @DataProvider//(parallel = true)
    public Object[][] registerUser() {
        return new Object[][] { 
            { UserRepository.get().newUser() },
            };
    }

    @Test(dataProvider = "registerUser")
    public void checkRegisterUser(IUser newUser) throws Exception {
        //
        // Precondition
        //
        //System.setProperty("webdriver.chrome.driver",
        //        "C:/Program Files/Java/Selenium360/chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //
        //driver.get("http://server7.pp.ua");
        //Thread.sleep(1000);
        //
        Application.get().loadHomePage();
        StartBlg startBlg = new StartBlg();
        Thread.sleep(1000);
        //
        // Steps
        //
        RegAccBlg regAccBlg = startBlg.gotoRegAccBlg();
        Thread.sleep(1000);
        startBlg = regAccBlg.registerUser(newUser);
        Thread.sleep(1000);
        //
        // Check
        //
        //Assert.assertEquals(actualPrice, expectedPrice, 0.001);
        // TODO getPrices(detailCurency)
        //Assert.assertEquals(startBlg.getStartOpr().getSearchProductFieldText(), text);
        Thread.sleep(1000);
        //
        // Return to previous state
        //
        //Thread.sleep(2000);
        //driver.quit();
    }

}
