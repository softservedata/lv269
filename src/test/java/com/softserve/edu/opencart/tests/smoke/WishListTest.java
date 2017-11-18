package com.softserve.edu.opencart.tests.smoke;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.categories.DetailCategory;
import com.softserve.edu.opencart.data.products.Product;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.LoginPage;
import com.softserve.edu.opencart.pages.user.MyAccountPage;
import com.softserve.edu.opencart.pages.user.WishListPage;

public class WishListTest {
	
	@DataProvider//(parallel = true)
    public Object[] productData() {
        // Read from ...
        return new Object[] {
              new Product("MacBook", null, null ),
              new Product("iPhone", null, null),
              new Product("Canon EOS 5D", null, null)
            };
    }
	
	@Test //(dataProvider = "productData")
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
		Thread.sleep(500);
		homePage.clickAddToWishByProductName("iPhone");
		homePage = new HomePage(driver);
		Thread.sleep(500);
		homePage.clickAddToWishByProductName("MacBook");
		homePage = new HomePage(driver);
		Thread.sleep(500);
		homePage.clickAddToWishByProductName("Canon EOS 5D");
		homePage = new HomePage(driver);
		Thread.sleep(500);
		LoginPage loginPage = homePage.gotoLoginPageFromMyAccount();
		MyAccountPage myAccountPage = loginPage.loginForLoginPageToMyAccountPage("mfj14401@sqoai.com", "qwerty123456");
		myAccountPage.clickWishList();
		WishListPage wishListPage = new WishListPage(driver);
		wishListPage = wishListPage.clickDeleteProductFromWishList("iPhone");
		wishListPage = wishListPage.clickDeleteProductFromWishList("MacBook");
		wishListPage = wishListPage.clickDeleteProductFromWishList("Canon EOS 5D");
		// MyAccountPage myAccountPage = new MyAccountPage(driver);
		// logIn(driver);
		// HomePage homePage = new HomePage(driver);
		// homePage.clickWishList();
		// Thread.sleep(500);
		// WishListPage wishListPage = new WishListPage(driver);
		// wishListPage.clickDeleteButton(product.getName());
		//
		// Check
		//
		//
		// Return to previous state
		//
		driver.quit();
	}
	
	public void logIn(WebDriver driver) {
		driver.findElement(By.cssSelector(".caret")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("mfj14401@sqoai.com");
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys("qwerty123456");
		driver.findElement(By.cssSelector(".btn.btn-primary:not(a)")).click();		

		//this.isLoggedIn = true;
	}
}
