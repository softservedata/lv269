package com.softserve.edu.opencart.tests.smoke;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.data.categories.DetailCategory;
import com.softserve.edu.opencart.data.products.Product;
import com.softserve.edu.opencart.data.products.ProductRepository;
import com.softserve.edu.opencart.data.users.IUser;
import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.LoginPage;
import com.softserve.edu.opencart.pages.user.LogoutPage;
import com.softserve.edu.opencart.pages.user.MyAccountPage;
import com.softserve.edu.opencart.pages.user.WishListPage;

public class WishListTest {

	@BeforeClass
	public void beforeClass() {
		Application.get(ApplicationSourceRepository.get().chromeServer7());
		// Application.get(ApplicationSourceRepository.get().firefoxServer7());
	}

	@AfterClass
	public void afterClass() {
		Application.remove();
	}

	@DataProvider
	public Object[][] productData() {
		return new Object[][] { 
				{ 
					ProductRepository.get().macBook(), 
					ProductRepository.get().iPhone(),
					UserRepository.get().userKutaiev() 
				} 
			};
	}

	@Test (dataProvider = "productData")
	public void checkWishListPage(Product macBook, Product iPhone, IUser user) throws Exception {
		MyAccountPage myAccountPage = Application.get().loadHomePage()
				.gotoHomePageClickAddToWish(macBook)
				.gotoHomePageClickAddToWish(iPhone)
				.gotoLoginPageFromMyAccount()
				.gotoLoginForLoginPageToMyAccountPage(user);
		
		LogoutPage logoutPage = myAccountPage.gotoLogoutPage();
		
		/*
		homePage = homePage.gotoHomePageClickAddToWish(MacBook);
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
		driver.quit();*/
		
	}
	
	//@Test //(invocationCount = 100)
	public void checkEmptyWishList() {
		System.setProperty("webdriver.chrome.driver", "C:/Program Files/Java/Selenium360/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://server7.pp.ua");
		
		HomePage homePage = new HomePage(driver);
		LoginPage loginPage = homePage.gotoLoginPageFromMyAccount();
		MyAccountPage myAccountPage = loginPage.gotoLoginForLoginPageToMyAccountPage(UserRepository.get().userKutaiev());
		
		WishListPage wishListPage = myAccountPage.gotoWishListPageRightColumn();
		String expected = "Your wish list is empty.";
		Assert.assertEquals(wishListPage.getContentDataText(), expected);
		
		driver.quit();
	}
}
