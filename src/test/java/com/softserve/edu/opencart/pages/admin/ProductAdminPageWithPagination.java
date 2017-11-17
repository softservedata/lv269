//package com.softserve.edu.opencart.pages.admin;
//
//import com.softserve.edu.opencart.tools.WebDriverManager;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.Select;
//
//import java.util.List;
//
//public class ProductAdminPageWithPagination extends ProductAdminPage {
//
//    private PaginationTable paginationTable;
//
//    public ProductAdminPageWithPagination(WebDriverManager webDriverManager) {
//        super(webDriverManager);
//        setPaginationTable();
//    }
//
//    // PageObject
//
//    // get data
//
//    // set data
//
//    private void setPaginationTable() {
//
//    }
//
//    //------------------------------------------------------------
//
//    private class PaginationTable {
//
//
//
//
//        // Fields
//        private List<WebElement> paginationButtons;
//        private WebElement currentPage;
//
//        public PaginationTable(By paginationTableLocator) {
//            paginationButtons = webDriverManager.findElementsInsideElement(paginationTableLocator,
//                    By.cssSelector("li > a"));
//            currentPage = webDriverManager.findElementInsideElement(paginationTableLocator,
//                    By.cssSelector("li > span"));
//        }
//
//        // PageObject
//
//        // get data
//
//        public List<WebElement> getPaginationButtons() {
//            return paginationButtons;
//        }
//
//        public WebElement getCurrentPage() {
//            return currentPage;
//        }
//
//        private WebElement getBtnBySymbol(String btnSymbol) {
//            WebElement result = null;
//            for (WebElement current : getPaginationButtons()) {
//                if (current.getText().toLowerCase().equals(btnSymbol.toLowerCase())) {
//                    result = current;
//                    break;
//                }
//            }
//            return result;
//        }
//
//        // get Functional
//
//        public String getCurrentPageText() {
//            return getCurrentPage().getText();
//        }
//
//        public WebElement getFirstPageBtn() {
//            return getBtnBySymbol(FIRST_PAGE_SYMBOL);
//        }
//
//        public WebElement getPreviousPageBtn() {
//            return getBtnBySymbol(PREVIOUS_PAGE_SYMBOL);
//        }
//
//        public WebElement getNextPageBtn() {
//            return getBtnBySymbol(NEXT_PAGE_SYMBOL);
//        }
//
//        public WebElement getLastPageBtn() {
//            return getBtnBySymbol(LAST_PAGE_SYMBOL);
//        }
//
//        public WebElement getPageByNumber(int pageNumber) {
//            return getBtnBySymbol(String.valueOf(pageNumber));
//        }
//
//    }
//
//}
//
