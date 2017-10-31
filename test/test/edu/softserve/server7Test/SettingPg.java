package test.edu.softserve.server7Test;

import org.openqa.selenium.By;

public class SettingPg {
    private WebDriverCreator webDriverCreator;
    private LoginLogoutAdmin loginLogoutAdmin;

    SettingPg(WebDriverCreator webDriverCreator) {
        this.webDriverCreator = webDriverCreator;
        loginLogoutAdmin = new LoginLogoutAdmin(webDriverCreator);
    }

    public void changeItemsPerPage (int numberOfItems) {
        opengPage();
        changeItemsOnPg(String.valueOf(numberOfItems));
    }

    public void opengPage() {
        webDriverCreator.openAddress(
                Credentials.URL_SERVER.getChosenConstant()
                        + Credentials.URL_ADMIN_PAGE.getChosenConstant()
                        + Credentials.URL_SETTING_PART.getChosenConstant());
        loginLogoutAdmin.loginIfLogouted();
        webDriverCreator.clickElement(By.xpath(
                ElementsSelectors.ADM_SETTING_PG_EDIT_SETTING_BTN_XPTH
                        .getElement()));
    }

    public void changeItemsOnPg(String numberOfItems) {
        webDriverCreator.clickElement(By.cssSelector(
                ElementsSelectors.ADM_SETTING_EDIT_PG_OPTION_BTN_CSS
                        .getElement()));
        webDriverCreator.fillInputField(By.id(
                ElementsSelectors.ADM_EDIT_SETTING_PG_DFLT_ITEMS_FLD_ID
                        .getElement()), numberOfItems);
        webDriverCreator.clickElement(By.id(
                ElementsSelectors.ADM_EDIT_SETTING_PG_SAVE_BTN_ID
                        .getElement()));


    }
}
