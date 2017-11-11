package com.softserve.edu.opencart.testng;


import org.openqa.selenium.WebElement;
import com.softserve.edu.opencart.testng.pages.admin.ProductPg;

import java.util.List;

/**
 * This class is for filter process.
 */
public class FilterProducts {


    private ProductPg productPg;
    private WebDriverManager webDriverManager;
    private String numberOfPages;
    private ProductList actualList;

    FilterProducts(WebDriverManager webDriverManager, ProductPg productPg) {
        this.webDriverManager = webDriverManager;
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
        actualList = new ProductList(webDriverManager, productElements);
    }

    public ProductList getActualList() {
        return actualList;
    }


}
