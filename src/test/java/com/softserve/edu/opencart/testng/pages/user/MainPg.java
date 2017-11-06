package com.softserve.edu.opencart.testng.pages.user;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import com.softserve.edu.opencart.testng.Credentials;
import com.softserve.edu.opencart.testng.WebDriverCreator;

public class MainPg {
    private enum Selectors {

        ADM_LGN_PG_LGN_FLD_ID("input-username"),
        ADM_LGN_PG_PSWD_FLD_ID("input-password"),
        ADM_LGN_PG_LGN_BTN_CSS_(".btn.btn-primary");
        private String element;

        Selectors(String choice) {
            element = choice;
        }

        public String getElement() {
            return element;
        }
    }

    private WebDriverCreator webDriverCreator;

    public MainPg (WebDriverCreator webDriverCreator) {
        this.webDriverCreator = webDriverCreator;
    }

    public void setMainPage() {
        webDriverCreator.openAddress(Credentials.URL_SERVER.getChosenConstant()
                + Credentials.URL_ADMIN_PAGE.getChosenConstant());
    }

    public void loginIfOpened (String buttonOrEnter) {
        if (isOpened()) {
            login(buttonOrEnter);
        }
    }

    private void login(String buttonOrEnter) {
        webDriverCreator.fillInputField(By.id(
                Selectors.ADM_LGN_PG_LGN_FLD_ID.getElement()),
                Credentials.ADMINISTRATOR_LOGIN.getChosenConstant());

        if (buttonOrEnter.equals("enter")) {
            webDriverCreator.fillInputField(By.id(
                    Selectors.ADM_LGN_PG_PSWD_FLD_ID.getElement()),
                    Credentials.ADMINISTRATOR_PASSWORD.getChosenConstant()
                            + Keys.ENTER);
        }

        if (buttonOrEnter.equals("button")) {
            webDriverCreator.fillInputField(By.id(
                    Selectors.ADM_LGN_PG_PSWD_FLD_ID.getElement()),
                    Credentials.ADMINISTRATOR_PASSWORD.getChosenConstant());
            webDriverCreator.clickElement(By.cssSelector(
                    Selectors.ADM_LGN_PG_LGN_BTN_CSS_.getElement()));
        }
    }

    public boolean isOpened() {
        return webDriverCreator.isElementPresent(By.id(
                Selectors.ADM_LGN_PG_LGN_FLD_ID
                        .getElement()));
    }

}
