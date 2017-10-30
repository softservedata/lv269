package siteOpenCart;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import siteOpenCart.precondition.PreconditionUserLogin;
import siteOpenCart.precondition.Util;


/**
 * Positive tests for site http://server7.pp.ua when User login.
 */
public class PositiveUserLogin {
    private static WebDriver driver;

    @BeforeClass
    public static void precondition() {
        driver = PreconditionUserLogin.precondition();
    }

    @AfterClass
    public static void logOut() {
        PreconditionUserLogin.logOut(driver);
    }

    @Test
    public void validFields() {
        Util.inputInField(driver.findElement(By.id("input-name"))).sendKeys("Name");
        Util.inputInField(driver.findElement(By.id("input-review"))).sendKeys("Input valid review there.");
        driver.findElement(By.name("rating")).click();
        driver.findElement(By.id("button-review")).sendKeys(Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.className("alert-success")).isDisplayed());
    }
}
