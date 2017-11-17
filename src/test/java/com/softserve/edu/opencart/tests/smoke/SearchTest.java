package com.softserve.edu.opencart.tests.smoke;

import com.softserve.edu.opencart.pages.user.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchTest {
    WebDriver driver = new ChromeDriver();
    @DataProvider (name = "DataProvider-for-Smoke")
    public Object[ ][ ] parameterIntTestProvider() {

        return new Object[][]{
                {"MacBook", "Laptops & Notebooks"},
                {"MacBook Pro", "Laptops & Notebooks"},
                {"MacBook Air", "Laptops & Notebooks"}
        };
    }
    //@Test (dataProvider = "DataProvider-for-Smoke")
    public void checkProduct(String productName, String category) throws Exception {
        //
        // Precondition
        //
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/lib/chromedriver");
        //WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://server7.pp.ua/index.php?route=product/search");
        Thread.sleep(1000);
        //
        String expected = "All Categories";
        String actual;
        SearchPage searchPage = new SearchPage(driver);
        actual = searchPage.getSelectedText(searchPage.getSelectCategorySearch());

        // Check
        //
        Assert.assertEquals(actual, expected, "Element is not found");
        Thread.sleep(1000);
        //
        SearchPage searchPageTwo = searchPage.findElementUsingCategorySelectCheckSubcategory(productName, category);
        List<String> productList = searchPageTwo.getProductComponentTexts();
        Assert.assertTrue(searchPageTwo.isFound(productList, productName));
        // Return to previous state
        driver.get("http://server7.pp.ua/index.php?route=product/search");
        //Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void check(){
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/lib/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://server7.pp.ua/index.php?route=product/search&search=mac");
        SearchPage sp = new SearchPage(driver);
        System.out.print("TestRes: " + sp.getNoElementsMeetingCriteriaText() + "TheEnd");
    }
}
