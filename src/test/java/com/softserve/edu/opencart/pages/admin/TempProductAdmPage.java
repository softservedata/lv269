package com.softserve.edu.opencart.pages.admin;//package com.softserve.edu.opencart.pages.admin;
//
//public class TempProductAdmPage {
//
//    public ProductAdminPage sortByProductNameDescendant() {
//        productListTable.setProductNameColumnDescendant();
//        return new ProductAdminPage();
//    }
//
//    public ProductAdminPage sortByProductNameAscendant() {
//        productListTable.setProductNameColumnAscendant();
//        return new ProductAdminPage();
//    }
//
//
//    public ProductAdminPage sortByModelDescendant() {
//        productListTable.setModelColumnDescendant();
//        return new ProductAdminPage();
//    }
//
//    public ProductAdminPage sortByModelAscendant() {
//        productListTable.setModelColumnAscendant();
//        return new ProductAdminPage();
//    }
//
//    public ProductAdminPage sortByPriceDescendant() {
//        productListTable.setPriceColumnDescendant();
//        return new ProductAdminPage();
//    }
//
//    public ProductAdminPage sortByPriceAscendant() {
//        productListTable.setPriceColumnAscendant();
//        return new ProductAdminPage();
//    }
//
//    public ProductAdminPage sortByQuantityDescendant() {
//        productListTable.setQuantityColumnDescendant();
//        return new ProductAdminPage();
//    }
//
//    public ProductAdminPage sortByQuantityAscendant() {
//        productListTable.setQuantityColumnAscendant();
//        return new ProductAdminPage();
//    }
//
//    public ProductAdminPage sortByStatusDescendant() {
//        productListTable.setStatusColumnDescendant();
//        return new ProductAdminPage();
//    }
//
//    public ProductAdminPage sortByStatusAscendant() {
//        productListTable.setStatusColumnAscendant();
//        return new ProductAdminPage();
//    }
//
//    //Product Table
//    public WebElement getProductNameHeaderBtn() {
//        return getHeaderBtnByName(TagAttribute.PRODUCT_NAME.toString());
//    }
//
//    public WebElement getModelHeaderBtn() {
//        return getHeaderBtnByName(TagAttribute.MODEL.toString());
//    }
//
//    public WebElement getPriceHeaderBtn() {
//        return getHeaderBtnByName(TagAttribute.PRICE.toString());
//    }
//
//    public WebElement getQuantityHeaderBtn() {
//        return getHeaderBtnByName(TagAttribute.QUANTITY.toString());
//    }
//
//    public WebElement getStatusHeaderBtn() {
//        return getHeaderBtnByName(TagAttribute.STATUS.toString());
//    }
//
//    private void setProductNameColumnDescendant() {
//        if (getClassNameFromElement(getProductNameHeaderBtn()).equalsIgnoreCase(TagAttribute.ASC.toString())
//                || getClassNameFromElement(getProductNameHeaderBtn()).isEmpty()) {
//            operations.clickElement(getProductNameHeaderBtn());
//        }
//    }
//
//    private void setProductNameColumnAscendant() {
//        if (getClassNameFromElement(getProductNameHeaderBtn()).equalsIgnoreCase(TagAttribute.DESC.toString())
//                || getClassNameFromElement(getProductNameHeaderBtn()).isEmpty()) {
//            operations.clickElement(getProductNameHeaderBtn());
//        }
//    }
//
//
//    public void setModelColumnDescendant() {
//        if (getClassNameFromElement(getModelHeaderBtn()).equalsIgnoreCase(TagAttribute.ASC.toString())
//                || getClassNameFromElement(getModelHeaderBtn()).isEmpty()) {
//            operations.clickElement(getModelHeaderBtn());
//        }
//    }
//
//    public void setModelColumnAscendant() {
//        if (getClassNameFromElement(getModelHeaderBtn()).equalsIgnoreCase(TagAttribute.DESC.toString())
//                || getClassNameFromElement(getModelHeaderBtn()).isEmpty()) {
//            operations.clickElement(getModelHeaderBtn());
//        }
//    }
//
//    public void setPriceColumnDescendant() {
//        if (getClassNameFromElement(getPriceHeaderBtn()).equalsIgnoreCase(TagAttribute.ASC.toString())
//                || getClassNameFromElement(getPriceHeaderBtn()).isEmpty()) {
//            operations.clickElement(getPriceHeaderBtn());
//        }
//    }
//
//    public void setPriceColumnAscendant() {
//        if (getClassNameFromElement(getPriceHeaderBtn()).equalsIgnoreCase(TagAttribute.DESC.toString())
//                || getClassNameFromElement(getPriceHeaderBtn()).isEmpty()) {
//            operations.clickElement(getPriceHeaderBtn());
//        }
//    }
//
//    public void setQuantityColumnDescendant() {
//        if (getClassNameFromElement(getQuantityHeaderBtn()).equalsIgnoreCase(TagAttribute.ASC.toString())
//                || getClassNameFromElement(getQuantityHeaderBtn()).isEmpty()) {
//            operations.clickElement(getQuantityHeaderBtn());
//        }
//    }
//
//    public void setQuantityColumnAscendant() {
//        if (getClassNameFromElement(getQuantityHeaderBtn()).equalsIgnoreCase(TagAttribute.DESC.toString())
//                || getClassNameFromElement(getQuantityHeaderBtn()).isEmpty()) {
//            operations.clickElement(getQuantityHeaderBtn());
//        }
//    }
//
//    public void setStatusColumnDescendant() {
//        if (getClassNameFromElement(getStatusHeaderBtn()).equalsIgnoreCase(TagAttribute.ASC.toString())
//                || getClassNameFromElement(getStatusHeaderBtn()).isEmpty()) {
//            operations.clickElement(getStatusHeaderBtn());
//        }
//    }
//
//    public void setStatusColumnAscendant() {
//        if (getClassNameFromElement(getStatusHeaderBtn()).equalsIgnoreCase(TagAttribute.DESC.toString())
//                || getClassNameFromElement(getStatusHeaderBtn()).isEmpty()) {
//            operations.clickElement(getStatusHeaderBtn());
//        }
//    }
//
//
//
//}
