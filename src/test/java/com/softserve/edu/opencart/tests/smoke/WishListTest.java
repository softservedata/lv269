package com.softserve.edu.opencart.tests.smoke;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.WishListPage;

public class WishListTest {
	
	@Test
    public void checkWishListPage() throws Exception {
        //
        // Precondition
        //
        System.setProperty("webdriver.chrome.driver",
                "C:/Program Files/Java/Selenium360/chromedriver.exe");
    	WebDriver driver = new ChromeDriver();        
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //
        driver.get("http://server7.pp.ua");
        //
        logIn();
        driver.get("http://server7.pp.ua");            
        //
        // Steps
        //
        HomePage homePage = new HomePage(driver);
        //homePage.clickAddToWishByProductName("iPhone");
        //Thread.sleep(500);
        homePage.clickWishList();
        Thread.sleep(500);
        WishListPage wishListPage = new WishListPage(driver);
        //wishListPage.clickDeleteButton("iPhone");   
        //
        // Check
        //
        //
        // Return to previous state
        //
        driver.quit();
    }
	
	public void logIn() {
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
