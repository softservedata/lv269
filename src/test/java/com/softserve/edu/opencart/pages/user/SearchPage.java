package com.softserve.edu.opencart.pages.user;

import com.softserve.edu.opencart.pages.RegexPatterns;
import com.softserve.edu.opencart.pages.TagAttribute;
import com.softserve.edu.opencart.tools.ErrorUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchPage extends ANavigatePanelComponent {

    private final String OPTION_NOT_FOUND_MESSAGE = "Option %s not found in %s";

    private WebElement searchHeaderName;
    private WebElement inputSearch;
    private WebElement categorySearchSelect;
    private WebElement categorySearchCheckbox;
    private WebElement descriptionSearchCheckbox;
    private WebElement searchCriteriaButton;
    private WebElement noElementsMeetingCriteria;
    private List<WebElement> subCategoriesSelectList;

    public SearchPage(WebDriver driver) {
        super(driver);

        searchHeaderName = driver.findElement(By.cssSelector("#content > h1"));
        inputSearch = driver.findElement(By.id("input-search"));
        categorySearchSelect = driver.findElement(By.cssSelector("select[name = 'category_id']"));
        categorySearchCheckbox = driver.findElement(By.cssSelector(".checkbox-inline > input[name = 'sub_category']"));
        descriptionSearchCheckbox = driver.findElement(By.
                cssSelector(".checkbox-inline > input[name = 'description']"));
        searchCriteriaButton = driver.findElement(By.id("button-search"));
        noElementsMeetingCriteria = driver.findElement(By.cssSelector("#content > p:last-of-type"));
        subCategoriesSelectList = driver.findElements(By.cssSelector("select[name = 'category_id'] > option"));
        initProductComponents(By.cssSelector(".product-layout"));
    }

    //getters
    public WebElement getSearchHeaderName() {

        return searchHeaderName;
    }

    public WebElement getInputSearch() {

        return inputSearch;
    }

    public WebElement getCategorySearchSelect() {

        return categorySearchSelect;
    }

    public WebElement getCategorySearchCheckbox() {

        return categorySearchCheckbox;
    }

    public WebElement getDescriptionSearchCheckbox() {

        return descriptionSearchCheckbox;
    }



    public List<WebElement> getCategoriesSelectList() {

        return subCategoriesSelectList;
    }

    public WebElement getSearchCriteriaButton() {

        return searchCriteriaButton;
    }

    public WebElement getNoElementsMeetingCriteria() {

        return noElementsMeetingCriteria;
    }

    public WebElement getSelectOptionByPartialName(String categoryName){
        WebElement result = null;
        for (WebElement current : getCategoriesSelectList()) {
            if (current.getText().toLowerCase().contains(categoryName.toLowerCase())) {
                result = current;
                break;
            }
        }
        return result;
    }

    //get text data
    public String getSearchHeaderNameText() {
        return getSearchHeaderName().getText().substring(10);
    }

    public String getInputSearchText() {
        return getInputSearch().getAttribute(TagAttribute.VALUE.toString());
    }

    public String getSelectedCategoryText() {
        Select select = new Select(categorySearchSelect);
        return select.getFirstSelectedOption().getText().trim();
    }

    public String getCategorySearchCheckboxLabel(){
        return getCategorySearchCheckbox().getText();
    }

    public String getDescriptionSearchCheckboxLabel(){
        return getDescriptionSearchCheckbox().getText();
    }

    public String getSearchCriteriaButtonText(){
        return getSearchCriteriaButton().getText();
    }

    public String getNoElementsMeetingCriteriaText() {

        return getNoElementsMeetingCriteria().getText();
    }

    @Override
    public List<String> getProductComponentTexts() {
        return super.getProductComponentTexts();
    }

    @Override
    public String getPriceTextByProductName(String productName) {
        return super.getPriceTextByProductName(productName);
    }

    @Override
    public double getPriceAmountByProductName(String productName) {
        return super.getPriceAmountByProductName(productName);
    }

    //get special text
    protected List<String> getCategorySearchSelectTexts() {
        List<String> result = new ArrayList<>();
        for (WebElement current : getCategoriesSelectList()) {
            result.add(current.getText());
        }
        return result;
    }

    //set data
    public void clickSearchCriteriaButton() {
        getSearchCriteriaButton().click();
    }

    public void setInputSearch(String text) {
        getInputSearch().sendKeys(text);
    }

    public void clearInputSearch() {
        getInputSearch().clear();
    }

    public void clickInputSearch() { getInputSearch().click(); }

    public void clickCategorySearchSelect() { getCategorySearchSelect().click(); }

    public void setCategorySearchSelect(String categoryName){
        boolean isSelectable = false;
        clickCategorySearchSelect();
        for(String current : getCategorySearchSelectTexts()){
            if(current.toLowerCase().contains(categoryName.toLowerCase())) {
                isSelectable = true;
            }
        }
        ErrorUtils.createCustomException(!isSelectable,
                String.format(OPTION_NOT_FOUND_MESSAGE,
                        categoryName, getCategorySearchSelectTexts().toString()));
        getSelectOptionByPartialName(categoryName).click();
    }

    public void selectCategorySearchCheckbox() {
        if(!isCheckboxSelected(getCategorySearchCheckbox())){
            getCategorySearchCheckbox().click();
        }
    }

    public void selectDescriptionSearchCheckbox() {
        if(!isCheckboxSelected(getDescriptionSearchCheckbox())){
            getDescriptionSearchCheckbox().click();
        }
    }
    public void sendKeysToInputSearch(String text){
        clickInputSearch();
        clearInputSearch();
        getInputSearch().sendKeys(text);
    }

    //business logic
    public SearchPage findElementByName(String productName){
        sendKeysToInputSearch(productName);
        clickSearchCriteriaButton();
        return new SearchPage(driver);
    }

    public SearchPage findElementUsingCategorySelect(String productName, String category){
        sendKeysToInputSearch(productName);
        setCategorySearchSelect(category);
        clickSearchCriteriaButton();
        return new SearchPage(driver);
    }

    public SearchPage findElementUsingCategorySelectCheckSubcategory(String productName, String category){
        sendKeysToInputSearch(productName);
        setCategorySearchSelect(category);
        selectCategorySearchCheckbox();
        clickSearchCriteriaButton();
        return new SearchPage(driver);
    }

    public SearchPage findElementUsingCategorySelectCheckDescription(String productName, String category){
        sendKeysToInputSearch(productName);
        setCategorySearchSelect(category);
        selectDescriptionSearchCheckbox();
        clickSearchCriteriaButton();
        return new SearchPage(driver);
    }

    public SearchPage findElementUsingCategorySelectCheckSubcategoryDescription(String productName, String category){
        selectDescriptionSearchCheckbox();
        findElementUsingCategorySelectCheckSubcategory(productName, category);
        return new SearchPage(driver);
    }

    public boolean isFound(List<String> foundProducts, String elementName){
        Pattern pattern = Pattern.compile(RegexPatterns.ANY_NUMBER_OF_SYMBOLS +
                elementName + RegexPatterns.ANY_NUMBER_OF_SYMBOLS);
        Matcher m;
        boolean checker = false;
        for (String current : foundProducts){
            m = pattern.matcher(current);
            if(m.matches()){
                checker = m.matches();
                break;
            }
        }
        return checker;
    }

    //help methods
    public boolean isCheckboxSelected(WebElement checkbox){
        return checkbox.isSelected();
    }
}
