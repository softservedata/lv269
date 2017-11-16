package com.softserve.edu.opencart.pages.user;

import com.softserve.edu.opencart.pages.RegexPatterns;
import com.softserve.edu.opencart.pages.TagAttribute;
import com.softserve.edu.opencart.tools.ErrorUtils;
import com.softserve.edu.opencart.tools.NumberUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Serhiienko.
 */
public class ProductPage extends ANavigatePanelComponent {


    private class Description {

        private WebElement descriptionBody;

        public Description() {
            descriptionBody = driver.findElement(By.id("tab-description"));
        }

        public WebElement getDescriptionBody() {
            return descriptionBody;
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    private class Specification {
        private WebElement specificationBody;

        public Specification() {
            specificationBody = driver.findElement(By.id("tab-specification"));
        }

        public WebElement getSpecificationBody() {
            return specificationBody;
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    private class Review {
        private WebElement form;
        private List<WebElement> reviewsExist;
        private WebElement nameField;
        private WebElement textField;
        private WebElement button;
        private List<WebElement> rating;

        public Review() {
            form = driver.findElement(By.id("form-review"));
            nameField = driver.findElement(By.id("input-name"));
            textField = driver.findElement(By.id("input-review"));
            button = driver.findElement(By.id("button-review"));
            rating = driver.findElements(By.name("rating"));
            reviewsExist = driver.findElements(By.cssSelector(".table.table-striped.table-bordered"));
        }

        public WebElement getForm() {
            return form;
        }

        public WebElement getNameField() {
            return nameField;
        }

        public WebElement getTextField() {
            return textField;
        }

        public WebElement getButton() {
            return button;
        }

        public List<WebElement> getRating() {
            return rating;
        }

        public List<WebElement> getReviewsExist() {
            return reviewsExist;
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // Fields

    private WebElement addToCart;
    private WebElement addToWish;
    private WebElement name;
    private WebElement price;
    private WebElement quantityField;
    private Description description;
    private Specification specification;
    private Review review;
    private List<WebElement> navTab;

    public ProductPage(WebDriver driver) {
        super(driver);
        addToCart = driver.findElement(By.id("button-cart"));
        addToWish = driver.findElement(By.cssSelector(".btn.btn-default > .fa.fa-heart"));
        name = driver.findElement(By.cssSelector(".col-sm-4 > h1"));
        price = driver.findElement(By.cssSelector(".list-unstyled > li > h2"));
        quantityField = driver.findElement(By.id("input-quantity"));
        navTab = driver.findElements(By.cssSelector(".nav.nav-tabs > li > a"));
        description = new Description();
        //initNavTabElement();
    }

   /* private void initNavTabElement() {
        for (WebElement current : navTab) {
            if (current.getAttribute("href").contains("description")) {
                description = new Description();
            }
            if (current.getAttribute("href").contains("specification")) {
                specification = new Specification();
            }
            if (current.getAttribute("href").contains("review")) {
                review = new Review();
            }
        }
    }*/

    // PageObject

    // get Data

    public WebElement getName() {
        return name;
    }

    public WebElement getPrice() {
        return price;
    }

    public WebElement getQuantityField() {
        return quantityField;
    }

    public List<WebElement> getReviewsExsist() {
        return review.getReviewsExist();
    }

    public Description getDescription() {
        return description;
    }

    public Specification getSpecification() {
        return specification;
    }

    public Review getReview() {
        return review;
    }

    public WebElement getAddToCart() {
        return addToCart;
    }

    public WebElement getAddToWish() {
        return addToWish;
    }

    public List<WebElement> getNavTab() {
        return navTab;
    }

    // get Functional

    public String getNameText() {
        return getName().getText();
    }

    public String getPriceText() {
        return getPrice().getText();
    }

    public double getPriceAmount() {
        return NumberUtils.extractDouble(RegexPatterns.NUMBER_DOUBLE.toString(), getPriceText());
    }

    public String getQuantityFieldText() {
        return getQuantityField().getText();
    }

    public int getQuantityFieldAmount() {
        return NumberUtils.extractNumber(RegexPatterns.FIRST_DIGITS.toString(), getQuantityFieldText());
    }

    public String getDescriptionText() {
        return getDescription().getDescriptionBody().getText();
    }

    public String getSpecificationText() {
        return getSpecification().getSpecificationBody().getText();
    }

    public String getReviewNameField() {
        return getReview().getNameField().getText();
    }

    public String getkReviewTextField() {
        return getReview().getTextField().getText();
    }

    public String getReviewRating() {
        List<WebElement> rating = getReview().getRating();
        WebElement result = null;
        for (WebElement current : rating) {
            if (current.isSelected()) result = current;
        }
        return result.getAttribute(TagAttribute.VALUE.toString());
    }

    // set Data

    public void clickQuantityField() {
        getQuantityField().click();
    }

    public void clearQuantityField() {
        getQuantityField().clear();
    }

    public void setQuantityField(String quantity) {
        getQuantityField().sendKeys(quantity);
    }

    public void clickAddToCart() {
        getAddToCart().click();
    }

    public void clickAddToWish() {
        getAddToWish().click();
    }

    public void clickReviewNameField() {
        getReview().getNameField().click();
    }

    public void clearReviewNameField() {
        getReview().getNameField().clear();
    }

    public void setReviewNameField(String name) {
        getReview().getNameField().sendKeys(name);
    }

    public void clickReviewTextField() {
        getReview().getTextField().click();
    }

    public void clearReviewTextField() {
        getReview().getTextField().clear();
    }

    public void setReviewTextField(String text) {
        getReview().getTextField().sendKeys(text);
    }

    // how to choose rating
    public void setReviewRatingFist() {
        getReview().getRating().get(0).click();
    }

    public void clickReviewButton() {
        getReview().getButton().click();
    }

    // set Functional

    private final String ITEM_FROM_NAVTAB_NOT_FOUND_MESSAGE = "Item from navTab %s not found for product %s";
    private final String EXSIST_REVIEW_NOT_FOUND_MESSAGE = "Exsist reviev %s not found for product %s";


    private WebElement getItemFromNavTab(String item) {
        WebElement result = null;
        List<WebElement> listNavTab = getNavTab();
        for (WebElement current : listNavTab) {
            if (current.getAttribute(TagAttribute.HREF.toString()).contains(item)) {
                result = current;
                break;
            }
        }
        ErrorUtils.createCustomException((result == null),
                String.format(ITEM_FROM_NAVTAB_NOT_FOUND_MESSAGE, item, getNameText()));

        return result;
    }

    public void clickDescription() {
        getItemFromNavTab("description").click();
        description = new Description();
    }

    public void clickSpecification() {
        getItemFromNavTab("specification").click();
        specification = new Specification();
    }

    public void clickReview() {
        getItemFromNavTab("review").click();
        review = new Review();
    }

   /* public WebElement getOneReviewExsistByName(String name) {

        WebElement result = null;
        List<WebElement> listReview = getReviewsExsist();
        for (WebElement current : listReview) {
            if (current.getAttribute(TagAttribute.HREF.toString()).contains(name)) {
                result = current;
            }
        }
        ErrorUtils.createCustomException((result == null),
                 String.format(EXSIST_REVIEW_NOT_FOUND_MESSAGE, name, getNameText()));
        return result;
    }

    public WebElement getOneReviewExsistByDate (String date) {

        WebElement result = null;
        List<WebElement> listReview = getReviewsExsist();
        for (WebElement current : listReview) {
            if (current.getAttribute(TagAttribute.HREF.toString()).contains(date)) {
                result = current;
            }
        }
        ErrorUtils.createCustomException((result == null),
                 String.format(EXSIST_REVIEW_NOT_FOUND_MESSAGE, date, getNameText()));
        return result;
    }*/


    // Warning.

    private AlertSuccess alertSuccess;
    private AlertDanger alertDanger;

    private class AlertSuccess {

        private WebElement alertSuccessBody;

        public AlertSuccess() {
            alertSuccessBody = driver.findElement(By.className("alert alert-success"));
        }

        public WebElement getAlertSuccessBody() {
            return alertSuccessBody;
        }
    }

    private class AlertDanger {

        private WebElement alertDangerBody;

        public AlertDanger() {
            alertDangerBody = driver.findElement(By.className("alert alert-danger"));
        }

        public WebElement getAlertDangerBody() {
            return alertDangerBody;
        }
    }

    public void createAlertSuccess() {
        alertSuccess = new AlertSuccess();
    }

    public void createAlertDanger() {
        alertDanger = new AlertDanger();
    }

    public AlertSuccess getAlertSuccess() {
        return alertSuccess;
    }

    public AlertDanger getAlertDanger() {
        return alertDanger;
    }

    public String getAlertSuccessText() {
        return getAlertSuccess().getAlertSuccessBody().getText();
    }

    public String getAlertDangerText() {
        return getAlertDanger().getAlertDangerBody().getText();
    }

    // Business Logic


}
