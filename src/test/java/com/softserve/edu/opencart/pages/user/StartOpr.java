package com.softserve.edu.opencart.pages.user;

import com.softserve.edu.opencart.pages.RegexPatterns;
import com.softserve.edu.opencart.pages.TagAttribute;
import com.softserve.edu.opencart.tools.RegexUtils;

public class StartOpr {
    
    private StartElm startElm;
    private RegElm regElm;
    
    public StartOpr() {
        //System.out.println("StartOpr() ADDR = " + startElm);
        this.startElm = new StartElm();    
    }

    // TODO delete
    //public StartOpr(StartElm startElm) {
    //    this.startElm = startElm;    
    //}

    public StartElm getStartElm() {
        //System.out.println("+++++++++++++++++ startElm = " + startElm);
        return startElm;
    }

    public RegElm getRegElm() {
        clickMyAccount();
        return regElm;
    }

    // get Functional

    public String getCurrencyText() {
        return getStartElm().getCurrency().getText().substring(0, 1);
    }

    public String getMyAccountText() {
        return getStartElm().getMyAccount().getText();
    }

    public String getWishListText() {
        return getStartElm().getWishList().getText();
    }

    public int getWishListNumber() {
        return RegexUtils.extractNumber(RegexPatterns.ALL_DIGITS.toString(), getWishListText());
    }

    public String getShoppingCartText() {
        return getStartElm().getShoppingCart().getText();
    }

    public String getCheckoutText() {
        return getStartElm().getCheckout().getText();
    }

    public String getSearchProductFieldText() {
        return getStartElm().getSearchProductField().getAttribute(TagAttribute.VALUE.toString());
    }

    public String getCartText() {
        return getStartElm().getCart().getText();
    }

    // set Data

     public void setSearchProductField(String text) {
         getStartElm().getSearchProductField().sendKeys(text);
     }
    
     public void clearSearchProductField() {
         getStartElm().getSearchProductField().clear();
     }
    
     public void clickCurrency() {
         getStartElm().getCurrency().click();
     }

     public void clickMyAccount() {
         clickSearchProductField();
         getStartElm().getMyAccount().click();
         regElm = new RegElm();
     }

     public void clickWishList() {
         getStartElm().getWishList().click();
     }

     public void clickShoppingCart() {
         getStartElm().getShoppingCart().click();
     }

     public void clickCheckout() {
         getStartElm().getCheckout().click();
     }

     public void clickLogo() {
         getStartElm().getLogo().click();
     }

     public void clickSearchProductField() {
         //System.out.println("ADDR getStartElm().getSearchProductField() " + getStartElm().getSearchProductField());
         getStartElm().getSearchProductField().click();
     }

     public void clickSearchProductButton() {
         getStartElm().getSearchProductButton().click();
     }

     public void clickCart() {
         getStartElm().getCart().click();
     }

     public void clickRegister() {
         getRegElm().getRegister().click();
     }

     public void clickLogin() {
         getRegElm().getLogin().click();
     }

}
