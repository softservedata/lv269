package server7.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * This class consists Product list with elements
 */
public class ProductList {

    private List<ProductShort> productList;
    private WebDriverCreator webDriverCreator;
    WebElement currentProductElement;

    ProductList(WebDriverCreator webDriverCreator,
                List<WebElement> listElements) {
        this.webDriverCreator = webDriverCreator;
        productList = new ArrayList<>();
        addElementsFromTable(listElements);
    }

    /**
     * It adds new Product to the list by analizing WebElemet of row
     * @param listElements - webElements, every row - item with
     *                     characteristics
     */
    public void addElementsFromTable(List<WebElement> listElements) {
        for (WebElement currentProductElement : listElements) {
            ProductShort currentProduct = new ProductShort();
            this.currentProductElement = currentProductElement;
            currentProduct.setImageFlag(extractImageLogoFlag());
            currentProduct.setName(extractProductName());
            currentProduct.setModel(extractModel());
            currentProduct.setPrice(extractPrice());
            currentProduct.setQuantity(extractQuantity());
            currentProduct.setStatusFlag(extractStatus());
            productList.add(currentProduct);
        }
    }

    /**
     * @return the list's size
     */
    public int getSize() {
        return productList.size();
    }

    /**
     * Next methods extract necessary data from elemets in the table.
     * @return
     */
    private Boolean extractStatus() {
        String statusInTable = webDriverCreator.findElementInsideElement(
                currentProductElement, By.xpath(ElementsSelectors
                        .ITEMS_TABLE_MODEL_TD_XPTH.getElement()))
                .getAttribute("innerHTML");
        return (statusInTable.equals(
                Credentials.ADM_PRODUCT_PG_STATUS_SLCT_VALUE_TRUE_TXT
                        .getChosenConstant()));
    }

    private String extractQuantity() {
        return webDriverCreator.findElementInsideElement(currentProductElement,
                By.xpath(ElementsSelectors.ITEMS_TABLE_QUANTITY_SPAN_XPTH
                        .getElement())).getText();
    }

    private String extractPrice() {
        String price;
        if (webDriverCreator.findElementsInsideElement(currentProductElement,
                By.xpath(ElementsSelectors.ITEMS_TABLE_PRICE_SPAN_2PRICES_XPTH
                        .getElement())).size() > 0) {
            price = webDriverCreator.findElementInsideElement(currentProductElement,
                    By.xpath(ElementsSelectors.ITEMS_TABLE_PRICE_SPAN_2PRICES_XPTH
                            .getElement())).getText();
        } else {
            price = webDriverCreator.findElementInsideElement(currentProductElement,
                    By.xpath(ElementsSelectors.ITEMS_TABLE_PRICE_TD_1PRICE_XPTH
                            .getElement())).getAttribute("innerHTML");
        }

        return price;
    }

    private String extractModel() {
        String temp = webDriverCreator.findElementInsideElement(currentProductElement,
                By.xpath(ElementsSelectors.ITEMS_TABLE_MODEL_TD_XPTH
                        .getElement())).getAttribute("innerHTML");
        System.out.println(temp);
        return temp;
    }

    private String extractProductName() {
        return webDriverCreator.findElementInsideElement(currentProductElement,
                By.xpath(ElementsSelectors.ITEMS_TABLE_NAME_TD_XPTH
                        .getElement())).getAttribute("innerHTML");
    }

    private Boolean extractImageLogoFlag() {
        String currentProductImgURL = webDriverCreator.findElementInsideElement(
                currentProductElement, By.xpath(
                        ElementsSelectors.ADM_ITEMS_TABLE_IMG_XPTH.getElement()))
                .getAttribute("src");
        return (currentProductImgURL.equals(Credentials
                .ADM_PRODUCT_PG_DFLT_IMAGE_ADDRESS_SMALL.getChosenConstant()));
    }
}