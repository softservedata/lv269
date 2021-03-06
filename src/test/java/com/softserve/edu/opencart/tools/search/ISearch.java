package com.softserve.edu.opencart.tools.search;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface ISearch {

    WebElement getWebElement(By by);

    WebElement getWebElement(By by, WebElement fromWebElement);

    List<WebElement> getWebElements(By by);

    List<WebElement> getWebElements(By by, WebElement fromWebElement);

    boolean stalenessOf(WebElement webElement);

    // Search Element

    WebElement id(String id);

    WebElement name(String name);

    WebElement xpath(String xpath);

    WebElement cssSelector(String cssSelector);

    WebElement className(String className);

    WebElement partialLinkText(String partialLinkText);

    WebElement linkText(String linkText);

    WebElement tagName(String tagName);

    // Search From Element

    WebElement id(String id, WebElement fromWebElement);

    WebElement name(String name, WebElement fromWebElement);

    WebElement xpath(String xpath, WebElement fromWebElement);

    WebElement cssSelector(String cssSelector, WebElement fromWebElement);

    WebElement className(String className, WebElement fromWebElement);

    WebElement partialLinkText(String partialLinkText, WebElement fromWebElement);

    WebElement linkText(String linkText, WebElement fromWebElement);

    WebElement tagName(String tagName, WebElement fromWebElement);

    // Get List

    List<WebElement> names(String name);

    List<WebElement> names(String name, WebElement fromWebElement);

    List<WebElement> xpaths(String xpath);

    List<WebElement> xpaths(String xpath, WebElement fromWebElement);

    List<WebElement> cssSelectors(String cssSelector);

    List<WebElement> cssSelectors(String cssSelector, WebElement fromWebElement);

    List<WebElement> classNames(String className);

    List<WebElement> classNames(String className, WebElement fromWebElement);

    List<WebElement> partialLinkTexts(String partialLinkText);

    List<WebElement> partialLinkTexts(String partialLinkText, WebElement fromWebElement);

    List<WebElement> linkTexts(String linkText);

    List<WebElement> linkTexts(String linkText, WebElement fromWebElement);

    List<WebElement> tagNames(String tagName);

    List<WebElement> tagNames(String tagName, WebElement fromWebElement);

    //IsVisible

    boolean isVisibleId(String id);

    boolean isVisibleName(String name);

    boolean isVisibleXpath(String xpath);

    boolean isVisibleCssSelector(String cssSelector);

    boolean isVisibleClassName(String className);

    boolean isVisiblePartialLinkText(String partialLinkText);

    boolean isVisibleLinkText(String linkText);

    boolean isVisibleTagName(String tagName);
}
