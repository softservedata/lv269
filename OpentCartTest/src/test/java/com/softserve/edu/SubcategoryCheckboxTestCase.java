package com.softserve.edu;

import org.junit.After;
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

public class SubcategoryCheckboxTestCase {
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
		testData = Arrays.asList("Magic Mouse 2", "MAGIC MOUSE", "mOUse",
				"mouse", "ous", "2");
		System.setProperty("webdriver.chrome.driver",
	            "C:/Program Files/Java/Selenium360/chromedriver.exe"); 
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://server7.pp.ua/index.php?route=product/search");      
        /*
         * Select 'Components' category. Submit subcategory checkbox
         */
		driver.findElement(By.name("category_id")).click();
        driver.findElement(By.xpath("//select[@name = 'category_id']/option[@value = '25']")).click();
        driver.findElement(By.name("sub_category")).click();
        /*
         * Enter all the test data into field 'Search' and check it works
         */
    	for (String dataInput : testData){		
    		driver.findElement(By.id("input-search")).clear();
            driver.findElement(By.id("input-search")).click();
            driver.findElement(By.id("input-search")).sendKeys(dataInput + Keys.ENTER);
             
            driver.findElement(By.id("button-search")).click();
              Assert.assertTrue("Search not displays requested product!", 
            		driver.findElement(By.xpath(
            		"//div[@class = 'product-thumb']//*[contains(text(), "
            		+ "'Magic Mouse 2')]")).isDisplayed());            
    	}
    	driver.quit();  	
	}
}
