package com.softserve.edu.opencart.tests.smoke;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

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
import com.softserve.edu.opencart.tools.BrowserWrapper;

public class WishListTest {

	@BeforeClass
	public void beforeClass() {
		//Application.get(ApplicationSourceRepository.get().chromeServer7());
		Application.get(ApplicationSourceRepository.get().firefoxServer7x32());
	}

	@AfterClass
	public void afterClass() {
		Application.remove();
	}
	
	@BeforeMethod
	public void beforeMethod() {
		
	}
	
	@AfterMethod
	public void afterMethod() {
		// TODO Refactor After
		Application.get().deleteAllCookies();
		HomePage homePage = Application.get().loadHomePage();
		WishListPage wishList;
		if (!homePage.isUserSignedIn()) {
			wishList = Application.get().loadHomePage()
			.gotoLoginPageFromMyAccount()
			.gotoLoginForLoginPageToMyAccountPage(UserRepository.get().userKutaiev())
			.gotoWishListPageRightColumn();
		} else {
			wishList = homePage
					.gotoMyAccountPageFromHomePage()
					.gotoWishListPageRightColumn();
		}
		if (!wishList.isWishListEmpty()) {
			List<String> products = wishList.getProductNamesFromWishList();
			if (products.size() == 0) {
				return;
			}
			for (String product : products) {
				wishList = wishList.clickDeleteProductFromWishList(product);
			}
		}
		
		Application.get().deleteAllCookies();
	}

	@DataProvider
	public Object[][] userData() {
		return new Object[][] { 
				{ 
					UserRepository.get().userKutaiev() 
				} 
			};
	}
	
	@DataProvider
	public Object[][] productAndUserData() {
		return new Object[][] { 
				{ 
					ProductRepository.get().macBook(), 
					UserRepository.get().userKutaiev() 
				} 
			};
	}

	@Test (dataProvider = "productAndUserData", invocationCount=15)
	public void checkNotEmptyWishListPage(Product macBook, IUser user) throws Exception {
		Assert.assertEquals(
				Application.get().loadHomePage()
				.gotoHomePageClickAddToWish(macBook)
				.gotoLoginPageFromMyAccount()
				.gotoLoginForLoginPageToMyAccountPage(user)
				.gotoWishListPageRightColumn()
				.checkWhetherProductExistsInWishList(macBook), 
				true);
	}
	
	@Test(dataProvider = "userData", invocationCount=15)
	public void checkEmptyWishList(IUser user) {
		Assert.assertEquals(
				Application.get().loadHomePage()
				.gotoLoginPageFromMyAccount()
				.gotoLoginForLoginPageToMyAccountPage(user)
				.gotoWishListPageRightColumn()
				.getContentDataText(),"Your wish list is empty.");
	}
}