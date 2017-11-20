package com.softserve.edu.opencart.tools;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.softserve.edu.opencart.data.applications.IApplicationSource;

public class BrowserWrapper {

    private interface IBrowser {
        WebDriver getBrowser(IApplicationSource applicationSource);
    }

    private static class Firefox5xTemporary implements IBrowser {
        public WebDriver getBrowser(IApplicationSource applicationSource) {
            System.setProperty("webdriver.gecko.driver",
                    applicationSource.getDriverPath());
            return new FirefoxDriver();
        }
    }

    private static class ChromeTemporary implements IBrowser {
        public WebDriver getBrowser(IApplicationSource applicationSource) {
            System.setProperty("webdriver.chrome.driver",
                    applicationSource.getDriverPath());
            return new ChromeDriver();
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public static enum Browsers {
        DEFAULT_TEMPORARY("ChromeTemporary", new ChromeTemporary()),
        FIREFOX5X_TEMPORARY("FireFox5xTemporary", new Firefox5xTemporary()),
        CHROME_TEMPORARY("ChromeTemporary", new ChromeTemporary());
        //
        private String browserName;
        private IBrowser browser;

        private Browsers(String browserName, IBrowser browser) {
            this.browserName = browserName;
            this.browser = browser;
        }

        public WebDriver runBrowser(IApplicationSource applicationSource) {
            return browser.getBrowser(applicationSource);
        }

        @Override
        public String toString() {
            return browserName;
        }

    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    private WebDriver driver;

    public BrowserWrapper(IApplicationSource applicationSource) {
        initWebDriver(applicationSource);
    }

    private void initWebDriver(IApplicationSource applicationSource) {
        Browsers currentBrowser = Browsers.DEFAULT_TEMPORARY;
        for (Browsers browser : Browsers.values()) {
            if (browser.toString().toLowerCase()
                    .contains(applicationSource.getBrowserName().toLowerCase())) {
                currentBrowser = browser;
                break;
            }
        }
        driver = currentBrowser.runBrowser(applicationSource);
        // TODO Move to Search Class
        driver.manage().timeouts().implicitlyWait(applicationSource.getImplicitWaitTimeOut(),
                TimeUnit.SECONDS);
    }

    // TODO Change to default package
    public WebDriver getDriver() {
        return driver;
    }

    public void openUrl(String url) {
        getDriver().get(url);
    }

    public void navigateForward() {
        getDriver().navigate().forward();
    }

    public void navigateBack() {
        getDriver().navigate().back();
    }

    public void refreshPage() {
        getDriver().navigate().refresh();
    }

    public void quit() {
        if (getDriver() != null) {
            getDriver().quit();
            driver = null;
        }
    }

}