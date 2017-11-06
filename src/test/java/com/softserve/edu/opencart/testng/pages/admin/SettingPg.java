package com.softserve.edu.opencart.testng.pages.admin;


import com.softserve.edu.opencart.testng.pages.user.MainPg;
import org.openqa.selenium.By;
import com.softserve.edu.opencart.testng.Credentials;
import com.softserve.edu.opencart.testng.WebDriverCreator;

public class SettingPg {

    final private static String ADM_SETTING_PG_EDIT_SETTING_BTN_XPTH =
            "//a[@class='btn btn-primary'][contains(@href, 'com.softserve.edu.opencart')]"
                    + "[ancestor::table[@class='table table-bordered table-hover']]";
    private WebDriverCreator webDriverCreator;

    public SettingPg(WebDriverCreator webDriverCreator) {
        this.webDriverCreator = webDriverCreator;
    }

    public void opengPageByAddress() {
        webDriverCreator.openAddress(
                Credentials.URL_SERVER.getChosenConstant()
                        + Credentials.URL_ADMIN_PAGE.getChosenConstant()
                        + Credentials.URL_SETTING_PART.getChosenConstant());
        if (new MainPg(webDriverCreator).isOpened()) {
            new MainPg(webDriverCreator).loginIfOpened(Credentials.ENTER
                    .getChosenConstant());
        }
    }

    public void enterDefaultStore() {
        webDriverCreator.clickElement(By.xpath(
                ADM_SETTING_PG_EDIT_SETTING_BTN_XPTH));
    }

}
