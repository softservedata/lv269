package server7.testng.Pages;


import org.openqa.selenium.By;
import server7.testng.Credentials;
import server7.testng.ElementsSelectors;
import server7.testng.WebDriverCreator;

public class SettingPg {
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

    public void enterDefaultStore () {
        webDriverCreator.clickElement(By.xpath(
                ElementsSelectors.ADM_SETTING_PG_EDIT_SETTING_BTN_XPTH
                        .getElement()));
    }

}
