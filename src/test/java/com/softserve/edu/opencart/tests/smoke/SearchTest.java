package com.softserve.edu.opencart.tests.smoke;

import com.softserve.edu.opencart.pages.user.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SearchTest {

    @Test
    public void checkProduct() throws Exception {
        //
        // Precondition
        //
        System.setProperty("webdriver.chrome.driver",
                "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://server7.pp.ua/index.php?route=product/search");
        Thread.sleep(1000);
        //
        String expected = "All Categories";
        String actual;
        SearchPage searchPage = new SearchPage(driver);
        actual = searchPage.getSelectedCategoryText();

        // Check
        //
        Assert.assertEquals(actual, expected, "Element is not found");
        Thread.sleep(1000);
        //
        expected = "MacBook Pro";
        searchPage.sendKeysToInputSearch("MacBook Pro");
        searchPage.setCategorySearchSelect("Laptops & Notebooks");
        searchPage.selectCategorySearchCheckbox();
        searchPage.clickSearchCriteriaButton();
        SearchPage searchPageTwo = new SearchPage(driver);
        for (String current : searchPageTwo.getProductComponentTexts()){
            actual = current;
            Assert.assertEquals(actual, expected);
        }
        // Return to previous state
        driver.get("http://server7.pp.ua/index.php?route=product/search");
        //Thread.sleep(2000);
        driver.quit();
    }
}
