package server7.testng;


import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.reporters.jq.Main;
import server7.testng.Pages.MainAdmPg;
import server7.testng.Pages.MainPg;

/**
 * This class checks login (using buttons and Enter) and logout
 * process on Chrome.
 */
public class ChromeLoginLogoutAdminTest {

    public WebDriverCreator webDriverCreator;

    @DataProvider
    public Object[][] TypeOfEntrance () {
        return new Object[][] {
                {Credentials.BUTTON.getChosenConstant()},
                {Credentials.BUTTON.getChosenConstant()},
        };
    }

    @BeforeClass
    public void createDrivers() {
        webDriverCreator = new WebDriverCreator();
        webDriverCreator.setWebdriverChrome();
    }

    @BeforeMethod
    public void setMainPage() {
        new MainPg(webDriverCreator).setMainPage();
    }

    @Test(dataProvider = "TypeOfEntrance")
    public void LoginChromeTest(String typeOfEntrance) {
        new MainPg(webDriverCreator).loginIfOpened(typeOfEntrance);
        Assert.assertTrue(new MainAdmPg(webDriverCreator).isOpened(),
                Messages.FAIL_LOGIN_ADMIN_CHROME_CLICK.getMessage());
        new MainAdmPg(webDriverCreator).logout();
        Assert.assertTrue(new MainPg(webDriverCreator).isOpened(),
                Messages.FAIL_LOGOUT_ADMIN_CHROME_CLICK.getMessage());
    }

    @AfterClass
    public void driverQuit() {
        webDriverCreator.quitDriver();
    }

}