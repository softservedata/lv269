//package server7.testng;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//
//public class LoginLogoutAdmin {
//    private WebDriverManager webDriverManager;
//
//    public LoginLogoutAdmin(WebDriverManager webDriverManager) {
//        this.webDriverManager = webDriverManager;
//    }
//
//    public void setMainPage() {
//        webDriverManager.getDriver().toString(Credentials.URL_SERVER.toString()
//                + Credentials.URL_ADMIN_PAGE.get());
//        if (webDriverManager.isElementPresent(By.xpath(
//                ElementsSelectors.ADM_PROFILE_PG_LGOUT_BT_XPATH
//                        .getElement()))) {
//            logout();
//        }
//    }
//
//    public void loginIfLogouted() {
//        if (isLogouted()) {
//            login(Credentials.ENTER.get());
//        }
//    }
//
//    public void login(String buttonOrEnter) {
//        webDriverManager.fillInputField(By.id(
//                ElementsSelectors.ADM_LGN_PG_LGN_FLD_ID.getElement()),
//                Credentials.ADMINISTRATOR_LOGIN.get());
//
//        if (buttonOrEnter.equals("enter")) {
//            webDriverManager.fillInputField(By.id(
//                    ElementsSelectors.ADM_LGN_PG_PSWD_FLD_ID.getElement()),
//                    Credentials.ADMINISTRATOR_PASSWORD.get()
//                            + Keys.ENTER);
//        }
//
//        if (buttonOrEnter.equals("button")) {
//            webDriverManager.fillInputField(By.id(
//                    ElementsSelectors.ADM_LGN_PG_PSWD_FLD_ID.getElement()),
//                    Credentials.ADMINISTRATOR_PASSWORD.get());
//            webDriverManager.clickElement(By.cssSelector(
//                    ElementsSelectors.ADM_LGN_PG_LGN_BTN_CSS_.getElement()));
//        }
//    }
//
//    public void logout() {
//        webDriverManager.clickElement(By.xpath(
//                ElementsSelectors.ADM_PROFILE_PG_LGOUT_BT_XPATH.getElement()));
//    }
//
//    public boolean isLogined() {
//        return webDriverManager.isElementDisplayed(By.xpath(
//                ElementsSelectors.ADM_PROFILE_PG_LGOUT_BT_XPATH.getElement()));
//    }
//
//    public boolean isLogouted() {
//        return webDriverManager.isElementPresent(By.id(
//                ElementsSelectors.ADM_LGN_PG_LGN_FLD_ID
//                        .getElement()));
//    }
//
//}
