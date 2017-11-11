package com.softserve.edu;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CategoryUseNegativeCategory {

	@Before
	public void setUpTestData() {
		EquivalencePartitionPositiveTest eppt1 = new EquivalencePartitionPositiveTest();
		eppt1.setUpTestData();
	}

	@After
	public void tearDownTestData() {
		EquivalencePartitionPositiveTest eppt2 = new EquivalencePartitionPositiveTest();
		eppt2.tearDownTestData();
	}
	
	@Test
	public void testCategorysearch(){
		List<String> testData = new ArrayList<String>();
		testData = Arrays.asList("59", "20", "26", "27", "18", "46", "45", "30", "31");
		System.setProperty("webdriver.chrome.driver",
	            "C:/Program Files/Java/Selenium360/chromedriver.exe"); 
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://server7.pp.ua/index.php?route=product/search"); 
		/*
		 * Clear input and type name of existing test product
		 */
		driver.findElement(By.id("input-search")).clear();
        driver.findElement(By.id("input-search")).click();
        driver.findElement(By.id("input-search")).sendKeys("Magic Mouse 2");
        /*
         * Choose all the categories one by one, except 'Mice and Trackballs' 
         * category. Check if system says that nothing found, so our product
         * is not in wrong category.
         */
    	for (String dataInput : testData){           
            driver.findElement(By.name("category_id")).click();
            driver.findElement(By.xpath("//select[@name = 'category_id']/option[@value = "+ 
                     dataInput +"]")).click();
            driver.findElement(By.id("button-search")).click();
            
            Assert.assertTrue("This product must not be in this category!", 
            		driver.findElement(By.xpath(
            		"//div[@id = 'content']//*[contains(text(), "
            		+ "'There is no product that matches')]")).isDisplayed());            
    	}
    	driver.quit();  	
	}
}
