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
import com.softserve.edu.opencart.data.products.IProduct;
import com.softserve.edu.opencart.data.products.Product;
import com.softserve.edu.opencart.data.products.ProductRepository;
import com.softserve.edu.opencart.data.users.IUser;
import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.WishListPage;

public class WishListTest {

	private final static String ELEMENT_IS_MISSING = "Element is missing";
	private final static String ELEMENTS_ARE_MISSING = "WishList does not contain these items";
	private final static String SIZES_ARE_NOT_EQUAL = "Wish List size and top panel indicator are not equal";
	
	@BeforeClass
	public void beforeClass() {
		//Application.get(ApplicationSourceRepository.get().chromeServer7());
		Application.get(ApplicationSourceRepository.get().firefoxImplicitServer7x32());	
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
		Application.get().getBrowser().deleteAllCookies();
		
		Application.get().loadHomePage()
			.gotoLoginPageFromMyAccount()
			.gotoLoginForLoginPageToMyAccountPage(UserRepository.get().userKutaiev())
			.gotoWishListPageRightColumn()
			.doWishListEmpty();
		
		Application.get().getBrowser().deleteAllCookies();
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
	@Test (dataProvider = "productAndUserData")
	public void testAddItem(IProduct macBook, IUser user) {
		Assert.assertTrue(
				Application.get().loadHomePage()
				.gotoHomePageClickAddToWish(macBook)
				.gotoLoginPageFromMyAccount()
				.gotoLoginForLoginPageToMyAccountPage(user)
				.gotoWishListPageRightColumn()
				.checkWhetherProductExistsInWishList(macBook), 
				ELEMENT_IS_MISSING);
	}
	// - - - - - - - - - - - - - #1 - - - - - - - - - - - - -
	
	// - - - - - - - - - - - - - #2 - - - - - - - - - - - - -
	@Test(dataProvider = "productsAndUserData")
	public void testAddWithoutLogin(IProduct iPhone, IProduct macBook, IUser user) {
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
				expected, ELEMENTS_ARE_MISSING);
	}
	// - - - - - - - - - - - - - #2 - - - - - - - - - - - - -
	
	// - - - - - - - - - - - - - #3 - - - - - - - - - - - - -	
	@Test (dataProvider = "productsAndUserData")
	public void testWhishListIndicator(IProduct iPhone, Product macBook, IUser user) {
		
		WishListPage wishListPage = Application.get().loadHomePage()
				.gotoHomePageClickAddToWish(iPhone)
				.gotoHomePageClickAddToWish(macBook)
				.gotoLoginPageFromMyAccount()
				.gotoLoginForLoginPageToMyAccountPage(user)
				.gotoWishListPageRightColumn();
		
		Assert.assertEquals(
				wishListPage.getWishListNumber(),
				wishListPage.getProductNamesFromWishList().size(),
				SIZES_ARE_NOT_EQUAL);
	}
	// - - - - - - - - - - - - - #3 - - - - - - - - - - - - -
}
