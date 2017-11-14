package com.softserve.edu.opencart.Data;

import com.softserve.edu.opencart.pages.TagAttribute;
import com.softserve.edu.opencart.tools.ErrorUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * This class describes Product from the admin productMap list.
 * Every field represents a column.
 */
public class ProductShort {

    private enum FieldNames {
        
        NAME ("name"),
        MODEL ("model"),
        PRICE ("price"),
        QUANTITY ("quantity"),
        STATUS ("status"),
        IMAGE ("image");
        
        private String field;

        FieldNames (String field) {
            this.field = field;
        }

        public String toString() {
            return field;
        }
    }
    private final String WRONG_TEXT_TO_SELECT_MESSAGE = "For object %s wrong text = %s was recieved)";

    //Fields
    private Map<String, String> productMap;

    public ProductShort() {
        productMap = new HashMap<>();
    }

    // GetData

    public Map<String, String> getProductMap() {
        return productMap;
    }

    //GetFunctional

    public String getName() {
        return getProductMap().get(FieldNames.NAME.toString());
    }

    public String getModel() {
        return getProductMap().get(FieldNames.MODEL.toString());
    }

    public String getPrice() {
        return getProductMap().get(FieldNames.PRICE.toString());
    }

    public String getQuantity() {
        return getProductMap().get(FieldNames.QUANTITY.toString());
    }

    public String getStatusText() {
        return getProductMap().get(FieldNames.STATUS.toString());
    }

    public Boolean getStatusFlag() {
        return getFlag(getProductMap().get(FieldNames.STATUS.toString()));
    }

    public Boolean getImageFlag() {
        return getFlag(getProductMap().get(FieldNames.IMAGE.toString()));
    }

    private Boolean getFlag(String flagText) {
        Boolean flag = null;
        if (flagText.toLowerCase().equals(TagAttribute.ENABLED.toString().toLowerCase())) {
            flag = true;
        }
        if (flagText.toLowerCase().equals(TagAttribute.DISABLED.toString().toLowerCase())) {
            flag = false;
        }
        return flag;
    }

    //SetData

    public void setName(String nameValue) {
        getProductMap().put(FieldNames.NAME.toString(), nameValue);
    }

    public void setModel(String modelValue) {
        getProductMap().put(FieldNames.MODEL.toString(), modelValue);
    }

    public void setPrice(String priceValue) {
        getProductMap().put(FieldNames.PRICE.toString(), priceValue);
    }

    public void setQuantity(String quantityValue) {
        getProductMap().put(FieldNames.QUANTITY.toString(), quantityValue);
    }

    public void setStatusText (String statusText) {
        ErrorUtils.createWrongTextToDropdown(!verifyBooleanText(statusText),
                String.format(WRONG_TEXT_TO_SELECT_MESSAGE, FieldNames.STATUS.toString(), statusText));
        getProductMap().put(FieldNames.STATUS.toString(), statusText);
    }

    public void setImageFlag(String imgText) {
        ErrorUtils.createWrongTextToDropdown(!verifyBooleanText(imgText),
                String.format(WRONG_TEXT_TO_SELECT_MESSAGE, FieldNames.IMAGE.toString(), imgText));
        getProductMap().put(FieldNames.STATUS.toString(), imgText);

    }

    private boolean verifyBooleanText (String text) {
        text = text.toLowerCase();
        return ((text.equals(TagAttribute.DISABLED.toString().toLowerCase())
                ||text.equals(TagAttribute.ENABLED.toString().toLowerCase())
                || text.isEmpty()));
    }
    //SetFunctional

    private String setFlagText(Boolean flag) {
        String flagText = "";
        if (flag != null) {
            if (flag) {
                flagText = TagAttribute.ENABLED.toString();
            } else {
                flagText = TagAttribute.DISABLED.toString();
            }
        }
        return flagText;
    }


    public void setStatusFlag(Boolean statusFlag) {
        getProductMap().put(FieldNames.STATUS.toString(), setFlagText(statusFlag));
    }

    public void setImageFlag(Boolean imgFlag) {
        getProductMap().put(FieldNames.IMAGE.toString(), setFlagText(imgFlag));
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
}
