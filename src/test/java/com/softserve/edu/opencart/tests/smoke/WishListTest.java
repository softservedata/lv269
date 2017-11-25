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
		Application.get(ApplicationSourceRepository.get().chromeImplicitServer7());
		//Application.get(ApplicationSourceRepository.get().firefoxServer7x32());	
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
	}

	@DataProvider
	public Object[][] userData() {
		return new Object[][] { 
				{ 
					UserRepository.get().userKutaiev() 
				} 
			};
	}
	
	@Test(dataProvider = "userData")
	public void checkEmptyWishList(IUser user) {
		Assert.assertEquals(
				Application.get().loadHomePage()
				.gotoLoginPageFromMyAccount()
				.gotoLoginForLoginPageToMyAccountPage(user)
				.gotoWishListPageRightColumn()
				.getContentDataText(),"Your wish list is empty.");
	}
}