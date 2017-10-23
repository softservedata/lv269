package siteOpenCart.fields;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import siteOpenCart.precondition.PreconditionUserLogin;

import java.util.concurrent.TimeUnit;

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
        driver.get("http://server7.pp.ua/index.php?route=product/product&path=57&product_id=49");
        driver.findElement(By.xpath("html/body/div[2]/div/div/div/div[1]/ul[2]/li[2]/a")).click();

        driver.findElement(By.id("input-review")).clear();
        driver.findElement(By.id("input-review")).click();
        driver.findElement(By.id("input-review")).sendKeys("Input valid review there.");

        driver.findElement(By.xpath("html/body/div[2]/div/div/div/div[1]/div/div[2]/form/div[4]/div/input[4]")).click();

        driver.findElement(By.id("input-name")).clear();
        driver.findElement(By.id("input-name")).click();
    }

    @Test
    public void notValidShort(){
        driver.findElement(By.id("input-name")).sendKeys("Na");

        driver.findElement(By.id("button-review")).sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        Assert.assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed());
    }

    @Test
    public void validShort(){
        driver.findElement(By.id("input-name")).sendKeys("Nam");

        driver.findElement(By.id("button-review")).sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertTrue(driver.findElement(By.className("alert-success")).isDisplayed());
    }
    @Test
    public void validLong(){
        driver.findElement(By.id("input-name")).sendKeys("25 symbols for name field");

        driver.findElement(By.id("button-review")).sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertTrue(driver.findElement(By.className("alert-success")).isDisplayed());
    }
    @Test
    public void notValidLong(){
        driver.findElement(By.id("input-name")).sendKeys("26 symbols for nameField 2");

        driver.findElement(By.id("button-review")).sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed());
    }

    @Test
    public void onlySpecialCharacters(){
        driver.findElement(By.id("input-name")).sendKeys("?;+");

        driver.findElement(By.id("button-review")).sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed());
    }

    @Test
    public void onlySpace(){
        driver.findElement(By.id("input-name")).sendKeys("   ");

        driver.findElement(By.id("button-review")).sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed());
    }
}
