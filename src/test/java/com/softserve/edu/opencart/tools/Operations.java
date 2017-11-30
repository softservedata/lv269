package com.softserve.edu.opencart.tools;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public final class Operations {

    private static final String VALUE_NOT_FOUND_MESSAGE = "For select, value = %s was not found.";

    private Operations() {
    }

    public static void cleanField(WebElement webElement) {
        webElement.clear();
    }

    public static void clickElement(WebElement webElement) {
        webElement.click();
    }

    public static void fillInputField(WebElement webElement, String text) {
        clickElement(webElement);
        webElement.clear();
        webElement.sendKeys(text);
    }

    public static String getTextFromElement (WebElement webElement) {
        return webElement.getText();
    }

    public static void selectCheckBox(WebElement checkBoxElement) {
        if (!isCheckboxSelected(checkBoxElement)) {
            clickElement(checkBoxElement);
        }
    }

    public static void deselectCheckBox(WebElement checkBoxElement) {
        if (isCheckboxSelected(checkBoxElement)) {
            clickElement(checkBoxElement);
        }
    }

    public static boolean isCheckboxSelected(WebElement checkBoxElement) {
        return (checkBoxElement.isSelected());
    }

    public static void selectByVisibleText(Select selectElement, String valueText) {
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

    public static boolean isElementDisplayed(WebElement webElement) {
        return (webElement.isDisplayed());
    }

}
