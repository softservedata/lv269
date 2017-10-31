package test.edu.softserve.server7Test;

/**
 * enum with url, credentials, paths and parameters for drivers
 */
public enum Credentials {
    GECKO_WEBDRIVER_PARAMETER("webdriver.gecko.driver"),
    CHROME_WEBDRIVER_PARAMETER("webdriver.chrome.driver"),
    GECKO_WEBDRIVER_PATH("C:/AutomationTools/geckodriver.exe"),
    GOOGLE_WEBDRIVER_PATH("C:/AutomationTools/chromedriver.exe"),
    ADMINISTRATOR_LOGIN("admin"),
    ADMINISTRATOR_PASSWORD("269lv269lv"),
    URL_SERVER("http://server7.pp.ua/"),
    URL_ADMIN_PAGE("admin/"),
    URL_LOGOUTED("common/login"),
    URL_SETTING_PART("index.php?route=setting/" +
            "store&token=dk7Vj8Zl94QRLl9V3aE22aQ4NvUigXZv"),
    URL_PRODUCT_PG("index.php?route=catalog/" +
            "product&token=giuFK45gup5AuVh6h1weuTb7ZqbxvlFa"),
    ITEMS_PER_PAGE_DFLT("20"),
    ITEMS_PER_PAGE_MIN("1"),
    ITEMS_PER_PAGE_GREAT("10000"),
    BUTTON("button"),
    ENTER("enter"),
    ADM_PRODUCT_PG_STATUS_SLCT_NONVALUE_TXT (""),
    ADM_PRODUCT_PG_STATUS_SLCT_VALUE_TRUE_TXT ("Enabled"),
    ADM_PRODUCT_PG_STATUS_SLCT_VALUE_FALSE_TXT ("Disabled"),
    ADM_PRODUCT_PG_IMG_SLCT_NONVALUE_TXT (""),
    ADM_PRODUCT_PG_IMG_SLCT_VALUE_TRUE_TXT("Enabled"),
    ADM_PRODUCT_PG_IMG_SLCT_VALUE_FALSE_TXT("Disabled"),
    ADM_PRODUCT_PG_DFLT_IMAGE_ADDRESS_SMALL ("image/cache/no_image-40x40.png"),
    TEST_USER_LOGIN("q2098007@mvrht.net"),
    TEST_USER_PASSWORD("temporary");

    private String chosenConstant;

    Credentials(String choice) {
        chosenConstant = choice;
    }

    public String getChosenConstant() {
        return chosenConstant;
    }
    }
