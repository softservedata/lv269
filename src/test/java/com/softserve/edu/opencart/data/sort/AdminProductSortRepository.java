package com.softserve.edu.opencart.data.sort;

import com.softserve.edu.opencart.pages.TagAttribute;

public class AdminProductSortRepository {

    private final String PRODUCT_LIST_FILE_NAME = "productlist.txt";
    
    private static volatile AdminProductSortRepository instance = null;

    private AdminProductSortRepository() {
    }

    public static AdminProductSortRepository get() {
        if (instance == null) {
            synchronized (AdminProductSortRepository.class) {
                if (instance == null) {
                    instance = new AdminProductSortRepository();
                }
            }
        }
        return instance;
    }
    //TODO Without filename here
    public IAdminProductSort sortProductNameAsc() {
        AdminProductSort result = new AdminProductSort()
                .readCurrentProductShortListFromFile(PRODUCT_LIST_FILE_NAME)
                .setColumnName("Product Name")
                .setSortOrder(TagAttribute.ASC.toString());
        result.addOptionReplaceValue("Default Items Per Page (Admin)", 
                String.valueOf(result.getCurrentProductShortList().size()/3 +1));
        return result;
    }

    public IAdminProductSort sortProductNameDesc() {
        AdminProductSort result = new AdminProductSort()
                .readCurrentProductShortListFromFile(PRODUCT_LIST_FILE_NAME)
                .setColumnName("Product Name")
                .setSortOrder(TagAttribute.DESC.toString());
        result.addOptionReplaceValue("Default Items Per Page (Admin)",
                String.valueOf(result.getCurrentProductShortList().size()/3 +1));
        return result;
    }

    public IAdminProductSort sortModelAsc() {
        AdminProductSort result = new AdminProductSort()
                .readCurrentProductShortListFromFile(PRODUCT_LIST_FILE_NAME)
                .setColumnName("Model")
                .setSortOrder(TagAttribute.ASC.toString());
        result.addOptionReplaceValue("Default Items Per Page (Admin)",
                String.valueOf(result.getCurrentProductShortList().size()/3 +1));
        return result;
    }

    public IAdminProductSort sortModelDesc() {
        AdminProductSort result = new AdminProductSort()
                .readCurrentProductShortListFromFile(PRODUCT_LIST_FILE_NAME)
                .setColumnName("Model")
                .setSortOrder(TagAttribute.DESC.toString());
        result.addOptionReplaceValue("Default Items Per Page (Admin)",
                String.valueOf(result.getCurrentProductShortList().size()/3 +1));
        return result;
    }

    public IAdminProductSort sortPriceAsc() {
        AdminProductSort result = new AdminProductSort()
                .readCurrentProductShortListFromFile(PRODUCT_LIST_FILE_NAME)
                .setColumnName("Price")
                .setSortOrder(TagAttribute.ASC.toString());
        result.addOptionReplaceValue("Default Items Per Page (Admin)",
                String.valueOf(result.getCurrentProductShortList().size()/3 +1));
        return result;
    }

    public IAdminProductSort sortPriceDesc() {
        AdminProductSort result = new AdminProductSort()
                .readCurrentProductShortListFromFile(PRODUCT_LIST_FILE_NAME)
                .setColumnName("Price")
                .setSortOrder(TagAttribute.DESC.toString());
        result.addOptionReplaceValue("Default Items Per Page (Admin)",
                String.valueOf(result.getCurrentProductShortList().size()/3 +1));
        return result;
    }

    public IAdminProductSort sortQuantityAsc() {
        AdminProductSort result = new AdminProductSort()
                .readCurrentProductShortListFromFile(PRODUCT_LIST_FILE_NAME)
                .setColumnName("Quantity")
                .setSortOrder(TagAttribute.ASC.toString());
        result.addOptionReplaceValue("Default Items Per Page (Admin)",
                String.valueOf(result.getCurrentProductShortList().size()/3 +1));
        return result;
    }

    public IAdminProductSort sortQuantityDesc() {
        AdminProductSort result = new AdminProductSort()
                .readCurrentProductShortListFromFile(PRODUCT_LIST_FILE_NAME)
                .setColumnName("Quantity")
                .setSortOrder(TagAttribute.DESC.toString());
        result.addOptionReplaceValue("Default Items Per Page (Admin)",
                String.valueOf(result.getCurrentProductShortList().size()/3 +1));
        return result;
    }

    public IAdminProductSort sortStatusAsc() {
        AdminProductSort result = new AdminProductSort()
                .readCurrentProductShortListFromFile(PRODUCT_LIST_FILE_NAME)
                .setColumnName("Status")
                .setSortOrder(TagAttribute.ASC.toString());
        result.addOptionReplaceValue("Default Items Per Page (Admin)",
                String.valueOf(result.getCurrentProductShortList().size()/3 +1));
        return result;
    }

    public IAdminProductSort sortStatusDesc() {
        AdminProductSort result = new AdminProductSort()
                .readCurrentProductShortListFromFile(PRODUCT_LIST_FILE_NAME)
                .setColumnName("Status")
                .setSortOrder(TagAttribute.DESC.toString());
        result.addOptionReplaceValue("Default Items Per Page (Admin)",
                String.valueOf(result.getCurrentProductShortList().size()/3 +1));
        return result;
    }
 
}
