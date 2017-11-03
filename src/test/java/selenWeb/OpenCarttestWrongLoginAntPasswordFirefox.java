import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class OpenCarttestWrongLoginAntPasswordFirefox {

    private static final String WRONGEMAIL = "wrongemail1@ukr.net";
    private static WebDriver driver;
    private static Connection connection = null;
    private static final String FIRSTNAME = "TEST_WRONG_FIRSTNAME";
    private static final String LASTNAME = "TEST__WRONG_LASTNAME";
    private static final String EMAIL = "test_wrong_login@email.com";
    private static final String TELEPHONE = "380511223344";
    private static final String ADDRESS = "TEST_ADDRESS";
    private static final String CITY = "LVIV";
    private static final String POSTCODE = "79000";
    private static final String PASSWORD = "269lv269lv";
    private static final String CONFIRM = "269lv269lv";




    @BeforeClass
    public static void runBrowser() {

        System.setProperty("webdriver.gecko.driver",
                "D:/Eclipse/geckodriver-v0.19.0-win64/geckodriver.exe");

        driver = new FirefoxDriver();

    }

    @AfterClass
    public static void closeWebDriver() {
        driver.quit();
    }

    @Test
    public void wrongLoginMozilla() {

        driver.get("http://server7.pp.ua/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.partialLinkText("My Account")).click();

        driver.findElement(By.linkText("Login")).click();


        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(WRONGEMAIL);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(PASSWORD);

        driver.findElement(By.xpath("//*[@type='submit'] [@value='Login'] [@class='btn btn-primary']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.",
                driver.findElement(By.xpath("//*[@class='alert alert-danger']")).getText());

    }


    @Test
    public void wrongPasswordMozilla() {

        driver.get("http://server7.pp.ua/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.partialLinkText("My Account")).click();

        driver.findElement(By.linkText("Login")).click();


        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(EMAIL);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(WRONGEMAIL);

        driver.findElement(By.xpath("//*[@type='submit'] [@value='Login'] [@class='btn btn-primary']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.",
                driver.findElement(By.xpath("//*[@class='alert alert-danger']")).getText());


    }


}
