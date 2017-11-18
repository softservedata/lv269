package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelenRes {

    @Test
    public void testSelenIde() throws Exception {
        //System.setProperty("webdriver.gecko.driver",
        //        "C:/Program Files/Java/Selenium360/geckodriver.exe");
        //WebDriver driver = new FirefoxDriver();
        //
        System.setProperty("webdriver.chrome.driver",
                "C:/Program Files/Java/Selenium360/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://regres.herokuapp.com/login");
        //
        //Thread.sleep(5000);
        WebElement login = driver.findElement(By.id("login"));
        login.clear();
        login.click();
        //login.sendKeys("admin");
        login.sendKeys("hahaha");
        //
        Thread.sleep(2000);
        // ..
        //driver.navigate().refresh(); // Error for next login.clear();
        //driver.navigate().to("http://www.google.com.ua");
        //Thread.sleep(2000);
        //driver.navigate().back();
        //Thread.sleep(2000);
        //
        login.clear();
        login.click();
        login.sendKeys("admin");
        //
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).click();
        //
        // CODE.
        //
        driver.findElement(By.id("password")).sendKeys("admin");
        //
        //driver.findElement(By.cssSelector(".btn.btn-primary")).click();
        //login.submit();
        login.sendKeys(Keys.ENTER);
        //
        WebElement user = driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm:not(.dropdown-toggle)"));
        Assert.assertEquals("admin", user.getText());
        //
        driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm.dropdown-toggle")).click();
        driver.findElement(By.xpath("//a[contains(@href,'/logout')]")).click();
        //
        Assert.assertTrue(driver.getCurrentUrl().contains("/login?logout"));
        //
        Thread.sleep(2000);
        driver.quit();
    }

}
