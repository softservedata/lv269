package com.softserve.edu.opencart.pages.admin;

import com.softserve.edu.opencart.data.pagination.IPagination;
import com.softserve.edu.opencart.data.pathnames.IPathnames;
import com.softserve.edu.opencart.data.pathnames.IStoreSettingOptionSet;
import com.softserve.edu.opencart.data.pathnames.StoreSettingOptionSet;
import com.softserve.edu.opencart.pages.TagAttribute;
import com.softserve.edu.opencart.tools.ErrorUtils;
import com.softserve.edu.opencart.tools.SearchManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class StoreSettingPage extends AHeaderComponentAdmin {

//TODO create enum
    private static final String ACTIVE_BTNS_SELECTOR_CSS = "li:not(.active) > a";
    private static final String INACTIVE_BTN_SELECTOR_CSS = ".nav-tabs > li.active > a";
    private static final String NO_SUCH_BTN_MESSAGE = "Element %s not found";
    private static final String BTN_INACTIVE_MESSAGE = "Element %s is not clickable";


    //Fields
    private WebElement saveOptionsBtn;
    private WebElement cancelChangesBtn;

    private WebElement optionsTabBtnsPanel;
    private OptionsTab currentTabOptions;

    //TODO remake without static
    private static StoreSettingOptionSet defaultOptionsList;

    StoreSettingPage(SearchManager searchManager) {
        super(searchManager);
        saveOptionsBtn = searchManager.findElement(By.xpath("//button[child::i[@class='fa fa-save']]"));
        cancelChangesBtn = searchManager.findElement(By.xpath("//a[child::i[@class='fa fa-reply']]"));
        optionsTabBtnsPanel = searchManager.findElement(By.className("nav-tabs"));
        currentTabOptions = new OptionsTab();
    }

    public void enterOptionsFromOptionsList(IStoreSettingOptionSet optionList, IPagination paginationData) {
        if (defaultOptionsList == null) {
            enterOptionsFromRecievedOptionsList(optionList, paginationData);
        } else {
            enterOptionsFromDefaultOptionsList();
        }

    }

    //TODO remake all this page, add a good way to change option, to save their current value and return back
    public void enterOptionsFromRecievedOptionsList(IStoreSettingOptionSet optionList, IPagination paginationData) {
        defaultOptionsList = new StoreSettingOptionSet();
        for (StoreSettingOptionSet.IStoreSettingOption currentOption : optionList.getStoreSettingOptionsSetList()) {
            actTabBtnByName(currentOption.getOptionTab());
            if (currentOption.getOptionValue() != null) {
                defaultOptionsList.addStoreSettingOption(currentOption.getOptionName(), currentOption.getOptionTab(),
                        currentTabOptions.getActiveElementValueByName(currentOption.getOptionName()));
                String optionValue = (paginationData.getOptionName().equalsIgnoreCase(currentOption.getOptionName()))
                        ? String.valueOf(paginationData.getItemsPerPageNumber()) : currentOption.getOptionValue();
                currentTabOptions.actOptionByName(currentOption.getOptionName(), optionValue);

            }
            if (currentOption.getOptionFlag() != null) {
                currentTabOptions.actOptionByName(currentOption.getOptionName(), currentOption.getOptionFlag());
            }
            if (currentOption.getOptionFlagsSet() != null) {
                currentTabOptions.actOptionByName(currentOption.getOptionName(), currentOption.getOptionFlagsSet());
            }
        }
    }

    public void enterOptionsFromDefaultOptionsList() {
        for (StoreSettingOptionSet.IStoreSettingOption currentOption : defaultOptionsList.getStoreSettingOptionsSetList()) {
            actTabBtnByName(currentOption.getOptionTab());
            if (currentOption.getOptionValue() != null) {
                currentTabOptions.actOptionByName(currentOption.getOptionName(), currentOption.getOptionValue());
            }
            if (currentOption.getOptionFlag() != null) {
                currentTabOptions.actOptionByName(currentOption.getOptionName(), currentOption.getOptionFlag());
            }
            if (currentOption.getOptionFlagsSet() != null) {
                currentTabOptions.actOptionByName(currentOption.getOptionName(), currentOption.getOptionFlagsSet());
            }
            defaultOptionsList = null;
        }
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
        return searchManager.findElementInsideElement(getOptionsTabBtnsPanel(),
                By.cssSelector(INACTIVE_BTN_SELECTOR_CSS));
    }

    public List<WebElement> getActiveTabBtns() {
        return searchManager.findElementsInsideElement(getOptionsTabBtnsPanel(),
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
        searchManager.clickElement(getSaveOptionsBtn());
    }

    public void clickCancelChangesBtn() {
        searchManager.clickElement(getCancelChangesBtn());
    }

    //Set Functional

    public void actTabBtnByName(String TabBtnName) {
        if (!getInactiveOptionsTabBtn().getText().toLowerCase().equals(TabBtnName.toLowerCase())) {
            searchManager.clickElement(getActiveTabBtnByName(TabBtnName));
        }
        currentTabOptions = new OptionsTab();
    }

    // BusinessLogic

    public SettingPage changeOptionsSet(IPathnames paginationPathnames, IPagination paginationData) {
        enterOptionsFromOptionsList(paginationPathnames.getStoreSettingOptionSet(), paginationData);
        searchManager.clickElement(getSaveOptionsBtn());
        return new SettingPage(searchManager);
    }

    public SettingPage changeOptionByTabNameAndOptionName(String tabName, String optionName, String newData) {
        actTabBtnByName(tabName);
        currentTabOptions.actOptionByName(optionName, newData);
        searchManager.clickElement(getSaveOptionsBtn());
        return new SettingPage(searchManager);
    }

    public SettingPage changeOptionByTabNameAndOptionName(String tabName, String optionName, boolean newData) {
        actTabBtnByName(tabName);
        currentTabOptions.actOptionByName(optionName, newData);
        searchManager.clickElement(getSaveOptionsBtn());
        return new SettingPage(searchManager);
    }

    public SettingPage changeOptionByTabNameAndOptionName(String tabName, String optionName,
                                                          Map<String, Boolean> newData) {
        actTabBtnByName(tabName);
        currentTabOptions.actOptionByName(optionName, newData);
        searchManager.clickElement(getSaveOptionsBtn());
        return new SettingPage(searchManager);
    }

//----------------------------------------------------------------------

    private class OptionsTab {
        //TODO Experimental
        private final String DEFAULT_OPTIONS_SELECTOR_CSS = ".tab-pane.active > div";
        private final String DEFAULT_OPTION_NAME_SELECTOR_CSS = "label";
        private final String DEFAULT_OPTION_ACTIVE_ELEMENT_SELECTOR_CSS = "./div/*[1]";

        private final String OPTIONAL_OPTIONS_SELECTOR_CSS = ".tab-pane.active > fieldset > div";
        private final String OPTIONAL_OPTION_NAME_SELECTOR_CSS = "label > span";
        private final String OPTIONAL_OPTION_ACTIVE_ELEMENT_SELECTOR_CSS = "./div/*[1]";

        private final String NOT_FOUND_OPTION_MESSAGE = "Option = %s was not found";
//TODO Enum

        protected String optionsSelectorCss;
        protected String optionActiveElementSelectorXpath;
        protected String optionNameSelectorCss;
        protected List<WebElement> optionsList;


        OptionsTab() {
            setSelectors();
            initOptionsList();
        }

        private void setSelectors() {
            //TODO Experimental
        if (searchManager.isElementVisible(By.cssSelector(DEFAULT_OPTIONS_SELECTOR_CSS))) {
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
            optionsList = searchManager.findElements(By.cssSelector(optionsSelectorCss));
        }

        //GetData
        private String getOptionName(WebElement option) {
            return searchManager.findElementInsideElement(option, By.cssSelector(optionNameSelectorCss)).getText();
        }


        //GetFunctional
        public WebElement getOptionByName(String optionName) {
            WebElement result = null;
            for (WebElement current : optionsList) {
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
            return searchManager.findElementInsideElement(optionElement,
                    By.xpath(optionActiveElementSelectorXpath));
        }

        public WebElement getActiveElementByName(String optionName) {
            return getActiveElementFromOption(getOptionByName(optionName));
        }

        public String getActiveElementValueByName(String optionName) {
            return getActiveElementByName(optionName).getAttribute("Value");
        }

        //SetData

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
            searchManager.selectByVisibleText(new Select(getActiveElementFromOption(getOptionByName(optionName))),
                    data);
        }

        private void actOptionAsInputField(String optionName, String data) {
            searchManager.fillInputField(getActiveElementFromOption(getOptionByName(optionName)), data);
        }
    }
}
