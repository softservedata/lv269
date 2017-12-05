package com.softserve.edu.opencart.tools;


import com.softserve.edu.opencart.pages.TagAttribute;
import com.softserve.edu.opencart.tools.exceptions.ErrorUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Operations {

    private final String VALUE_NOT_FOUND_MESSAGE = "For select, value = %s was not found.";

    public Operations() {
    }

    public void cleanField(WebElement webElement) {
        webElement.clear();
    }

    public void clickElement(WebElement webElement) {
        webElement.click();
    }

    public void fillInputField(WebElement webElement, String text) {
        clickElement(webElement);
        webElement.clear();
        webElement.sendKeys(text);
    }

    public String getTextFromElement (WebElement webElement) {
        return webElement.getText();
    }

    public void selectCheckBox(WebElement checkBoxElement) {
        if (!isCheckboxSelected(checkBoxElement)) {
            clickElement(checkBoxElement);
        }
    }

    public void deselectCheckBox(WebElement checkBoxElement) {
        if (isCheckboxSelected(checkBoxElement)) {
            clickElement(checkBoxElement);
        }
    }

    public boolean isCheckboxSelected(WebElement checkBoxElement) {
        return (checkBoxElement.isSelected());
    }

    public void selectByVisibleText(Select selectElement, String valueText) {
        boolean flag = false;
        int selectedValueNumber = -1;
        for (WebElement current : selectElement.getOptions()) {
            if (current.getText().toLowerCase().contains(valueText.toLowerCase())) {
                valueText = current.getText();
                flag = true;
                break;
            }
        }
        ErrorUtils.createValueNotFoundException(!flag,
                String.format(VALUE_NOT_FOUND_MESSAGE, valueText));
        selectElement.selectByVisibleText(valueText);
    }

    public boolean isElementDisplayed(WebElement webElement) {
        return (webElement.isDisplayed());
    }

    public String getText (WebElement webElement) {
        return webElement.getText();
    }

    public String getAttribute (WebElement webElement, String attribute) {
        return webElement.getAttribute(attribute);
    }

    public String getClassNameFromElement(WebElement webElement) {
        return getAttribute(webElement, TagAttribute.CLASS.toString());
    }
}
