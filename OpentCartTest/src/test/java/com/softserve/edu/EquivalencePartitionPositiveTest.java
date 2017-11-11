package com.softserve.edu;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class EquivalencePartitionPositiveTest {
		
	@Before
	public void setUpTestData() {
		System.setProperty("webdriver.chrome.driver", 
				"C:/Program Files/Java/Selenium360/chromedriver.exe");
		WebDriver createTestProduct = new ChromeDriver();
		createTestProduct.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		createTestProduct.get("http://server7.pp.ua/admin/");
		/*
		 * login as Admin
		 */
		createTestProduct.findElement(By.id("input-username")).clear();
		createTestProduct.findElement(By.id("input-username")).click();
		createTestProduct.findElement(By.id("input-username")).sendKeys("admin");

		createTestProduct.findElement(By.id("input-password")).clear();
		createTestProduct.findElement(By.id("input-password")).click();
		createTestProduct.findElement(By.id("input-password")).sendKeys("269lv269lv" + Keys.ENTER);
		/*
		 * Search for ProductAdd page to add new test product
		 */
		createTestProduct.findElement(By.xpath("//li[@id = 'menu-catalog']")).click();
		createTestProduct.findElement(By.xpath("//li[@id = 'menu-catalog']/ul/li[.//text() = 'Products']")).click();
		createTestProduct.findElement(By.xpath("//i[@class='fa fa-plus']")).click();
		/*
		 * Add name of test product
		 */
		createTestProduct.findElement(By.id("input-name1")).clear();
		createTestProduct.findElement(By.id("input-name1")).click();
		createTestProduct.findElement(By.id("input-name1")).sendKeys("Magic Mouse 2");
		/*
		 * Add description of test product
		 */
		createTestProduct
				.findElement(By.xpath("//div[@class = 'note-editor note-frame panel "
						+ "panel-default']//div[@class ="
						+ " 'note-editable panel-body']"))
				.clear();
		createTestProduct
				.findElement(By.xpath("//div[@class = 'note-editor note-frame panel "
						+ "panel-default']//div[@class = "
						+ "'note-editable panel-body']"))
				.click();
		createTestProduct
				.findElement(By.xpath("//div[@class = 'note-editor note-frame panel "
						+ "panel-default']//div[@class = "
						+ "'note-editable panel-body']"))
				.sendKeys("This is test product. " + "Don't buy it! DoYouSearchInDescription ?");
		/*
		 * Add meta data of test product
		 */
		createTestProduct.findElement(By.id("input-meta-title1")).clear();
		createTestProduct.findElement(By.id("input-meta-title1")).click();
		createTestProduct.findElement(By.id("input-meta-title1")).sendKeys("DoYouSearchInDescription");
		/*
		 * Add model of test product
		 */
		createTestProduct.findElement(By.xpath("//ul[@class = 'nav nav-tabs']"
				+ "//li[.//text() = 'Data']")).click();
		createTestProduct.findElement(By.id("input-model")).click();
		createTestProduct.findElement(By.id("input-model")).sendKeys("Magic");
		/*
		 * Add category 'Mice and Trackballs' for test product
		 */
		createTestProduct.findElement(By.xpath("//ul[@class = 'nav nav-tabs']//li[.//text() = 'Links']")).click();
		createTestProduct.findElement(By.id("input-category")).click();
		createTestProduct.findElement(By.id("input-category")).sendKeys("Mice");	
		WebDriverWait wait = new WebDriverWait(createTestProduct, 30);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@id = 'tab-links']//"
				+ "ul[@class = 'dropdown-menu']/li[@data-value='29']")));
		element.click();
		/*Save*/	
		createTestProduct.findElement(By.xpath("//div[@class = 'pull-right']/button[@class = "
				+ "'btn btn-primary']")).click();
		/*
		 * Log out
		 */
		createTestProduct.findElement(By.xpath
				("//header[@id = 'header']/ul[@class = 'nav pull-right']/li[.//text() = 'Logout']")
				).click();
		createTestProduct.quit();
	}
	
	@After
	public void tearDownTestData() {
		System.setProperty("webdriver.chrome.driver", "C:/Program Files/Java/Selenium360/chromedriver.exe");
		WebDriver deleteTestProduct = new ChromeDriver();
		deleteTestProduct.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		deleteTestProduct.get("http://server7.pp.ua/admin/");
		/*
		 * login as Admin
		 */
		deleteTestProduct.findElement(By.id("input-username")).clear();
		deleteTestProduct.findElement(By.id("input-username")).click();
		deleteTestProduct.findElement(By.id("input-username")).sendKeys("admin");

		deleteTestProduct.findElement(By.id("input-password")).clear();
		deleteTestProduct.findElement(By.id("input-password")).click();
		deleteTestProduct.findElement(By.id("input-password")).sendKeys("269lv269lv" + Keys.ENTER);
		/*
		 * Search for Product page
		 */
		deleteTestProduct.findElement(By.xpath("//li[@id = 'menu-catalog']")).click();
		deleteTestProduct.findElement(By.xpath("//li[@id = 'menu-catalog']/ul/li[.//text() = 'Products']")).click();
		/*
		 * Search for TestProduct and Delete it
		 */
		deleteTestProduct.findElement(By.xpath
				("//table[@class = 'table table-bordered table-hover']//"
						+ "tr[./td/text() = 'Magic Mouse 2']//"
						+ "input[@name = 'selected[]']")).click();
		deleteTestProduct.findElement(By.xpath("//button[@data-original-title = 'Delete']")).click();
		Alert alert = deleteTestProduct.switchTo().alert();
		alert.accept();
		/*
		 * Admin Logout
		 */
		deleteTestProduct.findElement(By.xpath
				("//header[@id = 'header']/ul[@class = 'nav pull-right']/li[.//text() = 'Logout']")
				).click();
		deleteTestProduct.quit();
	}
	
	@Test	
    public void testNumberAndCaseSensitivity() {
		List<String> testData = new ArrayList<String>();
		testData = Arrays.asList("Magic Mouse 2", "MAGIC MOUSE", "mOUse",
				"mouse", "ous", "2");
		System.setProperty("webdriver.chrome.driver",
	            "C:/Program Files/Java/Selenium360/chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	for (String dataInput : testData){		
            driver.get("http://server7.pp.ua");
       
            driver.findElement(By.name("search")).clear();
            driver.findElement(By.name("search")).click();
            driver.findElement(By.name("search")).sendKeys(dataInput + Keys.ENTER);
            Assert.assertTrue("Search not displays requested product!", 
            		driver.findElement(By.xpath(
            		"//div[@class = 'product-thumb']//*[contains(text(), "
            		+ "'Magic Mouse 2')]")).isDisplayed());            
    	}
    	driver.quit();  	
    }
}