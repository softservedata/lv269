package com.softserve.edu;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RandomInput {
    
	private List<String> testData = new ArrayList<String>();
	
	@Before
	public void setUpTestData() {
		 RandomString rs = new RandomString();
		 
		 for(int i = 0; i < 30; i++){
			 testData.add(rs.nextString());
		 }
	}
	
	@Test	
    public void testSearchCriteria() {
		System.setProperty("webdriver.chrome.driver",
	            "C:/Program Files/Java/Selenium360/chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	for (String dataInput : testData){		
            driver.get("http://lv-269new.freecluster.eu");
       
            driver.findElement(By.name("search")).clear();
            driver.findElement(By.name("search")).click();
            driver.findElement(By.name("search")).sendKeys(dataInput + Keys.ENTER);
         
            Assert.assertEquals(driver.findElement(By.id("input-search")).
            		getAttribute("value"), dataInput);
    	}
    	driver.quit();  	
    }

}
