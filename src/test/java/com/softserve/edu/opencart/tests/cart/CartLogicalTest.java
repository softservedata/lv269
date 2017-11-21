package com.softserve.edu.opencart.tests.cart;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.data.products.Product;
import com.softserve.edu.opencart.data.products.ProductRepository;
import com.softserve.edu.opencart.data.users.User;
import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.pages.Application;

public class CartLogicalTest {
    @BeforeClass
    public void beforeClass() {
      //Application.get(ApplicationSourceRepository.get().chromeServer7());
        Application.get(ApplicationSourceRepository.get().firefoxServer7());
    }
    
    @AfterClass
    public void afterClass()  {
        Application.remove();
    }
    
    @AfterMethod
    public void afterMethod() {
    	Application.get().deleteAllCookies();
    	
    	Application.get().loadHomePage()
        .gotoLoginPageFromMyAccount()
        .gotoLoginForLoginPageToMyAccountPage(UserRepository.get().valid())
        .gotoCartPage()
        .clearCart();
    }
	
    @DataProvider//(parallel = true)
    public Object[][] orderData() {
        // Read from ...
        return new Object[][] { 
            { UserRepository.get().valid(),ProductRepository.get().iPhone() },
            { UserRepository.get().valid(),ProductRepository.get().macBook() },
            { UserRepository.get().valid(),ProductRepository.get().canon() },
            };
    }
    
	@Test(dataProvider = "orderData")
    public void checkLogic(User user, Product product){

		Assert.assertTrue(Application.get().loadHomePage()
        .addProductToCart(product)
        .gotoLoginPageFromMyAccount()
        .gotoLoginForLoginPageToMyAccountPage(user)
        .gotoHomePageViaHomeLogoClick()
        .gotoCartPage()
        .isProductPresent(product));
        
    }
}
