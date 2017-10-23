package siteOpenCart;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import siteOpenCart.precondition.PreconditionUserLogin;

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
    public void preconditionForTest() {
        driver.get("http://server7.pp.ua/index.php?route=product/product&path=57&product_id=49");
        driver.findElement(By.xpath("html/body/div[2]/div/div/div/div[1]/ul[2]/li[2]/a")).click();
    }

    @Test
    public void onlyName() {
        driver.findElement(By.id("input-name")).clear();
        driver.findElement(By.id("input-name")).click();
        driver.findElement(By.id("input-name")).sendKeys("Name");

        driver.findElement(By.id("input-review")).clear();

        driver.findElement(By.id("button-review")).sendKeys(Keys.ENTER);

        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.className("alert")));
        Assert.assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed());
    }

    @Test
    public void onlyReview() {
        driver.findElement(By.id("input-name")).clear();

        driver.findElement(By.id("input-review")).clear();
        driver.findElement(By.id("input-review")).click();
        driver.findElement(By.id("input-review")).sendKeys("Input valid review there.");

        driver.findElement(By.id("button-review")).sendKeys(Keys.ENTER);

        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.className("alert")));
        Assert.assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed());
    }

    @Test
    public void onlyRating() {
        driver.findElement(By.id("input-name")).clear();
        driver.findElement(By.id("input-review")).clear();

        driver.findElement(By.xpath("html/body/div[2]/div/div/div/div[1]/div/div[2]/form/div[4]/div/input[4]")).click();

        driver.findElement(By.id("button-review")).sendKeys(Keys.ENTER);

        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.className("alert")));

        Assert.assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed());
    }

    @Test
    public void blankReviewForm() {
        driver.findElement(By.id("input-name")).clear();
        driver.findElement(By.id("input-review")).clear();

        driver.findElement(By.id("button-review")).sendKeys(Keys.ENTER);

        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.className("alert")));
        Assert.assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed());
    }
}
