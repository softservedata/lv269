
package com.softserve.edu.opencart.tests.smoke;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.data.categories.CurrencyRepository;
import com.softserve.edu.opencart.data.categories.DetailCategory;
import com.softserve.edu.opencart.data.products.Product;
import com.softserve.edu.opencart.data.products.ProductRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.SubCategoryProductsPage;

public class HomeTest {

    @BeforeClass
    public void beforeClass() {
        Application.get(ApplicationSourceRepository.get().chromeServer7());
        //Application.get(ApplicationSourceRepository.get().firefoxServer7());
    }

    @AfterClass
    public void afterClass() {
        Application.remove();
    }
    
    @DataProvider//(parallel = true)
    public Object[][] productData() {
        // Read from ...
        return new Object[][] { 
            { CurrencyRepository.get().euro(), ProductRepository.get().iPhone() },
            { CurrencyRepository.get().dollar(), ProductRepository.get().iPhone() },
            };
    }

    @Test(dataProvider = "productData")
    public void checkProduct(DetailCategory detailCurency, Product product) throws Exception {
        //
        // Precondition
        //

        //
        // Steps
        //
 
        double actualPrice = Application.get().loadHomePage()
                .chooseCurrencyByDetailCategory(detailCurency)
                .getPriceAmountByProduct(product);
        //
        // Check
        //
 
        // TODO getPrices(detailCurency)
        double expectedPrice = product.getPrices().get(detailCurency.getOptionName());
        Assert.assertEquals(actualPrice, expectedPrice, 0.001);
        Thread.sleep(1000);
        //
        // Return to previous state
        //

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
