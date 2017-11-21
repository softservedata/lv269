package com.softserve.edu.opencart.pages.admin;

import com.softserve.edu.opencart.data.pathnames.IPathnames;
import com.softserve.edu.opencart.pages.TagAttribute;
import com.softserve.edu.opencart.tools.ErrorUtils;
import com.softserve.edu.opencart.tools.NumberUtils;
import com.softserve.edu.opencart.tools.SearchManager;
import com.softserve.edu.opencart.tools.TextUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

abstract class AHeaderComponentAdmin {

    //TODO Enum
    private final String MAIN_OPTIONS_LIST_XPTH = "./li";
    private final String INPUT_DATA_IS_EMPTY_MESSAGE = "Input data is empty";
    private final String OPTION_NOT_FOUND_IN_OPTIONS_LIST_MESSAGE
            = "Element with %s name was not found in options list";
    private final String SBAR_LINK_OPEN_MORE_PATHNAMES_MESSAGE = "Trying to open sBar link more time than pathnames exist";
    private static final String PATHNAME_BTN_SELECTOR_CSS = "li > a";


    //Fields
    protected SearchManager searchManager;

    private WebElement sBarPanel;
    private WebElement logo;
    private WebElement statBtn;
    private WebElement toStoreBtn;
    private WebElement helpBtn;
    private WebElement logoutBtn;
    private WebElement currentPageName;
    private OptionsList toStoreOptionsList;
    private StatOptionsList statOptionsList;
    private OptionsList helpOptionsList;
    private List<SBarMainOption> sBarMainOptionsList;
    private List<WebElement> pathnamePageBtns;

    protected static List<String> sBarPathnames;
    //TODO Change

    public AHeaderComponentAdmin(SearchManager searchManager) {
        this.searchManager = searchManager;
        sBarPanel = searchManager.findElement(By.id("menu"));
        logo = searchManager.findElement(By.className("navbar-brand"));
        statBtn = searchManager.findElement(By.xpath(".//a[child::i[@class='fa fa-bell fa-lg']]"));
        toStoreBtn = searchManager.findElement(By.xpath(".//a[child::i[@class='fa fa-home fa-lg']]"));
        helpBtn = searchManager.findElement(By.xpath(".//a[child::i[@class='fa fa-life-ring fa-lg']]"));
        logoutBtn = searchManager.findElement(By.xpath(".//a[child::i[@class='fa fa-sign-out fa-lg']]"));
        currentPageName = searchManager.findElement(By.cssSelector(".page-header > .container-fluid > h1"));
        pathnamePageBtns = searchManager.findElements(By.cssSelector(".breadcrumb > li > a"));
        setSBarMainOptionsList();

    }

    private void setSBarMainOptionsList() {
        sBarMainOptionsList = new ArrayList<>();
        for (WebElement current : searchManager.findElementsInsideElement(sBarPanel,
                By.xpath(MAIN_OPTIONS_LIST_XPTH))) {
            sBarMainOptionsList.add(new SBarMainOption(current, searchManager));
        }
    }

    //TODO Change next 2 methods
    protected void checkSBarPathnames(List<String> sBarPathnames) {
        if (isSBarPathnamesNull()) {
            this.sBarPathnames = new ArrayList<>();
            this.sBarPathnames.addAll(sBarPathnames);
        }
        ErrorUtils.createWrongParameterSizeException((sBarPathnames.size() == 0), SBAR_LINK_OPEN_MORE_PATHNAMES_MESSAGE);
    }

    protected boolean isSBarPathnamesNull() {
        return (sBarPathnames == null);
    }


    //Page Object

    // Get data

    public WebElement getLogo() {
        return logo;
    }

    public WebElement getStatBtn() {
        return statBtn;
    }

    public WebElement getToStoreBtn() {
        return toStoreBtn;
    }

    public WebElement getHelpBtn() {
        return helpBtn;
    }

    public WebElement getLogoutBtn() {
        return logoutBtn;
    }

    private OptionsList getToStoreOptionsList() {
        return toStoreOptionsList;
    }

    private StatOptionsList getStatOptionsList() {
        return statOptionsList;
    }

    private OptionsList getHelpOptionsList() {
        return helpOptionsList;
    }

    public List<SBarMainOption> getSBarMainOptionsList() {
        return sBarMainOptionsList;
    }

    public WebElement getCurrentPageName() {
        return currentPageName;
    }

    public List<WebElement> getPathnamePageBtns() {
        return pathnamePageBtns;
    }

    public WebElement getPathnamePageBtnLast() {
        return getPathnamePageBtns().get(getPathnamePageBtns().size() - 1);
    }

    public WebElement getPathnamePageBtnFirst() {
        return getPathnamePageBtns().get(0);
    }


    // Get Functional

    public String getCurrentPageNameText() {
        System.out.println(getCurrentPageName().getText());
        return getCurrentPageName().getText();
    }

    public String getPathnameText() {
        String result = "";
        for (WebElement current : getPathnamePageBtns()) {
            result += current.getText();
        }
        return result;
    }

    public String getPathnamePageBtnLastText() {
        return getPathnamePageBtnLast().getText();
    }

    public String getPathnamePageBtnFirstText() {
        return getPathnamePageBtnFirst().getText();
    }

    //Set data
    private void closeStatOptionsList() {
        statOptionsList = null;
    }

    private void closeToStoreOptionsList() {
        toStoreOptionsList = null;
    }

    private void closeHelpOptionsList() {
        helpOptionsList = null;
    }

    public void clickLogo() {
        searchManager.clickElement(logo);
    }

    public void clickLogoutBtn() {
        searchManager.clickElement(logoutBtn);
    }

    //Set Function
    public void clickToStoreBtn() {
        searchManager.clickElement(toStoreBtn);
        toStoreOptionsList = (toStoreOptionsList == null) ? new OptionsList(toStoreBtn) : null;
    }

    public void clickStatBtn() {
        searchManager.clickElement(statBtn);
        statOptionsList = (statOptionsList == null) ? new StatOptionsList(statBtn) : null;
    }

    public void clickHelpBtn() {
        searchManager.clickElement(helpBtn);
        helpOptionsList = (helpOptionsList == null) ? new OptionsList(helpBtn) : null;
    }

    public void clickToStoreOptionByPartialName(String value) {
        if (toStoreOptionsList == null) {
            clickToStoreBtn();
        }
        getToStoreOptionsList().clickOptionByPartialName(value);
    }

    public void clickStatOptionByPartialName(String value) {
        if (statOptionsList == null) {
            clickStatBtn();
        }
        getStatOptionsList().clickOptionByPartialName(value);
    }

    public void clickHelpOptionByPartialName(String value) {
        if (helpOptionsList == null) {
            clickHelpBtn();
        }
        getHelpOptionsList().clickOptionByPartialName(value);
    }

    public int getStatOptionAmountByPartialName(String value) {
        return statOptionsList.getOptionAmountByPartialName(value);
    }

    public void clickSBarOptionByPathname(String pathname) {
        ErrorUtils.createInputDataIsEmptyException(pathname.isEmpty(), INPUT_DATA_IS_EMPTY_MESSAGE);
        List<String> pathnameList = new LinkedList<>();
        pathnameList.addAll(TextUtils.splittoList(pathname, "/"));
        SBarMainOption foundOption = getMainSBarOptionByPartialName(pathnameList.get(0));
        pathnameList.remove(0);
        foundOption.actOptionByPathname(pathnameList);
        //TODO delete after solving problem with pathnames
        sBarPathnames.remove(0);
        sBarPathnames =  (sBarPathnames.size() == 0)? null : sBarPathnames;
    }

    private SBarMainOption getMainSBarOptionByPartialName(String name) {
        SBarMainOption result = null;
        for (SBarMainOption current : getSBarMainOptionsList()) {
            if (current.getOptionText().toLowerCase().contains(name.toLowerCase())) {
                result = current;
                break;
            }
        }
        ErrorUtils.createOptionNotFoundInSBarException((result == null),
                String.format(OPTION_NOT_FOUND_IN_OPTIONS_LIST_MESSAGE, name));
        return result;
    }

    public void clickPathnamePageBtnLast() {
        searchManager.clickElement(getPathnamePageBtnLast());
    }

    public void clickPathnamePageBtnFirst() {
        searchManager.clickElement(getPathnamePageBtnFirst());
    }

//-------------------------------------------------------------------------------

    private class OptionsList {
        private final String OPTION_LOCATOR = "li > a";
        private WebElement parentBtn;
        private List<WebElement> optionsList;

        public OptionsList(WebElement parentBtn) {
            this.parentBtn = parentBtn;
            setOptionsList();
        }

        private void setOptionsList() {
            optionsList = searchManager.findElementsInsideElement(parentBtn,
                    By.cssSelector(OPTION_LOCATOR));
        }

        public WebElement getOptionByPartialName(String value) {
            WebElement result = null;
            for (WebElement current : optionsList) {
                if (current.getText().toLowerCase().contains(value.toLowerCase())) {
                    result = current;
                    break;
                }
            }
            return result;
        }

        public void clickOptionByPartialName(String value) {
            searchManager.clickElement(getOptionByPartialName(value));
        }


    }

    //-------------------------------------------------------------------------------
    private class StatOptionsList extends OptionsList {

        private final String OPTION_AMOUNT_TEXT_CSS = "span";

        public StatOptionsList(WebElement parentBtn) {
            super(parentBtn);
        }

        public int getOptionAmountByPartialName(String value) {
            return NumberUtils.stringToInt(
                    searchManager.findElementInsideElement(getOptionByPartialName(value),
                            By.cssSelector(OPTION_AMOUNT_TEXT_CSS))
                            .getText());
        }
    }

    //-------------------------------------------------------------------------------
    private class SBarMainOption {
        private final String MAIN_OPTION_TEXT_SELECTOR_CSS = "a > span";
        private final String OPTION_BTN_SELECTOR_TAG = "a";
        private final String SUB_OPTIONS_LIST_SELECTOR_XPTH = "./ul/li";

        private final String SUBOPTIONS_LIST_IS_EMPTY_MESSAGE = "Suboptions list is empty";

        //Fields
        protected String optionTextSelector;
        private String optionText;
        private WebElement optionBtn;
        private List<SBarOption> optionSubOptionsList;
        private WebElement parentElement;

        private SearchManager searchManager;

        public SBarMainOption(WebElement parentElement, SearchManager searchManager) {
            this.searchManager = searchManager;
            this.parentElement = parentElement;
            setOptionText();
        }

        protected void setOptionTextSelector() {
            optionTextSelector = MAIN_OPTION_TEXT_SELECTOR_CSS;
        }

        public void setOptionText() {
            setOptionTextSelector();
            optionText = searchManager.findElementInsideElement(parentElement,
                    By.cssSelector(optionTextSelector))
                    .getAttribute(TagAttribute.TEXT_CONTENT.toString());
        }

        private void setOptionBtn() {
            optionBtn = searchManager.findElementInsideElement(parentElement, By.xpath("./a"));
        }

        private void setOptionSubOptionsList() {

            optionSubOptionsList = new ArrayList<>();
            for (WebElement current : searchManager.findElementsInsideElement(parentElement,
                    By.xpath(SUB_OPTIONS_LIST_SELECTOR_XPTH))) {
                SBarOption currentSBarOption = new SBarOption(current);
//                currentSBarOption.setOptionText(current);
                optionSubOptionsList.add(currentSBarOption);
//            optionSubOptionsList = new ArrayList<>();
//            for (WebElement current : searchManager.findElementsInsideElement(parentElement,
//                    By.xpath(SUB_OPTIONS_LIST_SELECTOR_XPTH))) {
//                sBarMainOptionsList.add(new SBarMainOption(current));
            }
        }

        // Get data

        public String getOptionText() {
            return optionText;
        }

        public WebElement getOptionBtn() {
            setOptionBtn();
            return optionBtn;
        }

        public List<SBarOption> getOptionSubOptionsList() {
            return optionSubOptionsList;
        }

        // Get Functional
        private boolean isSubOptionsListEmpty() {
            return (getOptionSubOptionsList().size() == 0);
        }
        //Set

        private void clickOptionBtn() {
            searchManager.clickElement(getOptionBtn());
        }

        //Set Functional

        public void actOptionByPathname(List<String> pathname) {
            clickOptionBtn();
            if (pathname.size() != 0) {
                clickOptionBtn();
                setOptionSubOptionsList();
                SBarOption foundOption = getSubOptionByPartialName(pathname.get(0));
                pathname.remove(0);
                foundOption.actOptionByPathname(pathname);

            }
        }

        private SBarOption getSubOptionByPartialName(String name) {
            ErrorUtils.createSubListIsEmptyException(isSubOptionsListEmpty(), SUBOPTIONS_LIST_IS_EMPTY_MESSAGE);
            SBarOption result = null;
            for (SBarOption current : optionSubOptionsList) {
                if (current.getOptionText().toLowerCase().contains(name.toLowerCase())) {
                    result = current;
                }
            }
            ErrorUtils.createOptionNotFoundInSBarException((result == null),
                    String.format(OPTION_NOT_FOUND_IN_OPTIONS_LIST_MESSAGE, name));
            return result;
        }


        //-----------------------------------------------------------------------------------------
        private class SBarOption extends SBarMainOption {
            private final String SUB_OPTION_TEXT_SELECTOR_CSS = "a";

            public SBarOption(WebElement parentElement) {
                super(parentElement, searchManager);
            }

            @Override
            protected void setOptionTextSelector() {
                optionTextSelector = SUB_OPTION_TEXT_SELECTOR_CSS;
            }
        }

    }

    //-------------------------------------------------------------------------------

    //Business Logic

    public LoginAdminPage logoutAdminPage() {
        clickLogoutBtn();
        return new LoginAdminPage(searchManager);
    }

    public ProductAdminPage openProductAdminPage(IPathnames pathnames) {
        checkSBarPathnames(pathnames.getsBarPathnamesList());
        clickSBarOptionByPathname(sBarPathnames.get(0));
        return new ProductAdminPage(searchManager);
    }

    public SettingPage openSettingAdminPage(IPathnames pathnames) {
        checkSBarPathnames(pathnames.getsBarPathnamesList());
        clickSBarOptionByPathname(sBarPathnames.get(0));
        return new SettingPage(searchManager);
    }
}



