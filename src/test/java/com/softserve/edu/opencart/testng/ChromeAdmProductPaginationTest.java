package com.softserve.edu.opencart.testng;


import com.softserve.edu.opencart.testng.constants.Credentials;
import com.softserve.edu.opencart.testng.constants.Messages;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.softserve.edu.opencart.testng.pages.admin.DefaultStoreOptionPg;
import com.softserve.edu.opencart.testng.pages.admin.ProductPg;

/**
 * This class is for testing pagination on Admin product page
 */
public class ChromeAdmProductPaginationTest {

    public WebDriverManager webDriverManager;
    public int numberOfItems;

    /**
     * This method prepares system for further testing. It creates WebDriver
     * class, open, set Items on product page for reading Items table and
     * counting number of items and it counts number of items.
     */
    @BeforeClass
    public void preparation() {
        webDriverManager = new WebDriverManager();
        webDriverManager.setWebdriverChrome();
        new DefaultStoreOptionPg(webDriverManager).changeItemsPerPage(Integer.parseInt(
                Credentials.ITEMS_PER_PAGE_GREAT.get()));
        new ProductPg(webDriverManager).openByAddress();
        new ProductPg(webDriverManager).cleanFilter();
        numberOfItems = new ProductPg(webDriverManager).readTable().size();
    }

    @DataProvider
    public Object[][] getParameters() {
        return new Object[][]{
                {1}, {numberOfItems / 2 + 1},
                {numberOfItems}, {numberOfItems + 1}
        };
    }

    /**
     * This test runs with Items per page is equal 1, so the number of pages is equal
     * quantity of items
     */
    @Test(dataProvider = "getParameters")
    public void paginationPerPage(int itemsPerPage) {
        new DefaultStoreOptionPg(webDriverManager).changeItemsPerPage(itemsPerPage);
        new ProductPg(webDriverManager).openByAddress();
        new ProductPg(webDriverManager).cleanFilter();
        int expectedItems = (itemsPerPage > numberOfItems) ? numberOfItems : itemsPerPage;
        int expectedPages = (numberOfItems + itemsPerPage - 1) / itemsPerPage;
        int actualItems = new ProductPg(webDriverManager).readTable().size();
        int actualPages = new ProductPg(webDriverManager).getNumberOfPages();
        Assert.assertEquals(actualItems, expectedItems,
                Messages.FAIL_PAGINATION_NUMBER_OF_ITEMS_PER_PAGE
                        .getMessage());
        Assert.assertEquals(actualPages, expectedPages,
                Messages.FAIL_PAGINATION_NUMBER_OF_PAGES.getMessage());


    }

    @AfterClass
    public void returnParameters() {
        new DefaultStoreOptionPg(webDriverManager).changeItemsPerPage(
                Integer.parseInt(Credentials.ITEMS_PER_PAGE_DFLT
                        .get()));
        webDriverManager.quitDriver();
    }


}
