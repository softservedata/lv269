package siteOpenCart.fields;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import siteOpenCart.precondition.PreconditionUserLogin;
import siteOpenCart.precondition.Util;


/**
 * Test requirement for Name Field with valid user.
 */
public class FieldName {
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
        Util.inputInField(driver.findElement(By.id("input-review"))).sendKeys("Input valid review there.");
        driver.findElement(By.name("rating")).click();
    }

    @Test
    public void notValidShort() {
        Util.inputInField(driver.findElement(By.id("input-name"))).sendKeys("Na");

        driver.findElement(By.id("button-review")).sendKeys(Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed());
    }

    @Test
    public void validShort() {
        Util.inputInField(driver.findElement(By.id("input-name"))).sendKeys("Nam");

        driver.findElement(By.id("button-review")).sendKeys(Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.className("alert-success")).isDisplayed());
    }

    @Test
    public void validLong() {
        Util.inputInField(driver.findElement(By.id("input-name"))).sendKeys("25 symbols for name field");

        driver.findElement(By.id("button-review")).sendKeys(Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.className("alert-success")).isDisplayed());
    }

    @Test
    public void notValidLong() {
        Util.inputInField(driver.findElement(By.id("input-name"))).sendKeys("26 symbols for nameField 2");

        driver.findElement(By.id("button-review")).sendKeys(Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed());
    }

    @Test
    public void onlySpecialCharacters() {
        Util.inputInField(driver.findElement(By.id("input-name"))).sendKeys("?;+");

        driver.findElement(By.id("button-review")).sendKeys(Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed());
    }

    @Test
    public void onlySpace() {
        Util.inputInField(driver.findElement(By.id("input-name"))).sendKeys("   ");

        driver.findElement(By.id("button-review")).sendKeys(Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed());
    }
}
