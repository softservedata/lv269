package server7.junit;

/**
 * Selectors for different elements
 * Shortens
 * PG - page, WDW-window, SBAR - sidebar, UBAR - upper bar
 * FLD - field, BTN - button, DRPD - dropdown, RBTN - radio button
 * CLK - click, PRS-press
 * LGN - login, LGOUT - logout,  PSWD - password, ATTR-attribute
 * ADM - admin, USR - user
 * ID - id, CLS - class, CSS - css, XPTH - xpath
 * Format of the constant
 * WHERE_[STATE OF PLACE]_WHAT_[STATE OF ELEMENT]_FINDBY
 * - format of convention
 */
public enum ElementsSelectors {
    ADM_LGN_PG_LGN_FLD_ID("input-username"),
    ADM_LGN_PG_PSWD_FLD_ID("input-password"),
    ADM_LGN_PG_LGN_BTN_CSS_(".btn.btn-primary"),
    ADM_PROFILE_PG_LGOUT_BT_XPATH("//a[child::i[" +
            "@class='fa fa-sign-out fa-lg']]"),
    ADM_PROFILE_PG_HOME_BTN_CLS("navbar-brand"),
    ADM_SBAR_MENU_BTN_ID("button-menu"),
    ADM_PROFILE_PG_SBAR_UNFOLD_ICON_CLS("fa-dedent"), //UNFOLD STATE
    ADM_SBAR_UNFOLD_CATALOG_LI_OPEN_STATE_CSS("#menu-catalog.active.open"),
    ADM_SBAR_UNFOLD_CATALOG_BTN_CSS("#menu-catalog a.parent"),
    ADM_SBAR_UNFOLD_CATALOG_PRODUCT_BTN_CSS(
            "ul.collapse.in > li> a[href*='catalog/product']"),
    ADM_PROFILE_PG_SBAR_FOLD_ICON_CLS("fa-indent"), //FOLD STATE
    ADM_SBAR_FOLD_CATALOG_BTN_FOLD_ID("menu-catalog"),
    ADM_SBAR_FOLD_CATALOG_BTN_FOLD_CSS("#menu-catalog > a.parent"),
    ADM_SBAR_PRODUCT_BTN_FOLD_XPTH("//a [contains(" +
            "@href, 'catalog/product')][ancestor::li[@id= 'menu-catalog']]"),
    ADM_SETTING_PG_EDIT_SETTING_BTN_XPTH ("//a[@class='btn btn-primary']" +
            "[contains(@href, 'server7')]" +
            "[ancestor::table[@class='table table-bordered table-hover']]"),
    ADM_SETTING_EDIT_PG_OPTION_BTN_CSS("a[href='#tab-option'"),
    ADM_EDIT_SETTING_PG_DFLT_ITEMS_FLD_ID ("input-admin-limit"),
    ADM_EDIT_SETTING_PG_SAVE_BTN_ID ("button-save"),
    ADM_PRODUCT_PG_PRODUCT_NAME_FLD_ID("input-name"),

    ADM_PRODUCT_PG_PRICE_FLD_ID("input-price"),
    ADM_PRODUCT_PG_STATUS_DRPD_ID("input-status"),
    ADM_PRODUCT_PG_MODEL_FLD_ID("input-model"),
    ADM_PRODUCT_PG_QUANTITY_FLD_ID("input-quantity"),
    ADM_PRODUCT_PG_IMAGE_DRPD_ID("input-image"),
    ADM_PRODUCT_PG_FILTER_BTN_ID("button-filter"),
    ADM_PRODUCT_PG_PAGINATION_CLS ("pagination"),
    ADM_PRODUCT_PAGINATION_LAST_PG_BTN_CSS(".pagination li:last-child > a"),
    ADM_PRODUCT_PG_LAST_PG_CHOSEN_TXT_CSS (".pagination li.active span"),

    ADM_PRODUCT_PG_ADD_NEW_BTN_XPTH("//a[@class = 'btn btn-primary']" +
            "[child::i[@class='fa fa-plus']]"),
    ADM_PRODUCT_PG_ITEM_TABLE_CLS (".table.table-bordered.table-hover"),
    ADM_PRODUCT_PG_ITEM_TABLE_THEAD_CSS (".table.table-bordered.table-hover > thead"),
    ADM_PRODUCT_PG_ITEM_TABLE_TBODY_CSS (".table.table-bordered.table-hover > tbody"),
    ADM_ITEMS_TABLE_IMG_XPTH(".//td[2]/img"),
    ITEMS_TABLE_NAME_TD_XPTH (".//td[3]"),
    ITEMS_TABLE_MODEL_TD_XPTH (".//td[4]"),
    ITEMS_TABLE_PRICE_SPAN_2PRICES_XPTH (".//td[5]/span"),
    ITEMS_TABLE_PRICE_TD_1PRICE_XPTH (".//td[5]"),
    ITEMS_TABLE_QUANTITY_SPAN_XPTH (".//td[6]/span"),
    ITEMS_TABLE_STATUS_TD_XPTH (".//td[4]"),
    ADD_PRODUCT_UBAR_GENERAL_BTN_CSS("a[href='#tab-general']"),
    ADD_PRODUCT_UBAR_DATA_BTN_CSS("a[href='#tab-data']"),
    ADD_PRODUCT_UBAR_LINK_BTN_CSS("a[href='#tab-links']"),
    ADD_PRODUCT_UBAR_ATTRIBUTE_BTN_CSS("a[href='#tab-attribute']"),
    ADD_PRODUCT_UBAR_OPTION_BTN_CSS("a[href='#tab-option']"),
    ADD_PRODUCT_UBAR_RECURRING_BTN_CSS("a[href='#tab-recurring']"),
    ADD_PRODUCT_UBAR_DISCOUNT_BTN_CSS("a[href='#tab-discount']"),
    ADD_PRODUCT_UBAR_SPECIAL_BTN_CSS("a[href='#tab-image']"),
    ADD_PRODUCT_UBAR_REWARD_BTN_CSS("a[href='#tab-reward']"),
    ADD_PRODUCT_UBAR_DESIGN_BTN_CSS("a[href='#tab-design']"),
    ADD_PRODUCT_GENERAL_PG_PRODUCT_NAME_FLD_ID("input-name1"),
    ADD_PRODUCT_GENERAL_PG_PRODUCT_DSCRP_FLD_CLS("note-editable.panel-body"),
    ADD_PRODUCT_GENERAL_PG_METATAG_FLD_ID("input-meta-title1"),
    ADD_PRODUCT_GENERAL_PG_METATAGDSCRP_FLD_ID("input-meta-description1"),
    ADD_PRODUCT_GENERAL_PG_METATAGKWORD_FLD_ID("input-meta-keyword1"),
    ADD_PRODUCT_GENERAL_PG_PRODUCTTAG_FLD_ID("input-tag1"),
    ADD_PRODUCT_DATA_PG_MODEL_FLD_ID("input-model"),
    ADD_PRODUCT_DATA_PG_SKU_FLD_ID("input-sku"),
    ADD_PRODUCT_DATA_PG_UPC_FLD_ID("input-upc"),
    ADD_PRODUCT_DATA_PG_EAN_FLD_ID("input-ean"),
    ADD_PRODUCT_DATA_PG_JAN_FLD_ID("input-jan"),
    ADD_PRODUCT_DATA_PG_ISBN_FLD_ID("input-isbn"),
    ADD_PRODUCT_DATA_PG_MPN_FLD_ID("input-mpn"),
    ADD_PRODUCT_DATA_PG_LOCATION_FLD_ID("input-location"),
    ADD_PRODUCT_DATA_PG_PRICE_FLD_ID("input-price"),
    ADD_PRODUCT_DATA_PG_TAXPRICE_DRPD_ID("input-tax-class"),
    ADD_PRODUCT_DATA_PG_TAXPRICE_DRPD_VALUE0("0"),
    ADD_PRODUCT_DATA_PG_TAXPRICE_DRPD_VALUE9("9"),
    ADD_PRODUCT_DATA_PG_TAXPRICE_DRPD_VALUE10("10"),
    ADD_PRODUCT_DATA_PG_QUANTITY_FLD_ID("input-quantity"),
    ADD_PRODUCT_DATA_PG_MINQUANTITY_FLD_ID("input-minimum"),
    ADD_PRODUCT_DATA_PG_SUBTRACT_DRPD_ID("input-subtract"),
    ADD_PRODUCT_DATA_PG_SUBTRACT_DRPD_VALUE_YES("1"),
    ADD_PRODUCT_DATA_PG_SUBTRACT_DRPD_VALUE_NO("0"),
    ADD_PRODUCT_DATA_PG_OUTOFSTOCK_DRPD_ID("input-stock-status"),
    ADD_PRODUCT_DATA_PG_OUTOFSTOCK_DRPD_VALUE6("6"),
    ADD_PRODUCT_DATA_PG_SOUTOFSTOCK_DRPD_VALUE7("7"),
    ADD_PRODUCT_DATA_PG_SOUTOFSTOCK_DRPD_VALUE5("5"),
    ADD_PRODUCT_DATA_PG_SOUTOFSTOCK_DRPD_VALUE8("8"),
    ADD_PRODUCT_DATA_PG_SHIPPING_YES_RBTN_XPTH(
            "//input[parent::label[@class='radio-inline']][@value='1']"),
    ADD_PRODUCT_DATA_PG_SHIPPING_NO_RBTN_XPTH(
            "//input[parent::label[@class='radio-inline']][@value='0']"),
    ADD_PRODUCT_DATA_PG_SEO_FLD_ID("input-keyword"),
    ADD_PRODUCT_DATA_PG_DATE_FLD_ID("input-date-available"),
    ADD_PRODUCT_DATA_PG_CALENDAR_BTN_XPTH("//button[@class='btn btn-default']"),
    ADD_PRODUCT_CALENDAR_MONTHYEAR_BTN_XPTH("//button[@class='btn btn-default']"),
    ADD_PRODUCT_DATA_PG_LENGTH_FLD_ID("input-length"),
    ADD_PRODUCT_DATA_PG_WIDTH_FLD_ID("input-width"),
    ADD_PRODUCT_DATA_PG_HEIGHT_FLD_ID("input-height"),
    ADD_PRODUCT_DATA_PG_LENGTHCLASS_DRPD_ID("input-length-class"),
    ADD_PRODUCT_DATA_PG_LENGTHCLASS_DRPD_VALUE_CM("1"),
    ADD_PRODUCT_DATA_PG_LENGTHCLASS_DRPD_VALUE_MM("2"),
    ADD_PRODUCT_DATA_PG_LENGTHCLASS_DRPD_VALUE_IN("3"),
    ADD_PRODUCT_DATA_PG_WEIGHT_FLD_ID("input-weight"),
    ADD_PRODUCT_DATA_PG_WEIGHTCLASS_DRPD_ID("input-length-class"),
    ADD_PRODUCT_DATA_PG_WEIGHTCLASS_DRPD_VALUE_KG("1"),
    ADD_PRODUCT_DATA_PG_WEIGHTCLASS_DRPD_VALUE_GR("2"),
    ADD_PRODUCT_DATA_PG_WEIGHTCLASS_DRPD_VALUE_PO("5"),
    ADD_PRODUCT_DATA_PG_WEIGHTCLASS_DRPD_VALUE_OU("6"),
    ADD_PRODUCT_DATA_PG_STATUS_DRPD_ID("input-status"),
    ADD_PRODUCT_DATA_PG_STATUS_DRPD_VALUE_EN("1"),
    ADD_PRODUCT_DATA_PG_STATUS_DRPD_VALUE_DIS("0"),
    ADD_PRODUCT_DATA_PG_SORTORDER_FLD_ID("input-sort-order"),
    ADD_PRODUCT_LINKS_PG_MANUFACTURER_FLD_ID("input-manufacturer"),
    ADD_PRODUCT_LINKS_PG_CATEGORIES_FLD_ID("input-category"),
    ADD_PRODUCT_LINKS_PG_CATEGORIESLIST_DIV_ID("product-category"),
    ADD_PRODUCT_LINKS_PG_FILTER_FLD_ID("input-filter"),
    ADD_PRODUCT_LINKS_PG_FILTERLIST_DIV_ID("product-filter"),
    ADD_PRODUCT_LINKS_PG_STORES_DIV_CSS("//div[@class='well well-sm']" +
            "[parent::div[@class='col-sm-10']" +
            "[preceding-sibling::label[text()='Stores']]]"),
    ADD_PRODUCT_LINKS_PG_DOWNLOAD_FLD_ID("input-download"),
    ADD_PRODUCT_LINKS_PG_DOWNLOADLIST_DIV_ID("product-download"),
    ADD_PRODUCT_LINKS_PG_RELATEDPCT_FLD_ID("input-related"),
    ADD_PRODUCT_LINKS_PG_DRELATEDPDCTLIST_DIV_ID("product-related"),
    ADD_PRODUCT_ATTR_PG_ATTR_TBL_ID("attribute"),
    ADD_PRODUCT_ATTR_PG_ADD_ATTR_BTN_XPTH("//button[@class='btn btn-primary']" +
            "[ancestor::table[@id='attribute']]"),
    ADD_PRODUCT_OPTION_PG_OPTION_FLD_ID("input-option"),
    ADD_PRODUCT_RECURRING_PG_RECUR_TBL_XPTH(
            "//table[@class='table table-striped table-bordered table-hover']" +
                    "[ancestor::div[@id='tab-recurring']]"),
    ADD_PRODUCT_RECURRING_PG_ADD_RECUR_BTN_XPTH(
            "//button[@class='btn btn-primary']" +
                    "[ancestor::div[@id='tab-recurring']]"),
    ADD_PRODUCT_DISCOUNT_PG_DISCOUNT_TBL_ID("discount"),
    ADD_PRODUCT_DISCOUNT_PG_ADD_DISCOUNT_BTN_XPTH(
            "//button[@class='btn btn-primary']" +
                    "[ancestor::table[@id='discount']]"),
    ADD_PRODUCT_SPECIAL_PG_SPECIAL_TBL_ID("special"),
    ADD_PRODUCT_SPECIAL_PG_ADD_SPECIAL_BTN_XPTH("//button[@class='btn btn-primary']" +
            "[ancestor::table[@id='special']]"),
    ADD_PRODUCT_IMAGE_PG_IMGTABLE_FREE_TBL_XPTH("//td[@class='text-left']" +
            "[child::a[@id='thumb-image']]"),
    ADD_PRODUCT_IMAGE_PG_ADD_IMAGE_BTN_XPTH("//button[@class='btn btn-primary']" +
            "[ancestor::table[@id='images']]"),
    ADD_PRODUCT_REWARD_PG_GROUP_TBL_ID(
            "//table[@class='table table-bordered table-hover']" +
                    "[descendant::input[@class='form-control']]");

    private String element;

    ElementsSelectors(String choice) {
        element = choice;
    }

    public String getElement() {
        return element;
    }
}
