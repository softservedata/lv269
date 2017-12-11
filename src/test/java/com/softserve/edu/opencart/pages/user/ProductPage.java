package com.softserve.edu.opencart.pages.user;

import com.softserve.edu.opencart.data.reviews.IReview;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.RegexPatterns;
import com.softserve.edu.opencart.pages.TagAttribute;
import com.softserve.edu.opencart.tools.NumberUtils;
import com.softserve.edu.opencart.tools.exceptions.ErrorUtils;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Serhiienko.
 */
public class ProductPage extends ANavigatePanelComponent {

    private class Description {

        private WebElement descriptionBody;

        private Description() {
            descriptionBody = search.id("tab-description");
        }

        private WebElement getDescriptionBody() {
            return descriptionBody;
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    private class Specification {
        private WebElement specificationBody;

        private Specification() {
            specificationBody = search.id("tab-specification");
        }

        private WebElement getSpecificationBody() {
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
            form = search.id("form-review");
            nameField = search.id("input-name");
            textField = search.id("input-review");
            button = search.id("button-review");
            rating = search.names("rating");
            reviewsExist = search.cssSelectors(".table.table-striped.table-bordered");
        }

        public WebElement getForm() {
            return form;
        }

        private WebElement getNameField() {
            return nameField;
        }

        private WebElement getTextField() {
            return textField;
        }

        private WebElement getButton() {
            return button;
        }

        private List<WebElement> getRating() {
            return rating;
        }

        private List<WebElement> getReviewsExist() {
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

    public ProductPage() {
        addToCart = search.id("button-cart");
        addToWish = search.cssSelector(".btn.btn-default > .fa.fa-heart");
        name = search.cssSelector(".col-sm-4 > h1");
        price = search.cssSelector(".list-unstyled > li > h2");
        quantityField = search.id("input-quantity");
        navTab = search.cssSelectors(".nav.nav-tabs > li > a");
        description = new Description();
    }

    // PageObject

    // get Data

    public WebElement getName() {
        return name;
    }

    public WebElement getPrice() {
        return price;
    }

    private WebElement getQuantityField() {
        return quantityField;
    }

    public List<WebElement> getReviewsExsist() {
        return review.getReviewsExist();
    }

    private Description getDescription() {
        return description;
    }

    private Specification getSpecification() {
        return specification;
    }

    private Review getReview() {
        return review;
    }

    private WebElement getAddToCart() {
        return addToCart;
    }

    private WebElement getAddToWish() {
        return addToWish;
    }

    private List<WebElement> getNavTab() {
        return navTab;
    }

    // get Functional

    private String getNameText() {
        return getName().getText();
    }

    private String getPriceText() {
        return getPrice().getText();
    }

    public double getPriceAmount() {
        return NumberUtils.extractDouble(RegexPatterns.NUMBER_DOUBLE.toString(), getPriceText());
    }

    private String getQuantityFieldText() {
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

    private void clickAddToCart() {
        getAddToCart().click();
    }

    private void clickAddToWish() {
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

    public void setReviewRating(Integer rating) {
        getReview().getRating().get(rating).click();
    }

    public void clickReviewButton() {
        getReview().getButton().click();
    }

    // set Functional

    private final String ITEM_FROM_NAVTAB_NOT_FOUND_MESSAGE = "Item from navTab %s not found for product %s";
    //private final String ALERT_NOT_FOUND_MESSAGE = "Alert %s not found";


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

    public int getAmountReviewsExsist() {
        return getReview().getReviewsExist().size();
    }

   /* // Alert. It can use for refactoring.

    private WebElement alertSuccess;
    private WebElement alertDanger;
    private WebElement alertWarning;

    private void createAlert(String alert) {
        WebElement result = null;
        if (driver.findElements(By.className(alert)).size()>0) {
            result = driver.findElement(By.className(alert));
        }
        ErrorUtils.createCustomException((result == null),
                String.format(ALERT_NOT_FOUND_MESSAGE, alert));
    }

    protected void createAlertSuccess() {
        createAlert("alert-success");
    }

    protected void createAlertDanger() {
        createAlert("alert-danger");
    }

    protected void createAlertWarning() {
        createAlert("alert-warning");
    }

    private WebElement getAlertSuccess() {
        return alertSuccess;
    }

    private WebElement getAlertDanger() {
        return alertDanger;
    }

    private WebElement getAlertWarning() {
        return alertWarning;
    }

    public String getAlertSuccessText() {
        return getAlertSuccess().getText();
    }

    public String getAlertDangerText() {
        return getAlertDanger().getText();
    }

    public String getAlertWarningText() {
        return getAlertWarning().getText();
    }
*/
    // Business Logic

    private void inputReviewNameField(String name) {
        clickReviewNameField();
        clearReviewNameField();
        setReviewNameField(name);
    }

    private void inputReviewTextField(String text) {
        clickReviewTextField();
        clearReviewTextField();
        setReviewTextField(text);
    }

    private void newReview(IReview myReview) {
        clickReview();
        inputReviewNameField(myReview.getName());
        inputReviewTextField(myReview.getText());
        setReviewRating(myReview.getRating());
        clickReviewButton();
        review = new Review();
    }

    public void validReviewFields(IReview myReview) {
        newReview(myReview);
        createAlertSuccess();
    }

    public void validReviewFieldsUserLogOut(IReview myReview) {
        newReview(myReview);
        createAlertDanger();
    }

    public void notValidReviewFields(IReview myReview) {
        newReview(myReview);
        createAlertDanger();
    }

    public void onlyReviewRating(IReview myReview) {
        clickReview();
        setReviewRating(myReview.getRating());
        clickReviewButton();
        review = new Review();
        createAlertDanger();
    }

    public void reviewWithOutRating(IReview myReview) {
        clickReview();
        inputReviewNameField(myReview.getName());
        inputReviewTextField(myReview.getText());
        clickReviewButton();
        review = new Review();
        createAlertDanger();
    }

    public ProductPage checkClickToAddToCart() {
        clickAddToCart();
        Application.get().browser().refreshPage();
        return new ProductPage();
    }

    public ProductPage checkClickToAddToWish() {
        clickAddToWish();
        Application.get().browser().refreshPage();
        return new ProductPage();
    }

}
