package com.softserve.edu.opencart.testng.pages.admin;


import com.softserve.edu.opencart.testng.pages.user.MainPg;
import org.openqa.selenium.By;
import com.softserve.edu.opencart.testng.constants.Credentials;
import com.softserve.edu.opencart.testng.WebDriverManager;

public class SettingPg extends AHeaderComponent {

    final private static String ADM_SETTING_PG_EDIT_SETTING_BTN_XPTH =
            "//a[@class='btn btn-primary'][contains(@href, 'com.softserve.edu.opencart')]"
                    + "[ancestor::table[@class='table table-bordered table-hover']]";
    private WebDriverManager webDriverManager;

    public SettingPg(WebDriverManager webDriverManager) {
        super(webDriverManager);
    }


    public void opengPageByAddress() {
        webDriverManager.openAddress(
                Credentials.URL_SERVER.get()
                        + Credentials.URL_ADMIN_PAGE.get()
                        + Credentials.URL_SETTING_PART.get());
        if (new MainPg(webDriverManager).isOpened()) {
            new MainPg(webDriverManager).loginIfOpened(Credentials.ENTER
                    .get());
        }
    }

    public void enterDefaultStore() {
        webDriverManager.clickElement(By.xpath(
                ADM_SETTING_PG_EDIT_SETTING_BTN_XPTH));
    }

}
