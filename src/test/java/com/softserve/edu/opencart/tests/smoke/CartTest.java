package com.softserve.edu.opencart.tests.smoke;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.pages.user.CartPage;
import com.softserve.edu.opencart.pages.user.HomePage;

public class CartTest {
	
    @DataProvider//(parallel = true)
    public Object[][] orderData() {
        // Read from ...
        return new Object[][] { 
            { "MacBook", 500.00,"$500.00",43 },
            { "iPhone", 101.00,"$101.00",40 },
            { "Canon EOS 5D", 80.00,"$80.00",30 },
            };
    }
    
    @Test(dataProvider = "orderData")
    public void checkProduct(String orderName, double expectedUnitPrice, String expectedTotalPriceText
    		,int idProduct)throws Exception {
        //
        // Precondition
        //
        //System.setProperty("webdriver.chrome.driver",
        //        "D:/eclipse/chromedriver.exe");
    	System.setProperty("webdriver.chrome.driver",
    	                "D:/eclipse/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(2000);
        driver.get("http://server7.pp.ua/index.php?route=account/login");
        Thread.sleep(2000);
        driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("andrjusyk@gmail.com");
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys("lv269");
		driver.findElement(By.cssSelector(".btn.btn-primary:not(a)")).click();
		Thread.sleep(2000);
		driver.get("http://server7.pp.ua/index.php?route=product/product&product_id="+idProduct);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".btn.btn-primary.btn-lg.btn-block"))
				.click();
		Thread.sleep(2000);
        driver.get("http://server7.pp.ua/index.php?route=checkout/cart");
        Thread.sleep(2000);
        
        CartPage cartPage = new CartPage(driver);
        Thread.sleep(2000);
        double actualUnitPrice = cartPage.getUnitPriceAmountByOrderName(orderName);
        String actualTotalPriceText = cartPage.getTotalPriceTextByOrderName(orderName);
       
        //
        // Check
        //
        
        Assert.assertEquals(actualUnitPrice, expectedUnitPrice, 0.001);
        Thread.sleep(1000);
        Assert.assertEquals(actualTotalPriceText, expectedTotalPriceText);
        Thread.sleep(1000);
        //cartPage.clickUpdateByOrderName(orderName);
        Thread.sleep(2000);
        cartPage.clickCouponBtn();
        cartPage.clickCouponAply();
        Thread.sleep(2000);
        cartPage.clickRemoveByOrderName(orderName);
        Thread.sleep(2000);
        cartPage=new CartPage(driver);
        cartPage.clickContinueBtn();
        Thread.sleep(1000);
      
        driver.quit();
    }
}

