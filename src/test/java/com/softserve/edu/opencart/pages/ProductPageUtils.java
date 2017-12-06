package com.softserve.edu.opencart.pages;

import com.softserve.edu.opencart.data.ProductShort;
import com.softserve.edu.opencart.data.sort.IAdminProductSort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class ProductPageUtils {

    private List<ProductShort> currentProductsList;
    private List<ProductShort> fromPagesProductsList;
    private ProductShort filterTemplate;

    public ProductPageUtils() {

    }

    private List<ProductShort> sortProductsListAsc(List<ProductShort> productsList, String columnName) {
        Collections.sort(productsList, new Comparator<ProductShort>() {
            @Override
            public int compare(ProductShort p1, ProductShort p2) {
                return p1.getProductParameterByName(columnName).toLowerCase().
                        compareTo(p2.getProductParameterByName(columnName).toLowerCase());
            }
        });
        return productsList;
    }

    private List<ProductShort> sortProductsListDesc(List<ProductShort> productsList, String columnName) {
        sortProductsListAsc(productsList, columnName);
        Collections.reverse(productsList);
        return productsList;
    }

    private boolean compareTwoProductsLists(List<ProductShort> productList1, List<ProductShort> productList2) {
        boolean flag = true;
        for (int i=0; i< productList1.size();i++) {
            Map<String,String> map1 = productList1.get(i).getProductMap();
            Map<String,String> map2 = productList1.get(i).getProductMap();
            if (!map1.equals(map2)) {
                flag = false;
                break;
            }
        }
        return flag;
        //        return CollectionUtils.isEqualCollection(productList1, productList2, new Equator<ProductShort>() {
//            @Override
//            public boolean equate(ProductShort p1, ProductShort p2) {
//                return p1.getProductMap().equals(p2.getProductMap());
//            }
//
//            @Override
//            public int hash(ProductShort productShort) {
//                return 0;
//            }
//        });
    }

    public boolean sortByColumnNameAndCompare(IAdminProductSort sort, List<ProductShort> fromPagesProductsList) {
        boolean result;
        if (sort.getSortOrder().equalsIgnoreCase(TagAttribute.ASC.toString())) {
            result = compareTwoProductsLists(fromPagesProductsList,
                    sortProductsListAsc(sort.getCurrentProductShortList(), sort.getColumnName()));
        } else {
            result = compareTwoProductsLists(fromPagesProductsList,
                    sortProductsListDesc(sort.getCurrentProductShortList(), sort.getColumnName()));
        }
        return result;
    }

    public boolean filterProductListandCompare (IAdminProductSort sort, List<ProductShort> fromPagesProductsList) {
        return false;
    }


}
