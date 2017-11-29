package com.softserve.edu.opencart.tools;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.data.applications.IApplicationSource;

public final class Search { //implements ISearch {

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

    private static ISearch search = new SearchImplicit();

    private Search() {
    }

    public static void initSearch(IApplicationSource applicationSource) {
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

    public static void setImplicitStrategy() {
        setStrategy(new SearchImplicit());
    }

    public static void setExplicitVisibleStrategy() {
        setStrategy(new SearchExplicitVisible());
    }

    public static void setExplicitPresentStrategy() {
        setStrategy(new SearchExplicitPresent());
    }

    public static void setExplicitClickableStrategy() {
        setStrategy(new SearchExplicitClickable());
    }

    private static void setStrategy(ISearch search) {
        Search.search = search;
    }

    // Get Strategy

    private static ISearch getSearch() {
        return search;
    }

    public static boolean stalenessOf(WebElement webElement) {
        return getSearch().stalenessOf(webElement);
    }

    public static WebElement id(String id) {
        return getSearch().id(id);
    }

    public static WebElement name(String name) {
        return getSearch().name(name);
    }

    public static WebElement xpath(String xpath) {
        return getSearch().xpath(xpath);
    }

    public static WebElement cssSelector(String cssSelector) {
        return getSearch().cssSelector(cssSelector);
    }

    public static WebElement className(String className) {
        return getSearch().className(className);
    }

    public static WebElement partialLinkText(String partialLinkText) {
        return getSearch().partialLinkText(partialLinkText);
    }

    public static WebElement linkText(String linkText) {
        return getSearch().linkText(linkText);
    }

    public static WebElement tagName(String tagName) {
        return getSearch().tagName(tagName);
    }

    // Search From Element

    public static WebElement id(String id, WebElement fromWebElement) {
        return getSearch().id(id, fromWebElement);
    }

    public static WebElement name(String name, WebElement fromWebElement) {
        return getSearch().name(name, fromWebElement);
    }

    public static WebElement xpath(String xpath, WebElement fromWebElement) {
        return getSearch().xpath(xpath, fromWebElement);
    }

    public static WebElement cssSelector(String cssSelector, WebElement fromWebElement) {
        return getSearch().cssSelector(cssSelector, fromWebElement);
    }

    public static WebElement className(String className, WebElement fromWebElement) {
        return getSearch().className(className, fromWebElement);
    }

    public static WebElement partialLinkText(String partialLinkText, WebElement fromWebElement) {
        return getSearch().partialLinkText(partialLinkText, fromWebElement);
    }

    public static WebElement linkText(String linkText, WebElement fromWebElement) {
        return getSearch().linkText(linkText, fromWebElement);
    }

    public static WebElement tagName(String tagName, WebElement fromWebElement) {
        return getSearch().tagName(tagName, fromWebElement);
    }

    // Get List

    public static List<WebElement> names(String name) {
        return getSearch().names(name);
    }

    public static List<WebElement> xpaths(String xpath) {
        return getSearch().xpaths(xpath);
    }

    public static List<WebElement> xpaths(String xpath, WebElement fromWebElement) {
        return getSearch().xpaths(xpath, fromWebElement);
    }

    public static List<WebElement> cssSelectors(String cssSelector) {
        return getSearch().cssSelectors(cssSelector);
    }

    public static List<WebElement> classNames(String className) {
        return getSearch().classNames(className);
    }

    public static List<WebElement> partialLinkTexts(String partialLinkText) {
        return getSearch().partialLinkTexts(partialLinkText);
    }

    public static List<WebElement> linkTexts(String linkText) {
        return getSearch().linkTexts(linkText);
    }

    public static List<WebElement> tagNames(String tagName) {
        return getSearch().tagNames(tagName);
    }

}
