package com.softserve.edu.registrator.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.users.IUser;
import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.registrator.pages.LogPage;

public class LogTest {

	@DataProvider //(parallel = true)
	public Object[][] invalidUsers() {
		return new Object[][] {
			{ UserRepository.get().invalid() },
		};
	}

	@Test(dataProvider = "invalidUsers")
	public void checkInvalidLog(IUser invalidUser) throws Exception {
		// Precondition
		//System.setProperty("webdriver.gecko.driver",
		//		LogTest.class.getResource("/lib/geckodriver.exe").getPath().substring(1));
		//WebDriver driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver",
                LogTest.class.getResource("/lib/chromedriver.exe").getPath().substring(1));
        WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
		driver.get("http://regres.herokuapp.com/login");
		//
		// Steps
		LogPage logPage = new LogPage(driver); // 1st item
		//LogPage logPage = PageFactory.initElements(driver, LogPage.class); // 2nd item
		//
		Thread.sleep(2000);
		logPage.setLoginInput("Ha-Ha-Ha");
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		//
		logPage = logPage.unsuccessfulLogin(invalidUser); // Ok
		//
		// Check
		//
		// Return to previous state
		Thread.sleep(2000);
		driver.quit();
	}

}
