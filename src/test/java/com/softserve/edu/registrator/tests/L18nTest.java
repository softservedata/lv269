package com.softserve.edu.registrator.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.softserve.edu.registrator.pages.ATopComponent.ChangeLanguageFields;
import com.softserve.edu.registrator.pages.LoginPage;
import com.softserve.edu.registrator.pages.LoginPage.LoginPageL10n;

public class L18nTest {
	private WebDriver driver;
	//private SoftAssert softAssert;

	@BeforeClass
	public void beforeClass() {
		System.out.println("@BeforeClass");
		System.setProperty("webdriver.chrome.driver",
				//"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe"
				L18nTest.class.getResource("/lib/chromedriver.exe").getPath().substring(1));
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//softAssert = new SoftAssert();
	}

	@AfterClass
	public void afterClass() {
		System.out.println("@AfterClass");
		driver.quit();
		//softAssert.assertAll();
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("@BeforeMethod");
		driver.get("http://regres.herokuapp.com/login");
	}

	@AfterMethod
	public void afterMethod() throws IOException {
		System.out.println("@AfterMethod");
		//driver.get("http://java.training.local:8080/registrator/logout");
		//softAssert.assertAll(); // SKIPPED CONFIGURATION: @AfterClass afterClass if softAssert.assertAll() throw Exception  
	}

	@DataProvider//(parallel = true)
	public Object[][] localization() {
		return new Object[][] {
            { ChangeLanguageFields.ENGLISH },
			{ ChangeLanguageFields.RUSSIAN },
            //{ ChangeLanguageFields.UKRAINIAN },
			};
	}

	//@Test(dataProvider = "localization")
	public void checkLocalization(ChangeLanguageFields language) throws Exception {
		// Precondition
		// TODO Remove from test
//		WebDriver driver = new FirefoxDriver();
//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		driver.get("http://registrator.herokuapp.com/login");
		//
		// Steps
		LoginPage loginPage = new LoginPage(driver);
		Thread.sleep(2000);
		loginPage = loginPage.changeLanguage(language);
		//
		// Check
		System.out.println("Start Assert LOGIN_LABEL");
		Assert.assertEquals(loginPage.getLoginLabelText(),
				LoginPageL10n.LOGIN_LABEL.getLocalization(language));
		System.out.println("Start Assert PASSWORD_LABEL");
		Assert.assertEquals(loginPage.getPasswordLabelText(),
				LoginPageL10n.PASSWORD_LABEL.getLocalization(language));
				//LoginPageL10n.PASSWORD_LABEL.getLocalization(language)+"1");
		System.out.println("Start Assert SUBMIT_BUTTON");
		Assert.assertEquals(loginPage.getSignintText(),
				LoginPageL10n.SUBMIT_BUTTON.getLocalization(language));
		//
		// MUST BE DELETE
		Thread.sleep(5000);
		//
		// Return to previous state
		//driver.quit();
	}

	@Test(dataProvider = "localization")
	public void checkLocalizationSoftAssert(ChangeLanguageFields language) throws Exception {
		// Precondition
		// TODO Remove from test
//		WebDriver driver = new FirefoxDriver();
//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		driver.get("http://registrator.herokuapp.com/login");
	    //
		SoftAssert softAssert = new SoftAssert();
		//
		// Steps
		LoginPage loginPage = new LoginPage(driver);
		Thread.sleep(1000);
		loginPage = loginPage.changeLanguage(language);
		//
		// Check
		System.out.println("Checking LOGIN_LABEL ...");
		softAssert.assertEquals(loginPage.getLoginLabelText(),
				LoginPageL10n.LOGIN_LABEL.getLocalization(language));
		//
		System.out.println("Checking PASSWORD_LABEL ...");
		softAssert.assertEquals(loginPage.getPasswordLabelText() + " Add ERROR",
				//LoginPageL10n.PASSWORD_LABEL.getLocalization(language));
		        LoginPageL10n.PASSWORD_LABEL.getLocalization(language)+"1", "PASSWORD_LABEL_ERROR");
		//
		System.out.println("Checking SUBMIT_BUTTON ...");
		softAssert.assertEquals(loginPage.getSignintText(),
				LoginPageL10n.SUBMIT_BUTTON.getLocalization(language));
		//
		// MUST BE DELETE
		Thread.sleep(5000);
		if (language == ChangeLanguageFields.ENGLISH) {
		    throw new RuntimeException("Constant ENGLISH found");
		}
		//
		// Return to previous state
		//driver.quit();
		//
		softAssert.assertAll();
	}

}