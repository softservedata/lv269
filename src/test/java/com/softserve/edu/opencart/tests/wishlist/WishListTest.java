package com.softserve.edu.opencart.tests.wishlist;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.data.users.IUser;
import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.WishListPage;

public class WishListTest {
	@BeforeClass
	public void beforeClass() {
		// Application.get(ApplicationSourceRepository.get().chromeServer7());
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
		//BrowserWrapper browser = new BrowserWrapper(ApplicationSourceRepository.get().chromeServer7());
		//browser.deleteAllCookies();
		/*
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
		
		Application.get().deleteAllCookies();*/
	}
	
	@DataProvider
	public Object[][] userData() {
		return new Object[][] { 
				{ 
					UserRepository.get().userKutaiev() 
				} 
			};
	}
	
	@Test(dataProvider = "userData"/*, invocationCount=15*/)
	public void CheckWishListFirst(IUser user) throws InterruptedException {
		// Check for cookies
		Application.get().loadHomePage()
		.gotoLoginPageFromMyAccount()
		.gotoLoginForLoginPageToMyAccountPage(user);
		
		Thread.sleep(1000);		
		Application.get().deleteAllCookies();		
		Thread.sleep(1000);
		
		Application.get().loadHomePage()
		.gotoLoginPageFromMyAccount();
	}
	
	/*@Test
	public void testAddDeleteItem() {
		module.logIn();
		module.addItem(40);
		module.openWishList();
		module.doWishListEmpty();
		Assert.assertTrue("Wish List is not empty.", module.isWishListEmpty());
	}*/

	/*@Test
	public void testAddWithoutLogin() {
		module.logIn();
		module.addItem(40);
		items.add(40);
		module.logOut();
		module.addItem(41);
		module.logIn();
		items.add(41);
		module.openWishList();
		Assert.assertEquals("Elements are not equals", items, module.getItemsFromWishList());
	}*/

	/*@Test
	public void testWhishListIndicator() {
		module.logIn();
		for (int id = 43; id < 50; id++) {
			module.addItem(id);
			items.add(id);
		}

		Assert.assertEquals("Wish List header counter incorrect", items.size(), module.getWishListItemsCount());
	}*/
}
