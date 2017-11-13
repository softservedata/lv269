package com.softserve.edu.opencart.pages.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.pages.RegexPatterns;
import com.softserve.edu.opencart.pages.TagAttribute;
import com.softserve.edu.opencart.tools.NumberUtils;

public class OrderComponent {
	
	//Fields
	private WebElement orderLayout;
	//
    private WebElement name;
    private WebElement unitPrice;
    private WebElement totalPrice;
    private WebElement quantity;
    private WebElement update;
    private WebElement remove;
    //
    
    //Constructor
    public OrderComponent(WebElement orderLayout) {
        this.orderLayout = orderLayout;
        //
        name = orderLayout.findElement(By.xpath("td[2]/a"));
        unitPrice = orderLayout.findElement(By.xpath("td[5]"));
        totalPrice = orderLayout.findElement(By.xpath("td[6]"));
        quantity = orderLayout.findElement(By.cssSelector("input.form-control"));
        update = orderLayout.findElement(By.cssSelector(".fa.fa-refresh"));
        remove = orderLayout.findElement(By.cssSelector(".fa.fa-times-circle"));
    }
    //
    
    // PageObject

    // get Data

    public WebElement getOrderLayout() {
        return orderLayout;
    }

    public WebElement getName() {
        return name;
    }

    public WebElement getUnitPrice() {
        return unitPrice;
    }

    public WebElement getTotalPrice() {
        return totalPrice;
    }

    public WebElement getQuantity() {
        return quantity;
    }
    
    public WebElement getUpdate() {
        return update;
    }
    
    public WebElement getRemove() {
        return remove;
    }

    // get Functional

    public String getNameText() {
        return getName().getText();
    }
    
    public String getQuantityText() {
        return getQuantity().getAttribute(TagAttribute.VALUE.toString());
    }
    
    public double getQuantityNumber() {
        return NumberUtils.extractDouble(RegexPatterns.FIRST_DIGITS.toString(), getQuantityText());
    }
    
    public String getUnitPriceText() {
        return getUnitPrice().getText();
    }

    public double getUnitPriceAmount() {
        return NumberUtils.extractDouble(RegexPatterns.NUMBER_DOUBLE.toString(), getUnitPriceText());
    }
    
    public String getTotalPriceText() {
        return getTotalPrice().getText();
    }

    public double getTotalPriceAmount() {
        return NumberUtils.extractDouble(RegexPatterns.NUMBER_DOUBLE.toString(), getTotalPriceText());
    }

    // set Data

    public void clickName() {
        getName().click();
    }

    public void clickQuantity() {
        getQuantity().click();
    }

    public void clickUpdate() {
        getUpdate().click();
    }
    
    public void clickRemove() {
        getRemove().click();
    }

    // set Functional

    // Business Logic
}
