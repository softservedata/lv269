package com.softserve.edu.opencart.pages.user;

import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.tools.search.ISearch;

public class RegElm {

    protected final ISearch search;

    public RegElm() {
        this.search = Application.get().search();
        checkWebElements();
    }

    private void checkWebElements() {
        getRegister();
        getLogin();
    }

    public WebElement getRegister() {
        return search.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[contains(@href,'/register')]");
    }

    public WebElement getLogin() {
        return search.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[contains(@href,'/login')]");
    }

}