package test.edu.softserve.server7Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class LoginLogoutAdmin {
    private WebDriverCreator webDriverCreator;

    public LoginLogoutAdmin(WebDriverCreator webDriverCreator) {
        this.webDriverCreator = webDriverCreator;
    }

    public void setMainPage() {
        webDriverCreator.getDriver().get(Credentials.URL_SERVER.getChosenConstant()
                + Credentials.URL_ADMIN_PAGE.getChosenConstant());
        if (webDriverCreator.isElementPresent(By.xpath(
                ElementsSelectors.ADM_PROFILE_PG_LGOUT_BT_XPATH
                        .getElement()))) {
            logout();
        }
    }

    public void loginIfLogouted() {
        if (isLogouted()) {
            login(Credentials.ENTER.getChosenConstant());
        }
    }

    public void login(String buttonOrEnter) {
        webDriverCreator.fillInputField(By.id(
                ElementsSelectors.ADM_LGN_PG_LGN_FLD_ID.getElement()),
                Credentials.ADMINISTRATOR_LOGIN.getChosenConstant());

        if (buttonOrEnter.equals("enter")) {
            webDriverCreator.fillInputField(By.id(
                    ElementsSelectors.ADM_LGN_PG_PSWD_FLD_ID.getElement()),
                    Credentials.ADMINISTRATOR_PASSWORD.getChosenConstant()
                            + Keys.ENTER);
        }

        if (buttonOrEnter.equals("button")) {
            webDriverCreator.fillInputField(By.id(
                    ElementsSelectors.ADM_LGN_PG_PSWD_FLD_ID.getElement()),
                    Credentials.ADMINISTRATOR_PASSWORD.getChosenConstant());
            webDriverCreator.clickElement(By.cssSelector(
                    ElementsSelectors.ADM_LGN_PG_LGN_BTN_CSS_.getElement()));
        }
    }

    public void logout() {
        webDriverCreator.clickElement(By.xpath(
                ElementsSelectors.ADM_PROFILE_PG_LGOUT_BT_XPATH.getElement()));
    }

    public boolean isLogined() {
        return webDriverCreator.isElementDisplayed(By.xpath(
                ElementsSelectors.ADM_PROFILE_PG_LGOUT_BT_XPATH.getElement()));
    }

    public boolean isLogouted() {
        return webDriverCreator.isElementPresent(By.id(
                ElementsSelectors.ADM_LGN_PG_LGN_FLD_ID
                        .getElement()));
    }

}
