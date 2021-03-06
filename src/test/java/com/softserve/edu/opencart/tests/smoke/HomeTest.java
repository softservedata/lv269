package com.softserve.edu.opencart.tests.smoke;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.categories.CurrencyRepository;
import com.softserve.edu.opencart.data.categories.DetailCategory;
import com.softserve.edu.opencart.data.products.Product;
import com.softserve.edu.opencart.data.products.ProductRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.SubCategoryProductsPage;
import com.softserve.edu.opencart.tests.TestRunner;

public class HomeTest extends TestRunner {
    //public static final Logger logger = LoggerFactory.getLogger(HomeTest.class);
    
    @DataProvider//(parallel = true)
    public Object[][] productData() {
        // Read from ...
        return new Object[][] { 
            //{ "MacBook", 500.0 },
            //{ "iPhone", 101.0 },
            //{ "Canon EOS 5D", 80.00 },
            { CurrencyRepository.get().euro(), ProductRepository.get().macBook() },
            //{ CurrencyRepository.get().dollar(), ProductRepository.get().macBook() },
            };
    }

    @Test(dataProvider = "productData")
    //public void checkProduct(String productName, double expectedPrice) throws Exception {
    public void checkProduct(DetailCategory detailCurency, Product product) throws Exception {
        logger.info(String.format("Started checkProduct(DetailCategory %s, Product %s)", detailCurency.getCategoryName(), product.getName()));
        reporter.display(String.format("Started checkProduct(DetailCategory %s, Product %s)", detailCurency.getOptionName(), product.getName()));
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
        //
        //double actualPrice = new HomePage(driver)
        double actualPrice = Application.get().loadHomePage()
                .chooseCurrencyByDetailCategory(detailCurency)
                .getPriceAmountByProduct(product);
        //
        // Check
        //
        //Assert.assertEquals(actualPrice, expectedPrice, 0.001);
        // TODO getPrices(detailCurency)
        logger.debug("checkProduct() debug");
        double expectedPrice = product.getPrices().get(detailCurency.getOptionName()).getValue();
        Assert.assertEquals(actualPrice, expectedPrice, 0.001);
        Thread.sleep(1000);
        //
        // Return to previous state
        //
        //Thread.sleep(2000);
        //driver.quit();
        logger.info("checkProduct() done");
        reporter.display("checkProduct() done");
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
        //HomePage homePage = new HomePage(driver);
        Application.get();
        HomePage homePage = new HomePage(); // ERROR
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
        //SubCategoryProductsPage subCategoryProductsPage = new HomePage(driver)
        Application.get();
        SubCategoryProductsPage subCategoryProductsPage = new HomePage()
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
