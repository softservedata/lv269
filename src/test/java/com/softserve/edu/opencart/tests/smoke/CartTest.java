package com.softserve.edu.opencart.tests.smoke;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.data.products.IProduct;
import com.softserve.edu.opencart.data.products.Product;
import com.softserve.edu.opencart.data.products.ProductRepository;
import com.softserve.edu.opencart.data.users.IUser;
import com.softserve.edu.opencart.data.users.User;
import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.user.CartPage;
import com.softserve.edu.opencart.pages.user.HomePage;

public class CartTest {
	
    @BeforeClass
    public void beforeClass() {
      //Application.get(ApplicationSourceRepository.get().chromeServer7());
        Application.get(ApplicationSourceRepository.get().firefoxServer7());
    }
    @AfterClass
    public void afterClass()  {
        Application.remove();
    }
	
    @DataProvider//(parallel = true)
    public Object[][] orderData() {
        // Read from ...
        return new Object[][] { 
            { UserRepository.get().valid(),ProductRepository.get().iPhone() },
            };
    }
    
    @Test(dataProvider = "orderData",invocationCount = 1)
    public void checkProduct(User user, Product product) throws InterruptedException{

        HomePage homePage=Application.get().loadHomePage()
        .gotoLoginPageFromMyAccount()
        .gotoLoginForLoginPageToMyAccountPage(user)
        .gotoHomePageViaHomeLogoClick()
        .addProductToCart(product)
        .gotoCartPage()
        .refreshCartPageByRemoveOrderElement(product)
        .gotoLogoutPage()
        .gotoHomePage();
        
    }
    
    @Test(dataProvider = "orderData",invocationCount = 1)
    public void checkPricesForOrder(User user, Product product) throws InterruptedException{
    	
        CartPage cartPage=Application.get().loadHomePage()
        .gotoLoginPageFromMyAccount()
        .gotoLoginForLoginPageToMyAccountPage(user)
        .gotoHomePageViaHomeLogoClick()
        .addProductToCart(product)
        .gotoCartPage();
        
        System.out.println("In the site amount="+cartPage.getTotalPriceAmount()+" MyFunctionAmouna="+cartPage.calculationOrderTotalPrice());
    	Assert.assertEquals(cartPage.getTotalPriceAmount(), cartPage.calculationOrderTotalPrice(), 0.001);
        cartPage.refreshCartPageByRemoveOrderElement(product)
        .gotoLogoutPage()
        .gotoHomePage();
    }
    
    @Test(dataProvider = "orderData",invocationCount = 1)
    public void checkPricesForProduct(User user, Product product) throws InterruptedException{
    	
        CartPage cartPage=Application.get().loadHomePage()
        .gotoLoginPageFromMyAccount()
        .gotoLoginForLoginPageToMyAccountPage(user)
        .gotoHomePageViaHomeLogoClick()
        .addProductToCart(product)
        .addProductToCart(product)
        .gotoCartPage();
        
        System.out.println("In the site total="+cartPage.getTotalPriceAmountByProduct(product)+" My total product="+cartPage.calculationProductTotalPrice(product));
    	Assert.assertEquals(cartPage.getTotalPriceAmountByProduct(product), cartPage.calculationProductTotalPrice(product), 0.001);
    
        cartPage.refreshCartPageByRemoveOrderElement(product)
        .gotoLogoutPage()
        .gotoHomePage();
    }
}

