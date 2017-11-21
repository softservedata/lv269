package com.softserve.edu.opencart.data.field;

import org.openqa.selenium.WebElement;

public interface IMessage {
    String getMessageText();

    WebElement getAlertText();

    WebElement getField() ;
}
