package com.softserve.edu.opencart.testng.pages.user;

import com.softserve.edu.opencart.testng.pages.admin.MainAdmPg;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import com.softserve.edu.opencart.testng.constants.Credentials;
import com.softserve.edu.opencart.testng.WebDriverManager;

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

    private WebDriverManager webDriverManager;

    public MainPg (WebDriverManager webDriverManager) {
        this.webDriverManager = webDriverManager;
    }

    public void setMainPage() {
        webDriverManager.openAddress(Credentials.URL_SERVER.get()
                + Credentials.URL_ADMIN_PAGE.get());
    }

    public void loginIfOpened (String buttonOrEnter) {
        if (isOpened()) {
            loginSuccessful(buttonOrEnter);
        }
    }

    private MainAdmPg loginSuccessful(String buttonOrEnter) {
        webDriverManager.fillInputField(By.id(
                Selectors.ADM_LGN_PG_LGN_FLD_ID.getElement()),
                Credentials.ADMINISTRATOR_LOGIN.get());

        if (buttonOrEnter.equals(Credentials.ENTER.get())) {
            webDriverManager.fillInputField(By.id(
                    Selectors.ADM_LGN_PG_PSWD_FLD_ID.getElement()),
                    Credentials.ADMINISTRATOR_PASSWORD.get()
                            + Keys.ENTER);
        }

        if (buttonOrEnter.equals(Credentials.BUTTON.get())) {
            webDriverManager.fillInputField(By.id(
                    Selectors.ADM_LGN_PG_PSWD_FLD_ID.getElement()),
                    Credentials.ADMINISTRATOR_PASSWORD.get());
            webDriverManager.clickElement(By.cssSelector(
                    Selectors.ADM_LGN_PG_LGN_BTN_CSS_.getElement()));
        }
        return new MainAdmPg(webDriverManager);
    }

    public boolean isOpened() {
        return webDriverManager.isElementPresent(By.id(
                Selectors.ADM_LGN_PG_LGN_FLD_ID
                        .getElement()));
    }

}
