package server7.testng;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import server7.testng.Pages.ProductPg;
import server7.testng.Pages.SettingPg;

/**
 * This class is for testing pagination on Admin product page
 */
public class ChromeAdmProductPaginationTest {

    public WebDriverCreator webDriverCreator;
    public SettingPg settingPg;
    public ProductPg productPg;
    public int numberOfItems;

    /**
     * This method prepares system for further testing. It creates WebDriver
     * class, open, set Items on product page for reading Items table and
     * counting number of items and it counts number of items.
     */
    @BeforeClass
    public void setParameters() {
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

    @DataProvider
    public Object[][] ItemsPerPage() {
        return new Object[][]{
                { 1 },  {numberOfItems/2+1},
                {numberOfItems}, {numberOfItems+1}
        };
    }

    /**
     * This test runs with Items per page is equal 1, so the number of pages is equal
     * quantity of items
     */
    @Test(dataProvider = "ItemsPerPage")
    public void paginationPerPage(int itemsPerPage ) {
        settingPg.changeItemsPerPage(itemsPerPage);
        productPg.openByAddress();
        productPg.cleanFilter();
        int expectedItems = (itemsPerPage > numberOfItems)? numberOfItems : itemsPerPage;
        int expectedPages = (numberOfItems + itemsPerPage - 1) / itemsPerPage;
        int actualItems = productPg.readTable().size();
        int actualPages = productPg.getNumberOfPages();
        Assert.assertEquals( actualItems, expectedItems,
                Messages.FAIL_PAGINATION_NUMBER_OF_ITEMS_PER_PAGE
                        .getMessage());
        Assert.assertEquals( actualPages, expectedPages,
                Messages.FAIL_PAGINATION_NUMBER_OF_PAGES.getMessage());


    }

    @AfterClass
    public void returnParameters() {
        settingPg.changeItemsPerPage(Integer.parseInt(Credentials.ITEMS_PER_PAGE_DFLT
                .getChosenConstant()));
        webDriverCreator.quitDriver();
    }


}
