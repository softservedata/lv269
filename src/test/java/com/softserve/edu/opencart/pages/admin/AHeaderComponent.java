package com.softserve.edu.opencart.pages.admin;

import com.softserve.edu.opencart.tools.ErrorUtils;
import com.softserve.edu.opencart.tools.NumberUtils;
import com.softserve.edu.opencart.tools.TextUtils;
import com.softserve.edu.opencart.tools.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

abstract class AHeaderComponent {

    private final String MAIN_OPTIONS_LIST_XPTH = "./li";
    private final String INPUT_DATA_IS_EMPTY_MESSAGE = "Input data is empty";
    private final String OPTION_NOT_FOUND_IN_OPTIONS_LIST_MESSAGE
            = "Element with %s name was not found in options list";


    //Fields
    protected WebDriverManager webDriverManager;

    private WebElement sBarPanel;
    private WebElement logo;
    private WebElement statBtn;
    private WebElement toStoreBtn;
    private WebElement helpBtn;
    private WebElement logoutBtn;
    private WebElement currentPageName;
    private Pathname currentPagePathname;

    private OptionsList toStoreOptionsList;
    private StatOptionsList statOptionsList;
    private OptionsList helpOptionsList;
    private List<SBarMainOption> sBarMainOptionsList;

    public AHeaderComponent(WebDriverManager webDriverManager) {
        this.webDriverManager = webDriverManager;
        sBarPanel = webDriverManager.findElement(By.id("menu"));
        logo = webDriverManager.findElement(By.className("navbar-brand"));
        statBtn = webDriverManager.findElement(By.xpath(".//a[child::i[@class='fa fa-bell fa-lg']]"));
        toStoreBtn = webDriverManager.findElement(By.xpath(".//a[child::i[@class='fa fa-home fa-lg']]"));
        helpBtn = webDriverManager.findElement(By.xpath(".//a[child::i[@class='fa fa-life-ring fa-lg']]"));
        logoutBtn = webDriverManager.findElement(By.xpath(".//a[child::i[@class='fa fa-sign-out fa-lg']]"));
        currentPageName = webDriverManager.findElement(By.cssSelector(".page-header > .container-fluid > h1"));
        setPathnameParameters(By.className("breadcrumb"));

        setSBarMainOptionsList();

    }

    private void setSBarMainOptionsList() {
        sBarMainOptionsList = new ArrayList<>();
        for (WebElement current : webDriverManager.findElementsInsideElement(sBarPanel,
                By.xpath(MAIN_OPTIONS_LIST_XPTH))) {
            sBarMainOptionsList.add(new SBarMainOption(current));
        }
    }

    //Page Object

    // Get Data

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

    public OptionsList getToStoreOptionsList() {
        return toStoreOptionsList;
    }

    public StatOptionsList getStatOptionsList() {
        return statOptionsList;
    }

    public OptionsList getHelpOptionsList() {
        return helpOptionsList;
    }

    public List<SBarMainOption> getsBarMainOptionsList() {
        return sBarMainOptionsList;
    }

    public WebElement getCurrentPageName() {
        return currentPageName;
    }

    // Get Functional

    public String getCurrentPageNameText() {
        return getCurrentPageName().getText();
    }


    // set Data
    public void closeStatOptionsList() {
        statOptionsList = null;
    }

    public void closeToStoreOptionsList() {
        toStoreOptionsList = null;
    }

    public void closeHelpOptonsList() {
        helpOptionsList = null;
    }

    private void setPathnameParameters(By parentLocator) {
        setPathnamePageButtons(parentLocator);
        setPathnamePageNames();
    }

    //Function

    public void clickLogo() {
        webDriverManager.clickElement(logo);
    }

    public void clickLogoutBtn() {
        webDriverManager.clickElement(logoutBtn);
    }

    public void clickToStoreBtn() {
        webDriverManager.clickElement(toStoreBtn);
        toStoreOptionsList = (toStoreOptionsList == null) ? new OptionsList(toStoreBtn) : null;
        // TODO  ask why getToStoreButton is necessary public
    }

    public void clickStatBtn() {
        webDriverManager.clickElement(statBtn);
        statOptionsList = (statOptionsList == null) ? new StatOptionsList(statBtn) : null;
        // TODO  ask why getOptionButton is necessary public
    }

    public void clickHelpBtn() {
        webDriverManager.clickElement(helpBtn);
        helpOptionsList = (helpOptionsList == null) ? new OptionsList(helpBtn) : null;
        // TODO ask why getHelpBtn is necessary public, link to other pages
    }

    public AHeaderComponent clickToStoreOptionByPartialName(String value) {
        getToStoreOptionsList().clickOptionByPartialName(value);
        closeToStoreOptionsList();
        // TODO add page class, page to user main if 1 store
        return null;
    }

    public AHeaderComponent clickStatOptionByPartialName(String value) {
        getStatOptionsList().clickOptionByPartialName(value);
        closeStatOptionsList();
        // TODO add page class, to other site
        return null;
    }

    public AHeaderComponent clickHelpOptionByPartialName(String value) {
        getHelpOptionsList().clickOptionByPartialName(value);
        closeHelpOptonsList();
        // TODO add page class, page to user main if 1 store
        return null;
    }

    public int getStatOptionAmountByPartialName(String value) {
        return statOptionsList.getOptionAmountByPartialName(value);
    }

    public void clickSBarOptionByPathname(String pathname) {
        ErrorUtils.createInputDataIsEmptyException(pathname.isEmpty(), INPUT_DATA_IS_EMPTY_MESSAGE);
        List<String> pathnameList = TextUtils.splittoList(pathname, "/");
        SBarMainOption foundOption = getMainSBarOptionByPartialName(pathnameList.get(0));
        pathnameList.remove(0);
        foundOption.actOptionByPathname(pathnameList);
    }

    private SBarMainOption getMainSBarOptionByPartialName(String name) {
        SBarMainOption result = null;
        for (SBarMainOption current : getsBarMainOptionsList()) {
            if (current.getOptionText().toLowerCase().contains(name.toLowerCase())) {
                result = current;
            }
        }
        ErrorUtils.createOptionNotFoundInSBarException((result == null),
                String.format(OPTION_NOT_FOUND_IN_OPTIONS_LIST_MESSAGE, name));
        return result;
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
            optionsList = webDriverManager.findElementsInsideElement(parentBtn,
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
            webDriverManager.clickElement(getOptionByPartialName(value));
        }


    }

    //---------------------------------------------------------------------------------
    private class StatOptionsList extends OptionsList {

        private final String OPTION_AMOUNT_TEXT_CSS = "span";

        public StatOptionsList(WebElement parentBtn) {
            super(parentBtn);
        }

        public int getOptionAmountByPartialName(String value) {
            return NumberUtils.stringToInt(
                    webDriverManager.findElementInsideElement(getOptionByPartialName(value),
                            By.cssSelector(OPTION_AMOUNT_TEXT_CSS))
                            .getText());
        }
    }

    //-------------------------------------------------------------------------------------------
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
            setOptionBtn();
        }

        protected void setOptionTextSelector() {
            optionTextSelector = MAIN_OPTION_TEXT_SELECTOR_CSS;
        }

        public void setOptionText() {
            setOptionTextSelector();
            System.out.println(parentElement);
            System.out.println(optionTextSelector);
            optionText = webDriverManager.findElementInsideElement(parentElement,
                    By.cssSelector(optionTextSelector))
                    .getText();
        }

        private void setOptionBtn() {
            optionBtn = webDriverManager.findElementInsideElement(parentElement, By.tagName(OPTION_BTN_SELECTOR_TAG));
        }

        private void setOptionSubOptionsList() {

            optionSubOptionsList = new ArrayList<>();
            for (WebElement current : webDriverManager.findElementsInsideElement(parentElement,
                    By.xpath(SUB_OPTIONS_LIST_SELECTOR_XPTH))) {
                SBarOption currentSBarOption = new SBarOption (current);
//                currentSBarOption.setOptionText(current);
                optionSubOptionsList.add(currentSBarOption);
//            optionSubOptionsList = new ArrayList<>();
//            for (WebElement current : webDriverManager.findElementsInsideElement(parentElement,
//                    By.xpath(SUB_OPTIONS_LIST_SELECTOR_XPTH))) {
//                sBarMainOptionsList.add(new SBarMainOption(current));
            }
        }

        // Get Data

        public String getOptionText() {
            return optionText;
        }

        public WebElement getOptionBtn() {
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
            webDriverManager.clickElement(getOptionBtn());
        }

        //Set Functional

        public void actOptionByPathname(List<String> pathname) {
            if (pathname.size() == 0) {
                clickOptionBtn();
            } else {
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

    //----------------------------------------------------------------------------


    private void setPathnamePageButtons(By parentLocator) {
        Pathname.pathnamePageBtns = webDriverManager.findElementsInsideElement(parentLocator,
                By.cssSelector(Pathname.PATHNAME_BTN_SELECTOR_CSS));
    }

    private void setPathnamePageNames() {
        Pathname.pathnamePageNames = new ArrayList<>();
        for (WebElement current : Pathname.pathnamePageBtns) {
            Pathname.pathnamePageNames.add(current.getText());
        }
    }

    public List<WebElement> getPathnamePageBtns() {
        return Pathname.pathnamePageBtns;
    }

    public List<String> getPathnamePageNames() {
        return Pathname.pathnamePageNames;
    }

    public WebElement getPathnamePageBtnLast() {
        return getPathnamePageBtns().get(getPathnamePageBtns().size() - 1);
    }

    public WebElement getPathnamePageBtnFirst() {
        return getPathnamePageBtns().get(0);
    }

    public String getPathnamePageNameLast() {
        return getPathnamePageNames().get(getPathnamePageNames().size() - 1);
    }

    public String getPathnamePageNameFirst() {
        return getPathnamePageNames().get(0);
    }

    public void clickPathnamePageBtnLast() {
        webDriverManager.clickElement(getPathnamePageBtnLast());
    }

    public void clickPathnamePageBtnFirst() {
        webDriverManager.clickElement(getPathnamePageBtnFirst());
    }

    private static class Pathname {

        public static final String PATHNAME_BTN_SELECTOR_CSS = "li > a";

        public static List<WebElement> pathnamePageBtns;
        public static List<String> pathnamePageNames;


    }

    //Business Logic

    public LoginAdminPage logoutAdminPage() {
        clickLogoutBtn();
        return new LoginAdminPage(webDriverManager);
    }
}



