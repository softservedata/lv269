package com.softserve.edu.opencart.pages;

import com.google.common.collect.ComparisonChain;
import com.softserve.edu.opencart.data.ProductShort;
import com.softserve.edu.opencart.data.filter.IAdminProductFilterLists;
import com.softserve.edu.opencart.data.sort.IAdminProductSort;

import java.util.*;

public class ProductPageUtils {

    private final String INTEGER_COLUMN_NAME = "Quantity";
    private final String DOUBLE_COLUMN_NAME = "Price";
    private List<ProductShort> currentProductsList;
    private List<ProductShort> fromPagesProductsList;
    private ProductShort filterTemplate;

    public ProductPageUtils() {

    }

    private boolean compareTwoProductsLists(List<ProductShort> productList1, List<ProductShort> productList2) {
        boolean flag = true;
        if (productList1.size() != productList2.size()) {
            flag = false;
        } else {
            for (int i = 0; i < productList1.size(); i++) {
                Map<String, String> map1 = productList1.get(i).getProductMap();
                Map<String, String> map2 = productList2.get(i).getProductMap();
                if (!map1.equals(map2)) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    public boolean sortByColumnNameAndCompare(IAdminProductSort sort, List<ProductShort> fromPagesProductsList) {
        boolean result;
        Comparator<ProductShort> comparator;

        if ((sort.getSortOrder().equalsIgnoreCase(TagAttribute.ASC.toString()))) {
            comparator = setStringAscComparator(sort.getColumnName());
        } else {
            comparator = setStringDescComparator(sort.getColumnName());
        }

        if (sort.getColumnName().equalsIgnoreCase(INTEGER_COLUMN_NAME)) {
            if ((sort.getSortOrder().equalsIgnoreCase(TagAttribute.ASC.toString()))) {
                comparator = setIntegerAscComparator(sort.getColumnName());
            } else {
                comparator = setIntegerDescComparator (sort.getColumnName());
            }
        }

        if (sort.getColumnName().equalsIgnoreCase(DOUBLE_COLUMN_NAME)) {
            if ((sort.getSortOrder().equalsIgnoreCase(TagAttribute.ASC.toString()))) {
                comparator = setDoubleAscComparator(sort.getColumnName());
            } else {
                comparator = setDoubleDescComparator (sort.getColumnName());
            }
        }

        Collections.sort(sort.getCurrentProductShortList(), comparator);
        return compareTwoProductsLists(fromPagesProductsList, sort.getCurrentProductShortList());
    }

    private Comparator<ProductShort> setStringAscComparator(String columnName) {
        return new Comparator<ProductShort>() {

            @Override
            public int compare(ProductShort p1, ProductShort p2) {
                return ComparisonChain.start()
                        .compare(p1.getProductParameterByName(columnName).toLowerCase(),
                                p2.getProductParameterByName(columnName).toLowerCase())
                        .compare(p1.getId(), p2.getId()).result();
            }
        };
    }

    private Comparator<ProductShort> setStringDescComparator(String columnName) {
        return new Comparator<ProductShort>() {

            @Override
            public int compare(ProductShort p1, ProductShort p2) {
                return ComparisonChain.start()
                        .compare(p2.getProductParameterByName(columnName).toLowerCase(),
                                p1.getProductParameterByName(columnName).toLowerCase())
                        .compare(p1.getId(), p2.getId()).result();
            }
        };
    }

    private Comparator<ProductShort> setIntegerAscComparator(String columnName) {
        return new Comparator<ProductShort>() {

            @Override
            public int compare(ProductShort p1, ProductShort p2) {
                return ComparisonChain.start()
                        .compare(Integer.parseInt(p1.getProductParameterByName(columnName)),
                                Integer.parseInt(p2.getProductParameterByName(columnName)))
                        .compare(p1.getId(), p2.getId()).result();
            }
        };
    }

    private Comparator<ProductShort> setIntegerDescComparator(String columnName) {
        return new Comparator<ProductShort>() {

            @Override
            public int compare(ProductShort p1, ProductShort p2) {
                return ComparisonChain.start()
                        .compare(Integer.parseInt(p2.getProductParameterByName(columnName)),
                                Integer.parseInt(p1.getProductParameterByName(columnName)))
                        .compare(p1.getId(), p2.getId()).result();
            }
        };
    }

    private Comparator<ProductShort> setDoubleAscComparator(String columnName) {
        return new Comparator<ProductShort>() {

            @Override
            public int compare(ProductShort p1, ProductShort p2) {
                return ComparisonChain.start()
                        .compare(Double.parseDouble(p1.getProductParameterByName(columnName)),
                                Double.parseDouble(p2.getProductParameterByName(columnName)))
                        .compare(p1.getId(), p2.getId()).result();
            }
        };
    }

    private Comparator<ProductShort> setDoubleDescComparator(String columnName) {
        return new Comparator<ProductShort>() {

            @Override
            public int compare(ProductShort p1, ProductShort p2) {
                return ComparisonChain.start()
                        .compare(Double.parseDouble(p2.getProductParameterByName(columnName)),
                                Double.parseDouble(p1.getProductParameterByName(columnName)))
                        .compare(p1.getId(), p2.getId()).result();
            }
        };
    }

    public boolean filterProductListAndCompare (IAdminProductFilterLists filterSet, List<ProductShort> fromPagesProductsList) {
        List<ProductShort> sortedProductList = new ArrayList<>();
        for (ProductShort current: filterSet.getCurrentProductShortList()) {
            if (current.isUnderTemplate(filterSet.getFilterTemplate())) {
                sortedProductList.add(current);
            }
        }
        return compareTwoProductsLists(sortedProductList, fromPagesProductsList);
    }


}
