package server7.testng;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import server7.testng.Pages.DefaultStoreOptionPg;
import server7.testng.Pages.ProductPg;

/**
 * This class is for testing pagination on Admin product page
 */
public class ChromeAdmProductPaginationTest {

    public WebDriverCreator webDriverCreator;
//    public SettingPg settingPg;
//    public ProductPg productPg;
//    public int numberOfItems;

    /**
     * This method prepares system for further testing. It creates WebDriver
     * class, open, set Items on product page for reading Items table and
     * counting number of items and it counts number of items.
     */

    @DataProvider
    public Object[][] getParameters() {
        webDriverCreator = new WebDriverCreator();
        webDriverCreator.setWebdriverChrome();
        new DefaultStoreOptionPg(webDriverCreator).changeItemsPerPage(Integer.parseInt(
                Credentials.ITEMS_PER_PAGE_GREAT.getChosenConstant()));
        ProductPg productPg = new ProductPg(webDriverCreator);
        productPg.openByAddress();
        productPg.cleanFilter();
        int numberOfItems = productPg.readTable().size();
        return new Object[][]{
                {numberOfItems, 1}, {numberOfItems, numberOfItems / 2 + 1},
                {numberOfItems, numberOfItems}, {numberOfItems, numberOfItems + 1}
        };
    }

    /**
     * This test runs with Items per page is equal 1, so the number of pages is equal
     * quantity of items
     */
    @Test(dataProvider = "getParameters")
    public void paginationPerPage(int numberOfItems, int itemsPerPage) {
        new DefaultStoreOptionPg(webDriverCreator).changeItemsPerPage(itemsPerPage);
        ProductPg productPg = new ProductPg(webDriverCreator);
        productPg.openByAddress();
        productPg.cleanFilter();
        int expectedItems = (itemsPerPage > numberOfItems) ? numberOfItems : itemsPerPage;
        int expectedPages = (numberOfItems + itemsPerPage - 1) / itemsPerPage;
        int actualItems = productPg.readTable().size();
        int actualPages = productPg.getNumberOfPages();
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
