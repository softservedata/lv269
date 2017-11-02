package server7.testng;


import org.openqa.selenium.WebElement;
import server7.testng.Pages.ProductPg;

import java.util.List;

/**
 * This class is for filter process.
 */
public class FilterProducts {


    private ProductPg productPg;
    private WebDriverCreator webDriverCreator;
    private String numberOfPages;
    private ProductList actualList;

    FilterProducts(WebDriverCreator webDriverCreator, ProductPg productPg) {
        this.webDriverCreator = webDriverCreator;
        this.productPg = productPg;
    }

    /**
     * This method ask ProductPage methods for counting number of pages
     * on admin product list.
     */
    public void countNumberOfPage() {
        numberOfPages = "1";
        productPg.PaginationClickLastPgBtn();
        numberOfPages = productPg.getNumberOfLastPage();
    }

    public String getNumberOfPages() {
        return numberOfPages;
    }

    /**
     * It creates actual product list, reading from the table on
     * current product page
     * @param productElements - list of rows from the table.
     */
    public void createActualProductList(List<WebElement> productElements) {
        actualList = new ProductList(webDriverCreator, productElements);
    }

    public ProductList getActualList() {
        return actualList;
    }


}
