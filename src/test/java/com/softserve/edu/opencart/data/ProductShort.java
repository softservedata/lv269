package com.softserve.edu.opencart.data;

import com.softserve.edu.opencart.pages.TagAttribute;
import com.softserve.edu.opencart.tools.ErrorUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * This class describes Product from the admin productMap list.
 * Every field represents a column.
 */
public class ProductShort {

    private final String WRONG_TEXT_TO_SELECT_MESSAGE = "For object %s wrong text = %s was recieved)";
    private final String WRONG_STRING_RECIEVED_AS_PRODUCT_PARAMETERS
            = "For ProductShort wrong string with parameters = %s and delimiter = %s was recieved";

    private final int NUMBER_OF_PARAMETERS = 6;

    //Fields
    private Map<String, String> productMap;

    public ProductShort() {
        initProductMap();
    }

    public ProductShort(String listOfParameters, String delimiter) {
        initProductMap();
        initProductShortFromString(listOfParameters, delimiter);
    }

    private void initProductShortFromString(String parameters, String delimiter) {
        String[] parametersArray = parameters.split(delimiter);
        ErrorUtils.createWrongStringStructureException((parametersArray.length != NUMBER_OF_PARAMETERS),
                String.format(WRONG_STRING_RECIEVED_AS_PRODUCT_PARAMETERS, parameters, delimiter));
        this.setName(parametersArray[0])
                .setModel(parametersArray[1])
                .setPrice(parametersArray[2])
                .setQuantity(parametersArray[3])
                .setStatusFlag(parametersArray[4])
                .setImageFlag(parametersArray[5]);

    }

    private void initProductMap() {
        productMap = new HashMap<>();
        setName("");
        setModel("");
        setPrice("");
        setImageFlag("");
        setStatusFlag("");

    }

    // GetData

    public Map<String, String> getProductMap() {
        return productMap;
    }

    //GetFunctional

    public String getName() {
        return getProductMap().get(TagAttribute.PRODUCT_NAME.toString());
    }

    public String getModel() {
        return getProductMap().get(TagAttribute.MODEL.toString());
    }

    public String getPrice() {
        return getProductMap().get(TagAttribute.PRICE.toString());
    }

    public String getQuantity() {
        return getProductMap().get(TagAttribute.QUANTITY.toString());
    }

    public String getStatusText() {
        return getProductMap().get(TagAttribute.STATUS.toString());
    }

    public String getImageText() {
        return getProductMap().get(TagAttribute.IMAGE.toString());
    }

    public Boolean getStatusFlag() {
        return getFlag(getProductMap().get(TagAttribute.STATUS.toString()));
    }

    public Boolean getImageFlag() {
        return getFlag(getProductMap().get(TagAttribute.IMAGE.toString()));
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

    public ProductShort setName(String nameValue) {
        getProductMap().put(TagAttribute.PRODUCT_NAME.toString(), nameValue);
        return this;
    }

    public ProductShort setModel(String modelValue) {
        getProductMap().put(TagAttribute.MODEL.toString(), modelValue);
        return this;
    }

    public ProductShort setPrice(String priceValue) {
        getProductMap().put(TagAttribute.PRICE.toString(), priceValue);
        return this;
    }

    public ProductShort setQuantity(String quantityValue) {
        getProductMap().put(TagAttribute.QUANTITY.toString(), quantityValue);
        return this;
    }

    public ProductShort setStatusFlag(String statusText) {
        ErrorUtils.createWrongTextToDropdown(!verifyBooleanText(statusText),
                String.format(WRONG_TEXT_TO_SELECT_MESSAGE, TagAttribute.STATUS.toString(), statusText));
        getProductMap().put(TagAttribute.STATUS.toString(), statusText);
        return this;
    }

    public ProductShort setImageFlag(String imgText) {
        ErrorUtils.createWrongTextToDropdown(!verifyBooleanText(imgText),
                String.format(WRONG_TEXT_TO_SELECT_MESSAGE, TagAttribute.IMAGE.toString(), imgText));
        getProductMap().put(TagAttribute.IMAGE.toString(), imgText);
        return this;
    }

    private boolean verifyBooleanText(String text) {
        text = text.toLowerCase();
        return ((text.equals(TagAttribute.DISABLED.toString().toLowerCase())
                || text.equals(TagAttribute.ENABLED.toString().toLowerCase())
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


    public ProductShort setStatusFlag(Boolean statusFlag) {
        getProductMap().put(TagAttribute.STATUS.toString(), setFlagText(statusFlag));
        return this;
    }

    public ProductShort setImageFlag(Boolean imgFlag) {
        getProductMap().put(TagAttribute.IMAGE.toString(), setFlagText(imgFlag));
        return this;
    }

    public boolean isEqualToOtherProductShort(ProductShort productShort) {
        return (productShort.getProductMap().equals(getProductMap()));
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
