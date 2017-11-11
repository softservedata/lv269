package com.softserve.edu;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class EquivalencePartitionNegativeTest {
	
	private List<String> testData = new ArrayList<String>();
	
	@Before
	public void setUpTestData() {
		 testData = Arrays.asList("", "0.00", "SELECT* FROM PRODUCTS;", "@", ";", "{", " ", "/", "|" );	 
	}
	
	@Test	
    public void testNoMatches() {
		System.setProperty("webdriver.chrome.driver",
	            "C:/Program Files/Java/Selenium360/chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	for (String dataInput : testData){		
            driver.get("http://server7.pp.ua");
       
            driver.findElement(By.name("search")).clear();
            driver.findElement(By.name("search")).click();
            driver.findElement(By.name("search")).sendKeys(dataInput + Keys.ENTER);
            Assert.assertTrue("Search responces on dangerous input test data!",
            		driver.findElement(By.xpath(
            		"//div[@id = 'content']//p[2][contains(text(), "
            		+ "'no product that matches' )]")).isDisplayed());            
    	}
    	driver.quit();  	
    }
}
