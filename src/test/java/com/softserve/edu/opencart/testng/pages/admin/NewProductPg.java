package com.softserve.edu.opencart.testng.pages.admin;

import com.softserve.edu.opencart.testng.WebDriverCreator;

public class NewProductPg extends AHeaderComponent {

    public NewProductPg(WebDriverCreator webDriverCreator) {
        super(webDriverCreator);
    }

    private enum Selectors {

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

        Selectors(String choice) {
            element = choice;
        }

        public String getElement() {
            return element;
        }
    }


}
