package test.edu.softserve.server7Test;


import org.junit.*;

/**
 * This class is for testing pagination on Admin product page
 */
public class ChromeAdmProductPaginationTest {

    public static WebDriverCreator webDriverCreator;
    public static SettingPg settingPg;
    public static ProductPg productPg;
    public static int numberOfItems;

    /**
     * This method prepares system for further testing. It creates WebDriver
     * class, open, set Items on product page for reading Items table and
     * counting number of items and it counts number of items.
     */
    @BeforeClass
    public static void setParameters() {
        webDriverCreator = new WebDriverCreator();
        webDriverCreator.setWebdriverChrome();
        settingPg = new SettingPg(webDriverCreator);
        settingPg.changeItemsPerPage(Integer.parseInt(
                Credentials.ITEMS_PER_PAGE_GREAT.getChosenConstant()));
        productPg = new ProductPg(webDriverCreator);
        productPg.openByAddress();
        productPg.cleanFilter();
        numberOfItems = productPg.readTable().size();
    }

    /**
     * This test runs with Items per page is equal 1, so the number of pages is equal
     * quantity of items
     */
    @Test
    public void paginationPerPageOne() {
        int numberItemsPerPage = 1;
        settingPg.changeItemsPerPage(numberItemsPerPage);
        productPg.openByAddress();
        productPg.cleanFilter();
        int actual = productPg.getNumberOfPages();
        int expected = (numberOfItems + numberItemsPerPage - 1) / numberItemsPerPage;
        Assert.assertEquals(Messages.FAIL_PAGINATION_NUMBER_OF_PAGES.getMessage(),
                expected, actual);
    }

    /**
     * This test runs with Items per page is Items/2+1, so the number of pages is 2
     */
    @Test
    public void paginationPerPageHalfItemsPlusOne() {
        int numberItemsPerPage = numberOfItems / 2 + 1;
        settingPg.changeItemsPerPage(numberItemsPerPage);
        productPg.openByAddress();
        productPg.cleanFilter();
        int actual = productPg.getNumberOfPages();
        int expected = (numberOfItems + numberItemsPerPage - 1) / numberItemsPerPage;
        Assert.assertEquals(Messages.FAIL_PAGINATION_NUMBER_OF_PAGES.getMessage(),
                expected, actual);
    }

    /**
     * This test runs with Items per page is equal the number of items, so the
     * number of pages is 1 and there are number of items elements (not more).
     */
    @Test
    public void paginationPerPageEqualItems() {
        int numberOfItemsPerPage = numberOfItems;
        settingPg.changeItemsPerPage(numberOfItemsPerPage);
        productPg.openByAddress();
        productPg.cleanFilter();
        Assert.assertFalse(Messages.FAIL_PAGINATION_NUMBER_OF_PAGES.getMessage(),
                productPg.isPaginationPresent());
        int actualNumberOfItems = productPg.readTable().size();
        Assert.assertEquals(numberOfItemsPerPage, actualNumberOfItems);
    }

    /**
     * This test runs with Items per page is more than number of items, so the
     * number of pages is 1 and there are number of items elements (not more).
     */
    @Test
    public void paginationPerPageMoreThanItems() {
        int numberOfItemsPerPage = numberOfItems + 1;
        settingPg.changeItemsPerPage(numberOfItemsPerPage);
        productPg.openByAddress();
        productPg.cleanFilter();
        Assert.assertFalse(Messages.FAIL_PAGINATION_NUMBER_OF_PAGES.getMessage(),
                productPg.isPaginationPresent());
        int actualNumberOfItems = productPg.readTable().size();
        Assert.assertEquals(Messages.FAIL_PAGINATION_NUMBER_OF_ITEMS_PER_PAGE
                .getMessage(), numberOfItems, actualNumberOfItems);
    }

    /**
     * It set default value for Items on Page
     */
    @AfterClass
    public static void returnParameters() {
        settingPg.changeItemsPerPage(Integer.parseInt(Credentials.ITEMS_PER_PAGE_DFLT
                .getChosenConstant()));
        webDriverCreator.quitDriver();
    }


}
