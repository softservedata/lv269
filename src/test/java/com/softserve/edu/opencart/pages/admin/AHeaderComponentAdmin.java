package com.softserve.edu.opencart.pages.admin;

import com.softserve.edu.opencart.data.pathnames.IPathnames;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.TagAttribute;
import com.softserve.edu.opencart.tools.*;
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
    protected Search search;

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

    public AHeaderComponentAdmin() {
        this.search = Application.get().search();
        sBarPanel = search.id("menu");
        logo = search.className("navbar-brand");
        statBtn = search.xpath(".//a[child::i[@class='fa fa-bell fa-lg']]");
        toStoreBtn = search.xpath(".//a[child::i[@class='fa fa-home fa-lg']]");
        helpBtn = search.xpath(".//a[child::i[@class='fa fa-life-ring fa-lg']]");
        logoutBtn = search.xpath(".//a[child::i[@class='fa fa-sign-out fa-lg']]");
        currentPageName = search.cssSelector(".page-header > .container-fluid > h1");
        pathnamePageBtns = search.cssSelectors(".breadcrumb > li > a");
        setSBarMainOptionsList();

    }

    private void setSBarMainOptionsList() {
        sBarMainOptionsList = new ArrayList<>();
        List <WebElement> temp = search.xpaths(MAIN_OPTIONS_LIST_XPTH, sBarPanel);
        for (WebElement current : search.xpaths(MAIN_OPTIONS_LIST_XPTH, sBarPanel)) {
            sBarMainOptionsList.add(new SBarMainOption(current));
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

    public WebElement getsBarPanel() {
        return sBarPanel;
    }

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
        Operations.clickElement(getLogo());
    }

    public void clickLogoutBtn() {
        Operations.clickElement(getLogoutBtn());
    }

    //Set Function
    public void clickToStoreBtn() {
        Operations.clickElement(getToStoreBtn());
        toStoreOptionsList = (toStoreOptionsList == null) ? new OptionsList(toStoreBtn) : null;
    }

    public void clickStatBtn() {
        Operations.clickElement(getStatBtn());
        statOptionsList = (statOptionsList == null) ? new StatOptionsList(statBtn) : null;
    }

    public void clickHelpBtn() {
        Operations.clickElement(getHelpBtn());
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
        sBarPathnames = (sBarPathnames.size() == 0) ? null : sBarPathnames;
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
        Operations.clickElement(getPathnamePageBtnLast());
    }

    public void clickPathnamePageBtnFirst() {
        Operations.clickElement(getPathnamePageBtnFirst());
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
            optionsList = search.cssSelectors(OPTION_LOCATOR, parentBtn);
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
            Operations.clickElement(getOptionByPartialName(value));
        }


    }

    //-------------------------------------------------------------------------------
    private class StatOptionsList extends OptionsList {

        private final String OPTION_AMOUNT_TEXT_CSS = "span";

        public StatOptionsList(WebElement parentBtn) {
            super(parentBtn);
        }

        public int getOptionAmountByPartialName(String value) {
            return NumberUtils.stringToInt(search.cssSelector(OPTION_AMOUNT_TEXT_CSS, getOptionByPartialName(value))
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


        public SBarMainOption(WebElement parentElement) {
            this.parentElement = parentElement;
            setOptionText();
        }

        protected void setOptionTextSelector() {
            optionTextSelector = MAIN_OPTION_TEXT_SELECTOR_CSS;
        }

        public void setOptionText() {
            setOptionTextSelector();
            optionText = search.cssSelector(optionTextSelector, parentElement)
                    .getAttribute(TagAttribute.TEXT_CONTENT.toString());
        }

        private void setOptionBtn() {
            //TODO clear magic text
            optionBtn = search.xpath("./a", parentElement);
        }

        private void setOptionSubOptionsList() {

            optionSubOptionsList = new ArrayList<>();
            for (WebElement current : search.xpaths(SUB_OPTIONS_LIST_SELECTOR_XPTH, parentElement)) {
                SBarOption currentSBarOption = new SBarOption(current);
//                currentSBarOption.setOptionText(current);
                optionSubOptionsList.add(currentSBarOption);
//            optionSubOptionsList = new ArrayList<>();
//            for (WebElement current : search.findElementsInsideElement(parentElement,
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
            Operations.clickElement(getOptionBtn());
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
                super(parentElement);
            }

            @Override
            protected void setOptionTextSelector() {
                optionTextSelector = SUB_OPTION_TEXT_SELECTOR_CSS;
            }
        }

    }

    //-------------------------------------------------------------------------------

    //Business Logic

    public ProductAdminPage openProductAdminPage(IPathnames pathnames) {
        checkSBarPathnames(pathnames.getsBarPathnamesList());
        clickSBarOptionByPathname(sBarPathnames.get(0));
        return new ProductAdminPage();
    }

    public SettingPage openSettingAdminPage(IPathnames pathnames) {
        checkSBarPathnames(pathnames.getsBarPathnamesList());
        clickSBarOptionByPathname(sBarPathnames.get(0));
        return new SettingPage();
    }
}



