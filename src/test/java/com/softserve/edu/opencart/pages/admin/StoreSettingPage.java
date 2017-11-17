package com.softserve.edu.opencart.pages.admin;

import com.softserve.edu.opencart.pages.TagAttribute;
import com.softserve.edu.opencart.tools.ErrorUtils;
import com.softserve.edu.opencart.tools.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class StoreSettingPage extends AHeaderComponentAdmin {

    private static final String ACTIVE_BTNS_SELECTOR_CSS = "li:not(.active) > a";
    private static final String INACTIVE_BTN_SELECTOR_CSS = ".nav-tabs > li.active > a";
    private static final String NO_SUCH_BTN_MESSAGE = "Element %s not found";
    private static final String BTN_INACTIVE_MESSAGE = "Element %s is not clickable";
    private static final String Tab_OPTIONS_CLASS_ADDITION = "OptionsTab";


    //Fields
    private WebElement saveOptionsBtn;
    private WebElement cancelChangesBtn;

    private WebElement optionsTabBtnsPanel;
    private OptionsTab currentTabOptions;

    StoreSettingPage(WebDriverManager webDriverManager) {
        super(webDriverManager);
        saveOptionsBtn = webDriverManager.findElement(By.xpath("//button[child::i[@class='fa fa-save']]"));
        cancelChangesBtn = webDriverManager.findElement(By.xpath("//a[child::i[@class='fa fa-reply']]"));
        optionsTabBtnsPanel = webDriverManager.findElement(By.className("nav-tabs"));
        currentTabOptions = new OptionsTab();
    }
    //GetData

    public WebElement getSaveOptionsBtn() {
        return saveOptionsBtn;
    }

    public WebElement getCancelChangesBtn() {
        return cancelChangesBtn;
    }

    public WebElement getOptionsTabBtnsPanel() {
        return optionsTabBtnsPanel;
    }

    //GetFunctional

    public WebElement getInactiveOptionsTabBtn() {
        return webDriverManager.findElementInsideElement(getOptionsTabBtnsPanel(),
                By.cssSelector(INACTIVE_BTN_SELECTOR_CSS));
    }

    public List<WebElement> getActiveTabBtns() {
        return webDriverManager.findElementsInsideElement(getOptionsTabBtnsPanel(),
                By.cssSelector(ACTIVE_BTNS_SELECTOR_CSS));
    }

    private WebElement getActiveTabBtnByName(String TabOptionsName) {
        WebElement result = null;
        for (WebElement current : getActiveTabBtns()) {
            if (current.getText().toLowerCase().equals(TabOptionsName.toLowerCase())) {
                result = current;
                break;
            }
        }
        return result;
    }


    //SetData

    public void clickSaveOptionsBtn() {
        webDriverManager.clickElement(getSaveOptionsBtn());
    }

    public void clickCancelChangesBtn() {
        webDriverManager.clickElement(getCancelChangesBtn());
    }

    //Set Functional

    public void actTabBtnByName(String TabBtnName) {
        if (!getInactiveOptionsTabBtn().getText().toLowerCase().equals(TabBtnName.toLowerCase())) {
            ErrorUtils.createElementNotClickableException((getActiveTabBtnByName(TabBtnName) == null),
                    String.format(NO_SUCH_BTN_MESSAGE, TabBtnName));
            webDriverManager.clickElement(getActiveTabBtnByName(TabBtnName));
            currentTabOptions = new OptionsTab();
        }
    }

    // BusinessLogic

    public SettingPage changeOptionByTabNameAndOptionName(String tabName, String optionName, String newData) {
        actTabBtnByName(tabName);
        currentTabOptions.actOptionByName(optionName, newData);
        webDriverManager.clickElement(getSaveOptionsBtn());
        return new SettingPage(webDriverManager);
    }

    public SettingPage changeOptionByTabNameAndOptionName(String tabName, String optionName, boolean newData) {
        actTabBtnByName(tabName);
        currentTabOptions.actOptionByName(optionName, newData);
        webDriverManager.clickElement(getSaveOptionsBtn());
        return new SettingPage(webDriverManager);
    }

    public SettingPage changeOptionByTabNameAndOptionName(String tabName, String optionName,
                                                          Map<String, Boolean> newData) {
        actTabBtnByName(tabName);
        currentTabOptions.actOptionByName(optionName, newData);
        webDriverManager.clickElement(getSaveOptionsBtn());
        return new SettingPage(webDriverManager);
    }

    //----------------------------------------------------------------------

    private class OptionsTab {

        private final String DEFAULT_OPTIONS_SELECTOR_CSS = ".tab-pane.active > div";
        private final String DEFAULT_OPTION_NAME_SELECTOR_CSS = "label";
        //        private final String DEFAULT_OPTION_ACTIVE_ELEMENT_SELECTOR_CSS = "div > *:nth-child(1)";
        private final String DEFAULT_OPTION_ACTIVE_ELEMENT_SELECTOR_CSS = "./div/*[1]";

        private final String OPTIONAL_OPTIONS_SELECTOR_CSS = ".tab-pane.active > fieldset > div";
        private final String OPTIONAL_OPTION_NAME_SELECTOR_CSS = "label > span";
        //        private final String OPTIONAL_OPTION_ACTIVE_ELEMENT_SELECTOR_CSS = "div > *:nth-child(1)";
        private final String OPTIONAL_OPTION_ACTIVE_ELEMENT_SELECTOR_CSS = "./div/*[1]";

        private final String NOT_FOUND_OPTION_MESSAGE = "Option = %s was not found";


        protected String optionsSelectorCss;
        protected String optionActiveElementSelectorXpath;
        protected String optionNameSelectorCss;
        protected List<WebElement> optionsList;


        OptionsTab() {
            setSelectors();
            initOptionsList();
        }

        private void setSelectors() {
            if (webDriverManager.isElementVisible(By.cssSelector(DEFAULT_OPTIONS_SELECTOR_CSS))) {
                optionsSelectorCss = DEFAULT_OPTIONS_SELECTOR_CSS;
                optionActiveElementSelectorXpath = DEFAULT_OPTION_ACTIVE_ELEMENT_SELECTOR_CSS;
                optionNameSelectorCss = DEFAULT_OPTION_NAME_SELECTOR_CSS;
            } else {
                optionsSelectorCss = OPTIONAL_OPTIONS_SELECTOR_CSS;
                optionActiveElementSelectorXpath = OPTIONAL_OPTION_ACTIVE_ELEMENT_SELECTOR_CSS;
                optionNameSelectorCss = OPTIONAL_OPTION_NAME_SELECTOR_CSS;
            }
        }

        private void initOptionsList() {
            optionsList = webDriverManager.findElements(By.cssSelector(optionsSelectorCss));
        }

        //GetData
        private String getOptionName(WebElement option) {
            return webDriverManager.findElementInsideElement(option, By.cssSelector(optionNameSelectorCss)).getText();
        }


        //GetFunctional
        public WebElement getOptionByName(String optionName) {
            WebElement result = null;
            for (WebElement current : optionsList) {
                System.out.println(getActiveElementFromOption(current).getTagName());
                if (getOptionName(current).toLowerCase().equals(optionName.toLowerCase())) {
                    result = current;
                    break;
                }
            }
            ErrorUtils.createElementIsNotDisplayedException((result == null),
                    String.format(NOT_FOUND_OPTION_MESSAGE, optionName));
            return result;
        }

        public WebElement getActiveElementFromOption(WebElement optionElement) {
            return webDriverManager.findElementInsideElement(optionElement,
                    By.xpath(optionActiveElementSelectorXpath));
        }

        public void actOptionByName(String optionName, String data) {
            String activeOptionTagName = getActiveElementFromOption(getOptionByName(optionName)).getTagName();
            if ((activeOptionTagName.toLowerCase().equals(TagAttribute.INPUT.toString()))
                    || (activeOptionTagName.toLowerCase().equals(TagAttribute.TEXTAREA.toString()))) {
                actOptionAsInputField(optionName, data);
            }
            if (activeOptionTagName.toLowerCase().equals(TagAttribute.SELECT.toString())) {
                actOptionAsDropdown(optionName, data);
            }
            if (activeOptionTagName.toLowerCase().equals(TagAttribute.ANCHOR.toString())) {
                actOptionAsImage(optionName, data);
            }
            if (activeOptionTagName.toLowerCase().equals(TagAttribute.LABEL.toString())) {
                actOptionAsRadioBtn(optionName, data);
            }
        }

        public void actOptionByName(String optionName, boolean flag) {
            actOptionAsCheckbox(optionName, flag);
        }

        public void actOptionByName(String optionName, Map<String, Boolean> data) {
            actOptionAsCheckBoxGroup(optionName, data);
        }

        private void actOptionAsCheckBoxGroup(String optionName, Map<String, Boolean> data) {
            //TODO put or remove selection for Key options
        }


        private void actOptionAsCheckbox(String optionName, boolean flag) {
            //TODO action for checkbox
        }

        private void actOptionAsRadioBtn(String optionName, String data) {
            //TODO Label has children input (radio) with text that has to match with data
        }

        private void actOptionAsImage(String optionName, String data) {
            //TODO write method: active element a, it's child img, after click on a 2 buttons appears, for selecting
            //image tab opens
        }

        private void actOptionAsDropdown(String optionName, String data) {
            webDriverManager.selectByVisibleText(new Select(getActiveElementFromOption(getOptionByName(optionName))),
                    data);
        }

        private void actOptionAsInputField(String optionName, String data) {
            webDriverManager.fillInputField(getActiveElementFromOption(getOptionByName(optionName)), data);
        }
    }
}
