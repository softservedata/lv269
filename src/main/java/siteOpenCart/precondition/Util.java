package siteOpenCart.precondition;

import org.openqa.selenium.WebElement;

/**
 * Util class.
 */
public class Util {

    /**
     * Method for clear and focus in the field.
     *
     * @param element
     * @return
     */
    public static WebElement inputInField(WebElement element) {
        element.clear();
        element.click();
        return element;
    }
}
