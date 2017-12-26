package com.softserve.edu.opencart.pages.admin;

import com.softserve.edu.opencart.tools.exceptions.ErrorUtils;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddProductAdminPage extends AHeaderComponentAdmin{

    private interface IProductOptionsTab {}
    private static abstract class AProductOptionsTab implements IProductOptionsTab {

        protected String elementSelector;
        protected String labelSelector;
        protected String elementBlockSelector;

    }
    private static abstract class AOptionsTabWithFields extends AProductOptionsTab {}
    private static abstract class AOptionsTabWithTableNotExtendable extends AProductOptionsTab {}
    private static abstract class AOptionsTabWithTableExtendable extends AProductOptionsTab {}

    private static class GeneralOptionsTab extends AOptionsTabWithFields {}
    private static class DataOptionsTab extends AOptionsTabWithFields {}
    private static class LinksOptionsTab extends AOptionsTabWithFields {}
    private static class AttributeOptionsTab extends AOptionsTabWithTableExtendable {}
    private static class OptionOptionsTab extends AProductOptionsTab {}
    private static class RecurringOptionsTab extends AOptionsTabWithTableExtendable {}
    private static class DiscountOptionsTab extends AOptionsTabWithTableExtendable {}
    private static class SpecialOptionsTab extends AOptionsTabWithTableExtendable {}
    private static class ImageOptionsTab extends AOptionsTabWithTableExtendable {}
    private static class RewardPointOptionsTab extends AOptionsTabWithTableNotExtendable {}
    private static class DesignOptionsTab extends AOptionsTabWithTableNotExtendable {}

    public static enum OptionsTabs {
        GENERAL_OPTIONS_TAB ("General", new GeneralOptionsTab()),
        DATA_OPTIONS_TAB ("Data", new DataOptionsTab()),
        LINKS_OPTIONS_TAB ("Links", new LinksOptionsTab()),
        ATTRIBUTE_OPTIONS_TAB ("Attribute", new AttributeOptionsTab()),
        OPTION_OPTIONS_TAB ("Option", new OptionOptionsTab ()),
        RECURRING_OPTIONS_TAB ("Recurring", new RecurringOptionsTab()),
        DISCOUNT_OPTIONS_TAB ("Discount", new DiscountOptionsTab()),
        SPECIAL_OPTIONS_TAB ("Special", new SpecialOptionsTab()),
        IMAGE_OPTIONS_TAB ("Image", new ImageOptionsTab()),
        REWARD_POINT_OPTIONS_TAB ("Reward Point", new RewardPointOptionsTab()),
        DESIGN_OPTIONS_TAB ("Design", new DesignOptionsTab());

        private String optionsTabName;
        private IProductOptionsTab optionsTab;

        private OptionsTabs(String optionsTabName, IProductOptionsTab optionsTab) {
            this.optionsTabName = optionsTabName;
            this.optionsTab = optionsTab;
        }

        public IProductOptionsTab initOptionsTab() {
            return optionsTab;
        }

        @Override
        public String toString() {
            return optionsTabName;
        }
    }



    private final String NO_SUCH_TAB = "There is tab with name: %s on AddProductPage.";

    WebElement saveProductBtn;
    WebElement cancelProductBtn;
    List<WebElement> optionProductTabBtnsList;
    AProductOptionsTab currentOptionsTab;



    public AddProductAdminPage () {
        saveProductBtn = search.cssSelector(".pull-right > .btn.btn-primary");
        cancelProductBtn = search.cssSelector(".pull-right > .btn.btn-default");
        optionProductTabBtnsList = search.cssSelectors(".nav.nav-tabs > li > a");
    }

    //getData

    public WebElement getSaveProductBtn() {
        return saveProductBtn;
    }

    public WebElement getCancelProductBtn() {
        return cancelProductBtn;
    }

    public List<WebElement> getOptionProductTabBtnsList() {
        return optionProductTabBtnsList;
    }

    public AProductOptionsTab getCurrentOptionTab() {
        return currentOptionsTab;
    }

    //getFunctional

    public WebElement getOptionTabBtnByName (String tabName) {
        WebElement result = null;
        for (WebElement currentTabBtn: getOptionProductTabBtnsList()) {
            if (operations.getText(currentTabBtn).equalsIgnoreCase(tabName)) {
                result = currentTabBtn;
                break;
            }
        }
        ErrorUtils.createOptionNotFoundInSBarException(result == null, String.format(NO_SUCH_TAB, tabName));
        return result;
    }

    //SetData

    public void clickSaveProductBtn() {
        operations.clickElement(getSaveProductBtn());
    }

    public void clickCancelProductBtn() {
        operations.clickElement(getSaveProductBtn());
    }

    public void clickOptionTabBtnByName (String tabName) {
        operations.clickElement(getOptionTabBtnByName(tabName));
    }

    //SetFunctional

    //BusinessLogic


}
