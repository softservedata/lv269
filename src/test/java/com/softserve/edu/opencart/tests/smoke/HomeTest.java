package com.softserve.edu.opencart.tests.smoke;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.DetailCategory;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.SubCategoryProductsPage;

public class HomeTest {

    @DataProvider//(parallel = true)
    public Object[][] productData() {
        Map<String, Double> macBookPrices = new HashedMap<>();
        macBookPrices.put("Euro", 430.06);
        macBookPrices.put("Pound Sterling", 379.02);
        macBookPrices.put("US Dollar", 500.0);
        // Read from ...
        return new Object[][] {
            //{ "MacBook", 500.0 },
            //{ "iPhone", 101.0 },
            //{ "Canon EOS 5D", 80.00 },
            { new DetailCategory("Currency", "US Dollar"),
                new Product("MacBook", "", macBookPrices )},
            };
    }

    @Test(dataProvider = "productData")
    //public void checkProduct(String productName, double expectedPrice) throws Exception {
    public void checkProduct(DetailCategory detailCurency, Product product) throws Exception {
        //
        // Precondition
        //
        System.setProperty("webdriver.chrome.driver",
                "C:/Program Files/Java/Selenium360/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //
        driver.get("http://server7.pp.ua");
        Thread.sleep(1000);
        //
        //HomePage homePage = new HomePage(driver);
        //Thread.sleep(1000);
        //
        // Steps
        //
        //homePage = homePage.chooseCurrencyByDetailCategory(detailCurency);
        //Thread.sleep(1000);
        //double actualPrice = homePage.getPriceAmountByProductName(productName);
        //double actualPrice = homePage.getPriceAmountByProduct(product);
        //Thread.sleep(1000);
        double actualPrice = new HomePage(driver)
                .chooseCurrencyByDetailCategory(detailCurency)
                .getPriceAmountByProduct(product);
        //
        // Check
        //
        //Assert.assertEquals(actualPrice, expectedPrice, 0.001);
        // TODO getPrices(detailCurency)
        double expectedPrice = product.getPrices().get(detailCurency.getOptionName());
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
                "C:/Program Files/Java/Selenium360/chromedriver.exe");
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

    //@Test
    public void checkSubMenu() throws Exception {
        //
        // Precondition
        //
        System.setProperty("webdriver.chrome.driver",
                "C:/Program Files/Java/Selenium360/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //
        driver.get("http://server7.pp.ua");
        Thread.sleep(1000);
        //
        // Steps
        //
        SubCategoryProductsPage subCategoryProductsPage = new HomePage(driver)
                    .gotoMenuTopByPartialName("Desktops", "Mac");
        Thread.sleep(1000);
        //
        // Check
        //
        Assert.assertEquals(subCategoryProductsPage.getPriceAmountByProductName("iMac"),
                122.0, 0.001);
        Thread.sleep(1000);
        //
        // Return to previous state
        //
        //Thread.sleep(2000);
        driver.quit();
    }

}
