package siteOpenCart;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import siteOpenCart.precondition.PreconditionUserLogin;
import siteOpenCart.precondition.Util;

/**
 * Negative tests for site http://server7.pp.ua when User login.
 */
public class NegativeUserLogin {
    private static WebDriver driver;

    @BeforeClass
    public static void precondition() {
        driver = PreconditionUserLogin.precondition();
    }

    @AfterClass
    public static void logOut() {
        PreconditionUserLogin.logOut(driver);
    }

    @Before
    public void met(){
        driver.navigate().refresh();
        driver.findElement(By.partialLinkText("review")).click();
    }

    @Test
    public void onlyName() {
        Util.inputInField(driver.findElement(By.id("input-name"))).sendKeys("Name");

        driver.findElement(By.id("input-review")).clear();

        driver.findElement(By.id("button-review")).sendKeys(Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed());
    }

    @Test
    public void onlyReview() {
        driver.findElement(By.id("input-name")).clear();

        Util.inputInField(driver.findElement(By.id("input-review"))).sendKeys("Input valid review there.");

        driver.findElement(By.id("button-review")).sendKeys(Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed());
    }

    @Test
    public void onlyRating() {
        driver.findElement(By.id("input-name")).clear();
        driver.findElement(By.id("input-review")).clear();

        driver.findElement(By.name("rating")).click();

        driver.findElement(By.id("button-review")).sendKeys(Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed());
    }

    @Test
    public void blankForm() {
        driver.findElement(By.id("input-name")).clear();
        driver.findElement(By.id("input-review")).clear();

        driver.findElement(By.id("button-review")).sendKeys(Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed());
    }
}
