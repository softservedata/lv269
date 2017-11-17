package com.softserve.edu.opencart.pages.admin;

import com.softserve.edu.opencart.tools.WebDriverManager;
import org.openqa.selenium.By;

public class ProductAdminPageController extends AHeaderComponentAdmin {

    private ProductAdminPage currentProductAdminPage;

    public ProductAdminPageController(WebDriverManager webDriverManager) {
        super(webDriverManager);
        currentProductAdminPage = new ProductAdminPage(webDriverManager);
    }
}



