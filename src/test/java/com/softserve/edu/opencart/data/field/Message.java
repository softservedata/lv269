package com.softserve.edu.opencart.data.field;

import org.openqa.selenium.WebElement;

public class Message implements IMessage {
    private String messageText;
    private WebElement field;
    private WebElement alertText;

    public Message (WebElement field){
        this.field = field;
    }

    public Message(String messageText, WebElement field, WebElement alertText) {
        this.messageText = messageText;
        this.field = field;
        this.alertText = alertText;

    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public WebElement getField() {
        return field;
    }

    public void setField(WebElement field) {
        this.field = field;
    }

    public WebElement getAlertText() {
        return alertText;
    }

    public void setAlertText(WebElement alertText) {
        this.alertText = alertText;
    }
}
