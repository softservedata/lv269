package com.softserve.edu.opencart.tools.search;

import java.util.List;

import com.softserve.edu.opencart.pages.Application;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.tools.exceptions.ScreenCaptureException;

public abstract class ASearch implements ISearch {

    private static final String NO_SUCH_ELEMENT = "Unable to locate element(s): %s";
    //

    //protected abstract WebElement getWebElement(By by);

    //protected abstract WebElement getWebElement(By by, WebElement fromWebElement);

    //protected abstract List<WebElement> getWebElements(By by);

    //protected abstract List<WebElement> getWebElements(By by, WebElement fromWebElement);

    //@Override
    //public abstract boolean stalenessOf(WebElement webElement);

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // TODO add static factory for getWebElement(s) metods or use AspectJ

    private WebElement searchWebElement(By by) {
        try {
            return getWebElement(by);
        } catch (Exception e) {
            throw new ScreenCaptureException(String.format(NO_SUCH_ELEMENT, by.toString()));
            //throw new RuntimeException(String.format(NO_SUCH_ELEMENT, by.toString()));
        }
    }

    private WebElement searchWebElement(By by, WebElement fromWebElement) {
        try {
            return getWebElement(by, fromWebElement);
        } catch (Exception e) {
            throw new ScreenCaptureException(String.format(NO_SUCH_ELEMENT, by.toString()));
            //throw new RuntimeException(String.format(NO_SUCH_ELEMENT, by.toString()));
        }
    }

    private List<WebElement> searchWebElements(By by) {
        try {
            return getWebElements(by);
        } catch (Exception e) {
            throw new ScreenCaptureException(String.format(NO_SUCH_ELEMENT, by.toString()));
            //throw new RuntimeException(String.format(NO_SUCH_ELEMENT, by.toString()));
        }
    }

    private List<WebElement> searchWebElements(By by, WebElement fromWebElement) {
        try {
            return getWebElements(by, fromWebElement);
        } catch (Exception e) {
            throw new ScreenCaptureException(String.format(NO_SUCH_ELEMENT, by.toString()));
            //throw new RuntimeException(String.format(NO_SUCH_ELEMENT, by.toString()));
        }
    }

    // Search Element

    @Override
    public WebElement id(String id) {
        return searchWebElement(By.id(id));
    }

    @Override
    public WebElement name(String name) {
        return searchWebElement(By.name(name));
    }

    @Override
    public WebElement xpath(String xpath) {
        return searchWebElement(By.xpath(xpath));
    }

    @Override
    public WebElement cssSelector(String cssSelector) {
        return searchWebElement(By.cssSelector(cssSelector));
    }

    @Override
    public WebElement className(String className) {
        return searchWebElement(By.className(className));
    }

    @Override
    public WebElement partialLinkText(String partialLinkText) {
        return searchWebElement(By.partialLinkText(partialLinkText));
    }

    @Override
    public WebElement linkText(String linkText) {
        return searchWebElement(By.linkText(linkText));
    }

    @Override
    public WebElement tagName(String tagName) {
        return searchWebElement(By.tagName(tagName));
    }

    // Search From Element

    @Override
    public WebElement id(String id, WebElement fromWebElement) {
        return searchWebElement(By.id(id), fromWebElement);
    }

    @Override
    public WebElement name(String name, WebElement fromWebElement) {
        return searchWebElement(By.name(name), fromWebElement);
    }

    @Override
    public WebElement xpath(String xpath, WebElement fromWebElement) {
        return searchWebElement(By.xpath(xpath), fromWebElement);
    }

    @Override
    public WebElement cssSelector(String cssSelector, WebElement fromWebElement) {
        return searchWebElement(By.cssSelector(cssSelector), fromWebElement);
    }

    @Override
    public WebElement className(String className, WebElement fromWebElement) {
        return searchWebElement(By.className(className), fromWebElement);
    }

    @Override
    public WebElement partialLinkText(String partialLinkText, WebElement fromWebElement) {
        return searchWebElement(By.partialLinkText(partialLinkText), fromWebElement);
    }

    @Override
    public WebElement linkText(String linkText, WebElement fromWebElement) {
        return searchWebElement(By.linkText(linkText), fromWebElement);
    }

    @Override
    public WebElement tagName(String tagName, WebElement fromWebElement) {
        return searchWebElement(By.tagName(tagName), fromWebElement);
    }

    // Get List

    public List<WebElement> names(String name) {
        return searchWebElements(By.name(name));
    }

    @Override
    public List<WebElement> names(String name, WebElement fromWebElement) {
        return searchWebElements(By.name(name), fromWebElement);
    }

    @Override
    public List<WebElement> xpaths(String xpath) {
        return searchWebElements(By.xpath(xpath));
    }

    @Override
    public List<WebElement> xpaths(String xpath, WebElement fromWebElement) {
        return searchWebElements(By.xpath(xpath), fromWebElement);
    }

    @Override
    public List<WebElement> cssSelectors(String cssSelector) {
        return searchWebElements(By.cssSelector(cssSelector));
    }

    @Override
    public List<WebElement> cssSelectors(String cssSelector, WebElement fromWebElement) {
        return searchWebElements(By.cssSelector(cssSelector), fromWebElement);
    }

    @Override
    public List<WebElement> classNames(String className) {
        return searchWebElements(By.className(className));
    }

    @Override
    public List<WebElement> classNames(String className, WebElement fromWebElement) {
        return searchWebElements(By.className(className), fromWebElement);
    }

    @Override
    public List<WebElement> partialLinkTexts(String partialLinkText) {
        return searchWebElements(By.partialLinkText(partialLinkText));
    }

    @Override
    public List<WebElement> partialLinkTexts(String partialLinkText, WebElement fromWebElement) {
        return searchWebElements(By.partialLinkText(partialLinkText), fromWebElement);
    }

    @Override
    public List<WebElement> linkTexts(String linkText) {
        return searchWebElements(By.linkText(linkText));
    }

    @Override
    public List<WebElement> linkTexts(String linkText, WebElement fromWebElement) {
        return searchWebElements(By.linkText(linkText), fromWebElement);
    }

    @Override
    public List<WebElement> tagNames(String tagName) {
        return searchWebElements(By.tagName(tagName));
    }

    @Override
    public List<WebElement> tagNames(String tagName, WebElement fromWebElement) {
        return searchWebElements(By.tagName(tagName), fromWebElement);
    }

    //IsVisible

    @Override
    public boolean isVisibleId(String id) {
        return ((WebElement)((JavascriptExecutor) Application.get().browser().getDriver())
                .executeScript("return document.getElementById(arguments[0])", id) != null);
    }

    @Override
    public boolean isVisibleName(String name) {
        return (names(name).size()>0);
    }

    @Override
    public boolean isVisibleXpath(String xpath) {
        return (xpaths(xpath).size() >0);
    }

    @Override
    public boolean isVisibleCssSelector(String cssSelector) {
        return (cssSelectors(cssSelector).size() >0);
    }

    @Override
    public boolean isVisibleClassName(String className) {
        return (classNames(className).size() >0);
    }

    @Override
    public boolean isVisiblePartialLinkText(String partialLinkText) {
        return (partialLinkTexts(partialLinkText).size() >0);
    }

    @Override
    public boolean isVisibleLinkText(String linkText) {
        return (linkTexts(linkText).size() >0);
    }

    @Override
    public boolean isVisibleTagName(String tagName) {
        return (tagNames(tagName).size() >0);
    }

}
