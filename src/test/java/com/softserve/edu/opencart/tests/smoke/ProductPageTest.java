package com.softserve.edu.opencart.tests.smoke;

import com.softserve.edu.opencart.pages.user.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Serhiienko.
 */
public class ProductPageTest {


    @DataProvider//(parallel = true)
    public Object[][] productData() {
        // Read from ...
        return new Object[][]{
                {"MacBook", 602.0},
                {"iPhone", 123.2},
                {"Canon EOS 5D", 98.00},
        };
    }

    //@Test(dataProvider = "productData")

    @Test
    public void checkProductPage() throws InterruptedException {
        //
        // Precondition
        //

        /*System.setProperty("webdriver.gecko.driver","C:/Program Files/Java/Selenium360/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();*/

        System.setProperty("webdriver.chrome.driver",
                "C:/Program Files/Java/Selenium360/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //
        driver.get("http://server7.pp.ua/index.php?route=product/product&product_id=40");
        Thread.sleep(1000);
        //
        ProductPage productPage = new ProductPage(driver);
        Thread.sleep(1000);
        //
        // Steps
        //
        productPage.clickReview();
        productPage.inValidReviewFields("name", "fhdk");
        Thread.sleep(1000);
        //productPage.inValidOnlyReviewRating("name", "fdsdsbdnbdshfdsbcdxbchjdbsfhbdscdbscblsdbdsjcdsb hb dbsvdslbfs");
        //Thread.sleep(1000);
        productPage.validOnlyReviewRating();
        Thread.sleep(1000);
        productPage.validReviewFields("name", "fdsdsbdnbdshfdsbcdxbchjdbsfhbdscdbscblsdbdsjcdsb hb dbsvdslbfs");

        productPage.clickDescription();

        driver.get("http://server7.pp.ua/index.php?route=product/product&product_id=43");
        Thread.sleep(1000);
        productPage=new ProductPage(driver);
        productPage.clickReview();
        productPage.clickSpecification();
        productPage.clickDescription();


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
