//package com.softserve.edu.opencart.pages.admin;
//
//public class temp {
////    private class SBarAdmin {
////
////        //Field
////        private List<OptionsList> mainSBarOptionsList;
////        private By sBarIconFoldLocator;
////        private WebElement sBarFoldUnfoldBtn;
////
////
////        public SBarAdmin() {
////            sBarIconFoldLocator = By.className("fa-indent");
////            sBarFoldUnfoldBtn = webDriverManager.findElement(By.id("button-menu"));
////        }
////
////        //Get data
////
////        public List<AHeaderComponentAdmin.OptionsList> getMainSBarOptionsList() {
////            return mainSBarOptionsList;
////        }
////
////        public WebElement getsBarFoldUnfoldBtn() {
////            return sBarFoldUnfoldBtn;
////        }
////
////        //Get Functional
////
////        public boolean IsSBarFold() {
////            return (webDriverManager.findElements(sBarIconFoldLocator).size() > 0);
////        }
////
////        //Set data
////
////        public void switchFoldUnfoldSBar() {
////            webDriverManager.clickElement(sBarFoldUnfoldBtn);
////        }
////
////        //SetFunctional
////
////        private void setMainSBarOptionsList() {
////            List<WebElement> sBarOptionsElement = webDriverManager.findElementsInsideElement(
////                    sBarPanel, By.xpath(MAIN_OPTIONS_SELECTOR_XPTH));
////            mainSBarOptionsList = new ArrayList<>();
////            for (WebElement current : sBarOptionsElement) {
////                mainSBarOptionsList.add(new AHeaderComponentAdmin.OptionsList(current));
////            }
////        }
////
////        public void clickOptionByPartialName(String value) {
////            List<String> optionsPathname = TextUtils.splittoList(value, "/");
////            ErrorUtils.createCustomException((optionsPathname.size() == 0), "No such object");
////            optionsPathname.remove(0);
////            getElementByPartialName(optionsPathname.toString(0)).option | Chosen(optionsPathname);
////        }
////
////        private AHeaderComponentAdmin.OptionsList getElementByPartialName(String value) {
////            AHeaderComponentAdmin.OptionsList result = null;
////            for (AHeaderComponentAdmin.OptionsList current : mainSBarOptionsList) {
////                if (current.isOptionContainsText(value)) {
////                    result = current;
////                    break;
////                }
////            }
////            return result;
////        }
////
////        //----------------------------------------------------------
////        private class SBarMainOptionsList {
////            private final String MAIN_OPTION_TEXT_SELECTOR_CSS = "a > span";
////            private final String OPTION_BTN_SELECTOR_TAG = "a";
////            private final String MAIN_OPTIONS_LIST_XPTH = "./li";
////
////            //Fields
////            private List<SBarOptionsList> currentOptionSubOptionsList;
////
////            public SBarMainOptionsList(WebElement parentElement) {
////                private void setOptionsSelector(boolean isMainOptionsList) {
////                    currentOptionSubOptionsListSelector = (isMainOptionsList) ? MAIN_OPTIONS_LIST_XPTH : SUB_OPTIONS_LIST_XPTH;
////                    currentOptionTextSelector = (isMainOptionsList) ? MAIN_OPTION_TEXT_SELECTOR_CSS : SUB_OPTION_TEXT_SELECTOR_CSS;
////                }
////                setSubOptionsParameters (parentElement);
////                setOptionsSelector(isMainOptionsList);
////
////                setCurrentOptionText(parentElement);
////                setCurrentOptionBtn(parentElement);
////            }
////
////            private void setSubOptionsParameters(WebElement parentElement) {
////                currentOptionSubOptionsList = new ArrayList<>();
////                for (WebElement current: webDriverManager.findElementsInsideElement(parentElement, By))
////
////                    setCurrentOptionSubOptionsList(parentElement);
////            }
////
////        }
////    }
////
////    private class SBarOptionsList {
////
////        private final String MAIN_OPTION_TEXT_SELECTOR_CSS = "a > span";
////
////
////
////
////        private final String MAIN_OPTIONS_LIST_XPTH = "./li";
////
////
////
////        //Fields
////        private String currentOptionSubOptionsListSelector;
////        private String currentOptionTextSelector;
////        private String currentOptionText;
////        private WebElement currentOptionBtn;
////        private List<SBarOptionsList> currentOptionSubOptionsList;
////
////
////        public SBarOptionsList(WebElement parentElement, boolean isMainOptionsList) {
////            setOptionsSelector(isMainOptionsList);
////            setCurrentOptionSubOptionsList(parentElement);
////            setCurrentOptionText(parentElement);
////            setCurrentOptionBtn(parentElement);
////        }
////
////        private void setOptionsSelector(boolean isMainOptionsList) {
////            currentOptionSubOptionsListSelector = (isMainOptionsList) ? MAIN_OPTIONS_LIST_XPTH : SUB_OPTIONS_LIST_XPTH;
////            currentOptionTextSelector = (isMainOptionsList) ? MAIN_OPTION_TEXT_SELECTOR_CSS : SUB_OPTION_TEXT_SELECTOR_CSS;
////        }
////
////        private void setCurrentOptionSubOptionsList(WebElement parentElement) {
////            currentOptionSubOptionsList = new ArrayList<>();
////            for (WebElement current : webDriverManager.findElementsInsideElement(parentElement,
////                    By.xpath(currentOptionSubOptionsListSelector))) {
////                currentOptionSubOptionsList.add(new SBarOptionsList(current, false));
////            }
////        }
////
////        private void setCurrentOptionText(WebElement parentElement) {
////            currentOptionText = webDriverManager.findElementInsideElement(parentElement,
////                    By.cssSelector(currentOptionTextSelector)).getText();
////        }
////
////        private void setCurrentOptionBtn(WebElement parentElement) {
////            currentOptionBtn = webDriverManager.findElementInsideElement(parentElement,
////                    By.tagName(OPTION_BTN_SELECTOR_TAG));
////        }
////
////        private boolean isOptionContainsText(String text) {
////            return parentOptionText.toLowerCase().contains(text.toLowerCase());
////        }
////
////        public void clickSubOptionByPartialName(List<String> subOptionsPathname) {
////            if (subOptionsPathname.size() == 0) {
////                clickOptionElement();
////            }
////        }
////
////        private void clickOptionElement() {
////            webDriverManager.clickElement(parentOption);
////        }
////    }
//
//}
