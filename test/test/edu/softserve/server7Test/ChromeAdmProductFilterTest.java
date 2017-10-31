//package test.edu.softserve.server7Test;
//
//
//import org.junit.AfterClass;
//import org.junit.Assert;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//public class ChromeAdmProductFilterTest {
//
//    public static WebDriverCreator webDriverCreator;
//    public static SettingPg settingPg;
//    public static ProductPg productPg;
//    public static FilterProducts filterProducts;
//    public static ProductList productList;
//
//    @BeforeClass
//    public static void setParameters() {
//        webDriverCreator = new WebDriverCreator();
//        webDriverCreator.setWebdriverChrome();
//        settingPg = new SettingPg(webDriverCreator);
//        settingPg.changeItemsPerPage(Credentials.ITEMS_PER_PAGE_GREAT.getChosenConstant());
//        productPg = new ProductPg(webDriverCreator);
//        productPg.openByAddress();
//        productPg.cleanFilter();
//        filterProducts = new FilterProducts(webDriverCreator, productPg);
//        filterProducts.createActualProductList (productPg.readTable());
//        productList = filterProducts.getActualList();
//    }
//
//    @Test
//    public void paginationMaxItemsPerPageTest() {
//        int itemsPerPage = productList.getSize()+1;
//        settingPg.changeItemsPerPage(String.valueOf(itemsPerPage));
//        settingPg.changeItemsPerPage(Credentials.ITEMS_PER_PAGE_GREAT.getChosenConstant());
//        productPg.openByAddress();
//        productPg.cleanFilter();
//        Assert.assertFalse(productPg.isPaginationPresent());
//    }
//
//    @Test
//    public void paginationOneItemPerPageTest () {
//        int itemsPerPage = 1;
//        settingPg.changeItemsPerPage(String.valueOf(itemsPerPage));
//        productPg.openByAddress();
//        productPg.cleanFilter();
//        filterProducts.countNumberOfPage();
//        int actual = Integer.parseInt(filterProducts.getNumberOfPages());
//        int expected = productList.getSize();
//        Assert.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void paginationNumberOfItemsItemsPerPageTest() {
//        int itemsPerPage = productList.getSize();
//        settingPg.changeItemsPerPage(String.valueOf(itemsPerPage));
//        productPg.openByAddress();
//        productPg.cleanFilter();
//        Assert.assertFalse(productPg.isPaginationPresent());
//    }
//
//    @Test
//    public void paginationHalfNumberOfItemsItemsPerPageTest () {
//        int itemsPerPage = productList.getSize()/2+1;
//        settingPg.changeItemsPerPage(String.valueOf(itemsPerPage));
//        productPg.openByAddress();
//        productPg.cleanFilter();
//        filterProducts.countNumberOfPage();
//        int actual = Integer.parseInt(filterProducts.getNumberOfPages());
//        int expected = productList.getSize();
//        Assert.assertEquals(expected, actual);
//    }
//
//
//    @AfterClass
//    public static void returnParameters() {
//        settingPg.changeItemsPerPage(Credentials.ITEMS_PER_PAGE_DFLT.getChosenConstant());
//        webDriverCreator.quitDriver();
//    }
//
//
//}
