package com.softserve.edu.opencart.pages.user;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.pages.TagAttribute;
import com.softserve.edu.opencart.tools.ErrorUtils;

public class CartPage extends ANavigatePanelComponent{
	//Constants
	private final String EMPTY_CART_MESSAGE = "Your shopping cart is empty!";
	private final String ORDER_NAME_NOT_FOUND_MESSAGE = "Order name %s not found in %s";
	//
	
	//Fields
	private WebElement continueBtn;
	private WebElement checkoutBtn;
	//
	private List<OrderComponent> orderComponents;
	
	//Constructor
    public CartPage(WebDriver driver) {
        super(driver);
        if(driver.findElement(By.id("content")).getText()
        		 .toLowerCase().contains(EMPTY_CART_MESSAGE.toLowerCase())) {
        	continueBtn=driver.findElement(By.cssSelector(".btn.btn-primary"));
        	System.out.println("ZERO PRODUCTS CHECKING \n");
        } else {
        	continueBtn=driver.findElement(By.cssSelector("a.btn.btn-default"));
        	checkoutBtn=driver.findElement(By.cssSelector("a.btn.btn-primary"));
        	initOrderComponents(By.cssSelector("div.table-responsive>table.table.table-bordered>tbody tr"));
        	System.out.println("SOME PRODUCTS CHECKING \n");
        }  
        
    }
    //
    
    protected void initOrderComponents(By searchLocator) {
        orderComponents = new ArrayList<>();
        List<WebElement> orderWebElements = driver.findElements(searchLocator);
        for (WebElement current : orderWebElements) {
            orderComponents.add(new OrderComponent(current));
        }
    }
    
    // PageObject

    // get Data

    public WebElement getContinueBtn() {
        return continueBtn;
    }

    public WebElement getCheckoutBtn() {
        return checkoutBtn;
    }
    
    protected List<OrderComponent> getOrderComponent() {
        return orderComponents;
    }
    
    private OrderComponent getOrderComponentByOrderName(String orderName) {
        OrderComponent result = null;
        for (OrderComponent current : getOrderComponent()) {
            if (current.getNameText().toLowerCase().contains(orderName.toLowerCase())) {
                result = current;
                break;
            }
        }
        ErrorUtils.createCustomException((result == null),
                String.format(ORDER_NAME_NOT_FOUND_MESSAGE, orderName, getOrderComponentTexts().toString()));
        return result;
    }
    // get Functional

    public List<String> getOrderComponentTexts() {
        List<String> result = new ArrayList<>();
        for (OrderComponent current : getOrderComponent()) {
            result.add(current.getNameText());
        }
        return result;
    }

    public String getUnitPriceTextByOrderName(String orderName) {
        return getOrderComponentByOrderName(orderName).getUnitPriceText();
    }

    public double getUnitPriceAmountByOrderName(String orderName) {
        return getOrderComponentByOrderName(orderName).getUnitPriceAmount();
    }
    
    public String getTotalPriceTextByOrderName(String orderName) {
        return getOrderComponentByOrderName(orderName).getTotalPriceText();
    }

    public double getTotalPriceAmountByOrderName(String orderName) {
        return getOrderComponentByOrderName(orderName).getTotalPriceAmount();
    }
    
    // set Data

    public void clickCheckoutBtn() {
        getCheckoutBtn().click();
    }

    public void clickContinueBtn() {
    	getContinueBtn().click();
    }
    
    public void clickUpdateByOrderName(String orderName) {
        getOrderComponentByOrderName(orderName).clickUpdate();
    }

    public void  clickRemoveByOrderName(String orderName) {
    	getOrderComponentByOrderName(orderName).clickRemove();
    }
}
