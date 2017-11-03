package server7.testng.Pages;


import org.openqa.selenium.By;
import server7.testng.ElementsSelectors;
import server7.testng.WebDriverCreator;

public class DefaultStoreOptionPg {

    private WebDriverCreator webDriverCreator;

    public DefaultStoreOptionPg (WebDriverCreator webDriverCreator) {
        this.webDriverCreator = webDriverCreator;
    }

    public void changeItemsPerPage (int numberOfItems) {
        new SettingPg(webDriverCreator).opengPageByAddress();
        new SettingPg(webDriverCreator).enterDefaultStore();
        openOptionTab();
        changeItemsOnPg(String.valueOf(numberOfItems));
        saveOption();
    }

    public void changeItemsOnPg(String numberOfItems) {
        webDriverCreator.fillInputField(By.id(
                ElementsSelectors.ADM_EDIT_SETTING_PG_DFLT_ITEMS_FLD_ID
                        .getElement()), numberOfItems);
    }

    private void openOptionTab () {
        webDriverCreator.clickElement(By.cssSelector(
                ElementsSelectors.ADM_SETTING_EDIT_PG_OPTION_BTN_CSS
                        .getElement()));
    }

    private void saveOption () {
        webDriverCreator.clickElement(By.id(
                ElementsSelectors.ADM_EDIT_SETTING_PG_SAVE_BTN_ID
                        .getElement()));
    }


}
