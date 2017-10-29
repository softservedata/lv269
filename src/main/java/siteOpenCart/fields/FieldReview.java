package siteOpenCart.fields;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import siteOpenCart.precondition.PreconditionUserLogin;
import siteOpenCart.precondition.Util;


/**
 * Test requirement for Review Field with valid user.
 */
public class FieldReview {
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
        driver.findElement(By.name("rating")).click();
    }

    @Test
    public void notValidShort() {
        Util.inputInField(driver.findElement(By.id("input-review"))).sendKeys("Input is notValid review");
        driver.findElement(By.id("button-review")).sendKeys(Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed());
    }

    @Test
    public void validShort() {
        Util.inputInField(driver.findElement(By.id("input-review"))).sendKeys("Input there valid review.");
        driver.findElement(By.id("button-review")).sendKeys(Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.className("alert-success")).isDisplayed());
    }

    @Test
    public void validLong() {
        Util.inputInField(driver.findElement(By.id("input-review"))).sendKeys(type1000());
        driver.findElement(By.id("button-review")).sendKeys(Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.className("alert-success")).isDisplayed());
    }

    @Test
    public void notValidLong() {
        Util.inputInField(driver.findElement(By.id("input-review"))).sendKeys(type1000()+"1");

        driver.findElement(By.id("button-review")).sendKeys(Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed());
    }

    private String type1000() {
        String string = "";
        for (int i = 0; i < 10; i++) {
            string += "Input there valid Review in length 1000 symbols gddhgd fgdfgkdjfgdfj dfkghdfjghdfj dfgdfjghd dfjgdfs";
        }
        return string;
    }

    @Test
    public void onlySpecialCharacters() {
        Util.inputInField(driver.findElement(By.id("input-review"))).sendKeys("+-*/+-*/[]{}()??//.,:^%$#");
        driver.findElement(By.id("button-review")).sendKeys(Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed());
    }

    @Test
    public void onlySpace() {
        Util.inputInField(driver.findElement(By.id("input-review"))).sendKeys("                         ");
        driver.findElement(By.id("button-review")).sendKeys(Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed());
    }
}
