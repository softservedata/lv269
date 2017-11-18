package com.softserve.edu.opencart.tests.smoke;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.categories.DetailCategory;
import com.softserve.edu.opencart.data.products.Product;
import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.LoginPage;
import com.softserve.edu.opencart.pages.user.MyAccountPage;
import com.softserve.edu.opencart.pages.user.WishListPage;

public class WishListTest {
	/*
	@DataProvider//(parallel = true)
    public Object[] productData() {
        // Read from ...
        return new Object[] {
              new Product("MacBook", null, null ),
              new Product("iPhone", null, null),
              new Product("Canon EOS 5D", null, null)
            };
    }
	*/
	//@Test //(dataProvider = "productData")
	public void checkWishListPage() throws Exception {
		//
		// Precondition
		//
		System.setProperty("webdriver.chrome.driver", "C:/Program Files/Java/Selenium360/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//
		driver.get("http://server7.pp.ua");
		//
		// Steps
		//
		HomePage homePage = new HomePage(driver);
		homePage.clickAddToWishByProductName("iPhone");
		homePage = new HomePage(driver);
		homePage.clickAddToWishByProductName("MacBook");
		homePage = new HomePage(driver);
		homePage.clickAddToWishByProductName("Canon EOS 5D");
		homePage = new HomePage(driver);
		//Thread.sleep(500);
		LoginPage loginPage = homePage.gotoLoginPageFromMyAccount();
		MyAccountPage myAccountPage = loginPage.loginForLoginPageToMyAccountPage(
				UserRepository.get().userKutaiev().getEmail(), 
				UserRepository.get().userKutaiev().getPassword());
		myAccountPage.clickWishList();
		WishListPage wishListPage = new WishListPage(driver);
		wishListPage = wishListPage.clickDeleteProductFromWishList("iPhone");
		wishListPage = wishListPage.clickDeleteProductFromWishList("MacBook");
		wishListPage = wishListPage.clickDeleteProductFromWishList("Canon EOS 5D");
		//
		// Check
		//
		//
		// Return to previous state
		//
		driver.quit();
	}
	
	@Test(invocationCount = 100)
	public void checkEmptyWishList() {
		System.setProperty("webdriver.chrome.driver", "C:/Program Files/Java/Selenium360/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://server7.pp.ua");
		
		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = homePage.gotoLoginPageFromMyAccount();
		MyAccountPage myAccountPage = loginPage.loginForLoginPageToMyAccountPage(
				UserRepository.get().userKutaiev().getEmail(), 
				UserRepository.get().userKutaiev().getPassword());
		
		WishListPage wishListPage = myAccountPage.gotoWishListPageRightColumn();
		String expected = "Your wish list is empty.";
		Assert.assertEquals(wishListPage.getContentDataText(), expected);
		
		driver.quit();
	}
}
