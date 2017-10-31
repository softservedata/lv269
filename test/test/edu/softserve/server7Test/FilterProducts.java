package test.edu.softserve.server7Test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FilterProducts {
    private ProductPg productPg;
    private WebDriverCreator webDriverCreator;
    private String numberOfPages;
    private ProductList actualList;

    FilterProducts(WebDriverCreator webDriverCreator, ProductPg productPg) {
        this.webDriverCreator = webDriverCreator;
        this.productPg = productPg;
    }

    public void countNumberOfPage() {
        numberOfPages = "1";
        productPg.PaginationClickLastPgBtn();
        numberOfPages = productPg.getNumberOfPages();
    }

    public String getNumberOfPages() {
        return numberOfPages;
    }

    public void createActualProductList(List<WebElement> productElements) {
        actualList = new ProductList(webDriverCreator, productElements);
    }

    public ProductList getActualList() {
        return actualList;
    }


}
