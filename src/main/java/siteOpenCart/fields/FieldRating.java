package siteOpenCart.fields;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import siteOpenCart.precondition.PreconditionUserLogin;
import siteOpenCart.precondition.Util;

/**
 * Test requirement for Raring Field with valid user.
 */
public class FieldRating {

    private static WebDriver driver;

    @BeforeClass
    public static void precondition() {
        driver = PreconditionUserLogin.precondition();
    }

    @AfterClass
    public static void end() {
        PreconditionUserLogin.logOut(driver);
    }

    @Before
    public void preconditionForTest() {
        Util.inputInField(driver.findElement(By.id("input-name"))).sendKeys("Name");
        Util.inputInField(driver.findElement(By.id("input-review"))).sendKeys("Input valid review there.");
    }

    @Test
    public void chooseItem() {
        driver.findElement(By.name("rating")).click();
        driver.findElement(By.id("button-review")).sendKeys(Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.className("alert-success")).isDisplayed());
    }

    @Test
    public void notChooseItem() {
        driver.findElement(By.id("button-review")).sendKeys(Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed());
    }
}
