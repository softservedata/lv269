package siteOpenCart;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import siteOpenCart.precondition.PreconditionUserLogin;


/**
 * Positive tests for site http://server7.pp.ua when User login.
 */
public class PositiveUserLogin {
    private static WebDriver driver;

    @BeforeClass
    public static void precondition() {
        driver = PreconditionUserLogin.precondition();
        driver.get("http://server7.pp.ua/index.php?route=product/product&path=57&product_id=49");
        driver.findElement(By.xpath("html/body/div[2]/div/div/div/div[1]/ul[2]/li[2]/a")).click();
    }

    @AfterClass
    public static void logOut() {
        PreconditionUserLogin.logOut(driver);
    }

    @Test
    public void validFields() {
        driver.findElement(By.id("input-name")).clear();
        driver.findElement(By.id("input-name")).click();
        driver.findElement(By.id("input-name")).sendKeys("Name");

        driver.findElement(By.id("input-review")).clear();
        driver.findElement(By.id("input-review")).click();
        driver.findElement(By.id("input-review")).sendKeys("Input valid review there.");

        driver.findElement(By.name("rating")).click();

        driver.findElement(By.id("button-review")).sendKeys(Keys.ENTER);

        Assert.assertTrue(driver.findElement(By.className("alert-success")).isDisplayed());
    }

    @Test
    public void validFieldsAutoName() {
        driver.findElement(By.id("input-review")).clear();
        driver.findElement(By.id("input-review")).click();
        driver.findElement(By.id("input-review")).sendKeys("Input valid review there.");

        driver.findElement(By.name("rating")).click();
        driver.findElement(By.id("button-review")).sendKeys(Keys.ENTER);

        Assert.assertTrue(driver.findElement(By.className("alert-success")).isDisplayed());
    }
}
