package server7.testng;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import server7.testng.Pages.DefaultStoreOptionPg;
import server7.testng.Pages.ProductPg;
import server7.testng.Pages.SettingPg;

/**
 * This class is for testing pagination on Admin product page
 */
public class ChromeAdmProductPaginationTest {

    public WebDriverCreator webDriverCreator;
    public int numberOfItems;

    /**
     * This method prepares system for further testing. It creates WebDriver
     * class, open, set Items on product page for reading Items table and
     * counting number of items and it counts number of items.
     */
    @BeforeClass
    public void preparation() {
        webDriverCreator = new WebDriverCreator();
        webDriverCreator.setWebdriverChrome();
        new DefaultStoreOptionPg(webDriverCreator).changeItemsPerPage(Integer.parseInt(
                Credentials.ITEMS_PER_PAGE_GREAT.getChosenConstant()));
        new ProductPg(webDriverCreator).openByAddress();
        new ProductPg(webDriverCreator).cleanFilter();
        numberOfItems = new ProductPg(webDriverCreator).readTable().size();
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
        new DefaultStoreOptionPg(webDriverCreator).changeItemsPerPage(itemsPerPage);
        new ProductPg(webDriverCreator).openByAddress();
        new ProductPg(webDriverCreator).cleanFilter();
        int expectedItems = (itemsPerPage > numberOfItems) ? numberOfItems : itemsPerPage;
        int expectedPages = (numberOfItems + itemsPerPage - 1) / itemsPerPage;
        int actualItems = new ProductPg(webDriverCreator).readTable().size();
        int actualPages = new ProductPg(webDriverCreator).getNumberOfPages();
        Assert.assertEquals(actualItems, expectedItems,
                Messages.FAIL_PAGINATION_NUMBER_OF_ITEMS_PER_PAGE
                        .getMessage());
        Assert.assertEquals(actualPages, expectedPages,
                Messages.FAIL_PAGINATION_NUMBER_OF_PAGES.getMessage());


    }

    @AfterClass
    public void returnParameters() {
        new DefaultStoreOptionPg(webDriverCreator).changeItemsPerPage(
                Integer.parseInt(Credentials.ITEMS_PER_PAGE_DFLT
                        .getChosenConstant()));
        webDriverCreator.quitDriver();
    }


}
