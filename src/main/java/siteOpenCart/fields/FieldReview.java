package siteOpenCart.fields;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import siteOpenCart.precondition.PreconditionUserLogin;

import java.util.concurrent.TimeUnit;

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
        driver.get("http://server7.pp.ua/index.php?route=product/product&path=57&product_id=49");
        driver.findElement(By.xpath("html/body/div[2]/div/div/div/div[1]/ul[2]/li[2]/a")).click();
        driver.findElement(By.id("input-name")).clear();
        driver.findElement(By.id("input-name")).click();
        driver.findElement(By.id("input-name")).sendKeys("Name");
        driver.findElement(By.xpath("html/body/div[2]/div/div/div/div[1]/div/div[2]/form/div[4]/div/input[4]")).click();

        driver.findElement(By.id("input-review")).clear();
        driver.findElement(By.id("input-review")).click();
    }

    @Test
    public void notValidShort() {
        driver.findElement(By.id("input-review")).sendKeys("Input is notValid review");
        driver.findElement(By.id("button-review")).sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed());
    }

    @Test
    public void validShort() {
        driver.findElement(By.id("input-review")).sendKeys("Input there valid review.");
        driver.findElement(By.id("button-review")).sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertTrue(driver.findElement(By.className("alert-success")).isDisplayed());
    }

    @Test
    public void validLong() {
        for (int i = 0; i < 10; i++) {
            driver.findElement(By.id("input-review"))
                    .sendKeys("Input there valid Review in lenth 1000 symbals gdhgdhgd fgdfgkdjfgdfj dfkghdfjghdfj dfgdfjghd dfjgdf");
        }
        driver.findElement(By.id("button-review")).sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertTrue(driver.findElement(By.className("alert-success")).isDisplayed());
    }

    @Test
    public void notValidLong() {
        for (int i = 0; i < 10; i++) {
            driver.findElement(By.id("input-review"))
                    .sendKeys("Input there valid Review in lenth 1000 symbals gdhgdhgd fgdfgkdjfgdfj dfkghdfjghdfj dfgdfjghd dfjgdf");
        }
        driver.findElement(By.id("input-review")).sendKeys("1");
        driver.findElement(By.id("button-review")).sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed());
    }

    @Test
    public void onlySpecialCharacters() {
        driver.findElement(By.id("input-review")).sendKeys("+-*/+-*/[]{}()??//.,:^%$#");
        driver.findElement(By.id("button-review")).sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed());
    }

    @Test
    public void onlySpace() {
        driver.findElement(By.id("input-review")).sendKeys("                         ");
        driver.findElement(By.id("button-review")).sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed());
    }
}
