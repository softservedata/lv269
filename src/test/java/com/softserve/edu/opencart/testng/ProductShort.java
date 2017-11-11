package com.softserve.edu.opencart.testng;

import com.softserve.edu.opencart.testng.constants.Credentials;

import java.util.HashMap;
import java.util.Map;

/**
 * This class describes Product from the admin product list.
 * Every field represents a column.
 */
public class ProductShort {

    private final String name = "name";
    private final String model = "model";
    private final String price = "price";
    private final String quantity = "quantity";
    private final String status = "status";
    private final String image = "image";

    private Map<String, String> product;

    public ProductShort() {
        product = new HashMap<>();
    }

    public String getName() {
        return product.get(name);
    }

    public String getModel() {
        return product.get(model);
    }

    public String getPrice() {
        return product.get(price);
    }

    public String getQuantity() {
        return product.get(quantity);
    }

    public Boolean isEnable() {
        return getFlag(product.get(status),
                Credentials.ADM_PRODUCT_PG_STATUS_SLCT_VALUE_TRUE_TXT
                        .get(),
                Credentials.ADM_PRODUCT_PG_STATUS_SLCT_VALUE_FALSE_TXT
                        .get());
    }

    public Boolean isImage() {
        return getFlag(product.get(image),
                Credentials.ADM_PRODUCT_PG_IMG_SLCT_VALUE_TRUE_TXT
                        .get(),
                Credentials.ADM_PRODUCT_PG_IMG_SLCT_VALUE_FALSE_TXT
                        .get());
    }

    public void setName(String nameValue) {
        product.put(name, nameValue);
    }

    public void setModel(String modelValue) {
        product.put(model, modelValue);
    }

    public void setPrice(String priceValue) {
        product.put(price, priceValue);
    }

    public void setQuantity(String quantityValue) {
        product.put(quantity, quantityValue);
    }

    public void setStatusFlag(Boolean statusFlag) {
        product.put(status, setFlagText(statusFlag,
                Credentials.ADM_PRODUCT_PG_STATUS_SLCT_VALUE_TRUE_TXT
                        .get(),
                Credentials.ADM_PRODUCT_PG_STATUS_SLCT_VALUE_FALSE_TXT
                        .get()));
    }

    public void setImageFlag(Boolean imgFlag) {
        product.put(image, setFlagText(imgFlag,
                Credentials.ADM_PRODUCT_PG_IMG_SLCT_VALUE_TRUE_TXT
                        .get(),
                Credentials.ADM_PRODUCT_PG_IMG_SLCT_VALUE_FALSE_TXT
                        .get()));
    }

    public void setAllData(String name, String model,
                           String price, String quantity,
                           Boolean status, Boolean image) {
        setName(name);
        setModel(model);
        setPrice(price);
        setQuantity(quantity);
        setStatusFlag(status);
        setImageFlag(image);
    }

    private Boolean getFlag(String flagText, String trueText, String falseText) {
        Boolean flag = null;
        if (flagText.equals(trueText)) {
            flag = true;
        }
        if (flagText.equals(falseText)) {
            flag = false;
        }
        return flag;
    }

    private String setFlagText(Boolean flag, String trueText, String falseText) {
        String flagText;
        if (flag == null) {
            flagText = null;
        } else {
            if (flag) {
                flagText = trueText;
            } else {
                flagText = falseText;
            }
        }
        return flagText;
    }


}
