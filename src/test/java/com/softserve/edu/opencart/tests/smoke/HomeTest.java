package com.softserve.edu.opencart.tests.smoke;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.pages.user.CartPage;
import com.softserve.edu.opencart.pages.user.HomePage;

public class HomeTest {

    @DataProvider//(parallel = true)
    public Object[][] productData() {
        // Read from ...
        return new Object[][] { 
            { "MacBook", 602.0 },
            { "iPhone", 123.2 },
            { "Canon EOS 5D", 98.00 },
            };
    }

    @Test(dataProvider = "productData")
    public void checkProduct(String productName, double expectedPrice) throws Exception {
        //
        // Precondition
        //
        System.setProperty("webdriver.chrome.driver",
                "D:/eclipse/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
    	//System.setProperty("webdriver.gecko.driver", "D:/eclipse/geckodriver.exe");
    	//WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //
        driver.get("http://server7.pp.ua");
        Thread.sleep(1000);
        //
        HomePage homePage = new HomePage(driver);
        Thread.sleep(1000);
        //
        // Steps
        //
        double actualPrice = homePage.getPriceAmountByProductName(productName);
        //
        // Check
        //
        Assert.assertEquals(actualPrice, expectedPrice, 0.001);
        Thread.sleep(1000);
        //
        // Return to previous state
        //
        //Thread.sleep(2000);
        driver.quit();
    }
    
    //@Test
    public void checkTopMenu() throws Exception {
        //
        // Precondition
        //
        System.setProperty("webdriver.chrome.driver",
                "D:/eclipse/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //
        driver.get("http://server7.pp.ua");
        Thread.sleep(1000);
        //
        HomePage homePage = new HomePage(driver);
        Thread.sleep(1000);
        //
        // Steps
        //
        homePage.clickMenuTopByCategoryPartialName("Desktops");
        Thread.sleep(1000);
        homePage.clickMenuTopByCategoryPartialName("Laptops");
        Thread.sleep(1000);
        homePage.clickMenuTopByPartialName("Desktops", "Mac");
        Thread.sleep(1000);
        //
        // Check
        //
        Thread.sleep(1000);
        //
        // Return to previous state
        //
        //Thread.sleep(2000);
        driver.quit();
    }
    

}
