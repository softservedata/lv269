package com.softserve.edu.opencart.tests.smoke;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Test001 {

	private static WebDriver driver;
	@Test
    public void checkProduct(){
        //
        // Precondition
        //
    	
    	System.setProperty("webdriver.gecko.driver", "C://selenium/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://server7.pp.ua/");
		driver.findElement(By.cssSelector(".list-inline > li > a.dropdown-toggle")).click();
		driver.findElement(By.cssSelector(".dropdown-menu.dropdown-menu-right>li>a")).click();
		driver.findElement(By.id("input-firstname")).click();
		driver.findElement(By.id("input-firstname"))
		driver.findElement(By.cssSelector("#content>p>a")).click();
		
       
        driver.quit();
    }
	
}
