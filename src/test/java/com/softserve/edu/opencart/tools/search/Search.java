package com.softserve.edu.opencart.tools.search;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.data.applications.IApplicationSource;

public final class Search implements ISearch {

    interface ISearchStrategy {
        ISearch getStrategy();
    }

    static class ImplicitStrategy implements ISearchStrategy {
        public ISearch getStrategy() {
            return new SearchImplicit();
        }
    }

    static class ExplicitStrategyVisible implements ISearchStrategy {
        public ISearch getStrategy() {
            return new SearchExplicitVisible();
        }
    }

    static class ExplicitStrategyPresent implements ISearchStrategy {
        public ISearch getStrategy() {
            return new SearchExplicitPresent();
        }
    }

    static class ExplicitStrategyClickable implements ISearchStrategy {
        public ISearch getStrategy() {
            return new SearchExplicitClickable();
        }
    }

    public static enum SearchStrategies {
        DEFAULT_STRATEGY("SearchImplicitStrategy", new ImplicitStrategy()),
        IMPLICIT_STRATEGY("SearchImplicitStrategy", new ImplicitStrategy()),
        EXPLICIT_STRATEGY_VISIBLE("SearchExplicitStrategyVisible", new ExplicitStrategyVisible()),
        EXPLICIT_STRATEGY_PRESENT("SearchExplicitStrategyPresent", new ExplicitStrategyPresent()),
        EXPLICIT_STRATEGY_CLICKABLE("SearchExplicitStrategyClickable", new ExplicitStrategyClickable());

        private String searchStrategyName;
        private ISearchStrategy searchStrategy;

        private SearchStrategies(String searchStrategyName, ISearchStrategy searchStrategy) {
            this.searchStrategyName = searchStrategyName;
            this.searchStrategy = searchStrategy;
        }

        public ISearch getSearchStrategy() {
            return searchStrategy.getStrategy();
        }

        @Override
        public String toString() {
            return searchStrategyName;
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // Fields

    private ISearch search = new SearchImplicit();

    public Search(IApplicationSource applicationSource) {
        initSearch(applicationSource);
    }

    public void initSearch(IApplicationSource applicationSource) {
        SearchStrategies currentStrategy = SearchStrategies.DEFAULT_STRATEGY;
        for (SearchStrategies strategy : SearchStrategies.values()) {
            if (strategy.toString().toLowerCase().contains(applicationSource
                    .getSearchStrategy().toLowerCase())) {
                currentStrategy = strategy;
                break;
            }
        }
        setStrategy(currentStrategy.getSearchStrategy());
        // System.out.println("\t+++Choosen Strategy: " +
        // currentStrategy.toString());
    }

    // Set Strategy

    public void setImplicitStrategy() {
        setStrategy(new SearchImplicit());
    }

    public void setExplicitVisibleStrategy() {
        setStrategy(new SearchExplicitVisible());
    }

    public void setExplicitPresentStrategy() {
        setStrategy(new SearchExplicitPresent());
    }

    public void setExplicitClickableStrategy() {
        setStrategy(new SearchExplicitClickable());
    }

    private void setStrategy(ISearch search) {
        this.search = search;
    }

    // Get Strategy

    private ISearch getSearch() {
        return search;
    }

    public WebElement getWebElement(By by) {
        return getSearch().getWebElement(by);
    }

    public WebElement getWebElement(By by, WebElement fromWebElement) {
        return getSearch().getWebElement(by, fromWebElement);
    }

    public List<WebElement> getWebElements(By by) {
        return getSearch().getWebElements(by);
    }

    public List<WebElement> getWebElements(By by, WebElement fromWebElement) {
        return getSearch().getWebElements(by, fromWebElement);
    }

    public boolean stalenessOf(WebElement webElement) {
        return getSearch().stalenessOf(webElement);
    }

    // Search Element

    public WebElement id(String id) {
        return getSearch().id(id);
    }

    public WebElement name(String name) {
        return getSearch().name(name);
    }

    public WebElement xpath(String xpath) {
        return getSearch().xpath(xpath);
    }

    public WebElement cssSelector(String cssSelector) {
        return getSearch().cssSelector(cssSelector);
    }

    public WebElement className(String className) {
        return getSearch().className(className);
    }

    public WebElement partialLinkText(String partialLinkText) {
        return getSearch().partialLinkText(partialLinkText);
    }

    public WebElement linkText(String linkText) {
        return getSearch().linkText(linkText);
    }

    public WebElement tagName(String tagName) {
        return getSearch().tagName(tagName);
    }

    // Search From Element

    public WebElement id(String id, WebElement fromWebElement) {
        return getSearch().id(id, fromWebElement);
    }

    public WebElement name(String name, WebElement fromWebElement) {
        return getSearch().name(name, fromWebElement);
    }

    public WebElement xpath(String xpath, WebElement fromWebElement) {
        return getSearch().xpath(xpath, fromWebElement);
    }

    public WebElement cssSelector(String cssSelector, WebElement fromWebElement) {
        return getSearch().cssSelector(cssSelector, fromWebElement);
    }

    public WebElement className(String className, WebElement fromWebElement) {
        return getSearch().className(className, fromWebElement);
    }

    public WebElement partialLinkText(String partialLinkText, WebElement fromWebElement) {
        return getSearch().partialLinkText(partialLinkText, fromWebElement);
    }

    public WebElement linkText(String linkText, WebElement fromWebElement) {
        return getSearch().linkText(linkText, fromWebElement);
    }

    public WebElement tagName(String tagName, WebElement fromWebElement) {
        return getSearch().tagName(tagName, fromWebElement);
    }

    // Get List

    public List<WebElement> names(String name) {
        return getSearch().names(name);
    }

    public List<WebElement> names(String name, WebElement fromWebElement) {
        return getSearch().names(name, fromWebElement);
    }

    public List<WebElement> xpaths(String xpath) {
        return getSearch().xpaths(xpath);
    }

    public List<WebElement> xpaths(String xpath, WebElement fromWebElement) {
        return getSearch().xpaths(xpath, fromWebElement);
    }

    public List<WebElement> cssSelectors(String cssSelector) {
        return getSearch().cssSelectors(cssSelector);
    }

    public List<WebElement> cssSelectors(String cssSelector, WebElement fromWebElement) {
        return getSearch().cssSelectors(cssSelector, fromWebElement);
    }

    public List<WebElement> classNames(String className) {
        return getSearch().classNames(className);
    }

    public List<WebElement> classNames(String className, WebElement fromWebElement) {
        return getSearch().classNames(className, fromWebElement);
    }

    public List<WebElement> partialLinkTexts(String partialLinkText) {
        return getSearch().partialLinkTexts(partialLinkText);
    }

    public List<WebElement> partialLinkTexts(String partialLinkText, WebElement fromWebElement) {
        return getSearch().partialLinkTexts(partialLinkText, fromWebElement);
    }

    public List<WebElement> linkTexts(String linkText) {
        return getSearch().linkTexts(linkText);
    }

    public List<WebElement> linkTexts(String linkText, WebElement fromWebElement) {
        return getSearch().linkTexts(linkText, fromWebElement);
    }

    public List<WebElement> tagNames(String tagName) {
        return getSearch().tagNames(tagName);
    }

    public List<WebElement> tagNames(String tagName, WebElement fromWebElement) {
        return getSearch().tagNames(tagName, fromWebElement);
    }

    //IsVisible

    public boolean isVisibleId(String id) {
        return getSearch().isVisibleId(id);
    }

    public boolean isVisibleName(String name){
        return getSearch().isVisibleName(name);
    }

    public boolean isVisibleXpath(String xpath){
        return getSearch().isVisibleXpath(xpath);
    }

    public boolean isVisibleCssSelector(String cssSelector){
        return getSearch().isVisibleCssSelector(cssSelector);
    }

    public boolean isVisibleClassName(String className){
        return getSearch().isVisibleClassName(className);
    }

    public boolean isVisiblePartialLinkText(String partialLinkText){
        return getSearch().isVisiblePartialLinkText(partialLinkText);
    }

    public boolean isVisibleLinkText(String linkText){
        return getSearch().isVisibleLinkText(linkText);
    }

    public boolean isVisibleTagName(String tagName){
        return isVisibleTagName(tagName);
    }
}
