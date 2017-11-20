package com.softserve.edu.opencart.tests.wishlist;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.data.products.Product;
import com.softserve.edu.opencart.data.products.ProductRepository;
import com.softserve.edu.opencart.data.users.IUser;
import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.WishListPage;

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
			if (products.size() > 0) {
				for (String product : products) {
					wishList = wishList.clickDeleteProductFromWishList(product);
				}
			}
		}
		Application.get().deleteAllCookies();
	}
	
	// - - - - - - - Data prodiver level - - - - - - - - 
	
	@DataProvider
	public Object[][] productAndUserData() {
		return new Object[][] { 
				{ 
					ProductRepository.get().macBook(), 
					UserRepository.get().userKutaiev() 
				} 
			};
	}
	
	@DataProvider
	public Object[][] productsAndUserData() {
		return new Object[][] { 
				{ 
					ProductRepository.get().iPhone(), 
					ProductRepository.get().macBook(), 
					UserRepository.get().userKutaiev() 
				} 
			};
	}
	
	// - - - - - - - Test case level - - - - - - - - 
	
	// - - - - - - - - - - - - - #1 - - - - - - - - - - - - -
	@Test (dataProvider = "productAndUserData", invocationCount=5)
	public void testAddItem(Product macBook, IUser user) {
		Assert.assertTrue(
				Application.get().loadHomePage()
				.gotoHomePageClickAddToWish(macBook)
				.gotoLoginPageFromMyAccount()
				.gotoLoginForLoginPageToMyAccountPage(user)
				.gotoWishListPageRightColumn()
				.checkWhetherProductExistsInWishList(macBook), 
				"Element is missing");
	}
	// - - - - - - - - - - - - - #1 - - - - - - - - - - - - -
	
	// - - - - - - - - - - - - - #2 - - - - - - - - - - - - -
	@Test (dataProvider = "productsAndUserData", invocationCount=5)
	public void testAddWithoutLogin(Product iPhone, Product macBook, IUser user) {
		List<String> expected = new ArrayList<>();
		expected.add(iPhone.getName());
		expected.add(macBook.getName());	
		
		Assert.assertEquals(
				Application.get().loadHomePage()
				.gotoLoginPageFromMyAccount()
				.gotoLoginForLoginPageToMyAccountPage(user)
				.gotoHomePageViaHomeLogoClick()
				.gotoHomePageClickAddToWish(iPhone)
				.gotoMyAccountPageFromHomePage()
				.gotoLogoutPageRightColumn()
				.gotoHomePage()
				.gotoHomePageClickAddToWish(macBook)
				.gotoLoginPageFromMyAccount()
				.gotoLoginForLoginPageToMyAccountPage(user)
				.gotoWishListPageRightColumn()
				.getProductNamesFromWishList(), 
				expected, "WishList does not contain these items");
	}
	// - - - - - - - - - - - - - #2 - - - - - - - - - - - - -
	
	// - - - - - - - - - - - - - #3 - - - - - - - - - - - - -	
	@Test (dataProvider = "productsAndUserData", invocationCount=5)
	public void testWhishListIndicator(Product iPhone, Product macBook, IUser user) {
		
		WishListPage wishListPage = Application.get().loadHomePage()
				.gotoHomePageClickAddToWish(iPhone)
				.gotoHomePageClickAddToWish(macBook)
				.gotoLoginPageFromMyAccount()
				.gotoLoginForLoginPageToMyAccountPage(user)
				.gotoWishListPageRightColumn();
		
		Assert.assertEquals(
				wishListPage.getWishListNumber(),
				wishListPage.getProductNamesFromWishList().size(),
				"Wish List size and top panel indicator are not equals");
	}
	// - - - - - - - - - - - - - #3 - - - - - - - - - - - - -
}
