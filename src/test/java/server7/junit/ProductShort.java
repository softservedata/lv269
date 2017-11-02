package server7.junit;

/**
 * This class describes Product from the admin product list.
 * Every field represents a column.
 */
public class ProductShort {
    private String name;
    private String model;
    private String price;
    private String quantity;
    private Boolean statusFlag;
    private Boolean imageFlag;


    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }

    public String isEnable() {
        String returnedText = Credentials.ADM_PRODUCT_PG_STATUS_SLCT_NONVALUE_TXT
                .getChosenConstant();
        if (statusFlag) {
            returnedText = Credentials.ADM_PRODUCT_PG_STATUS_SLCT_VALUE_TRUE_TXT
                    .getChosenConstant();
        }
        if (!statusFlag) {
            returnedText = Credentials.ADM_PRODUCT_PG_STATUS_SLCT_VALUE_FALSE_TXT
                    .getChosenConstant();
        }
        return returnedText;
    }

    public String isImage() {
        String returnedText = Credentials.ADM_PRODUCT_PG_IMG_SLCT_NONVALUE_TXT
                .getChosenConstant();
        if (statusFlag) {
            returnedText = Credentials.ADM_PRODUCT_PG_IMG_SLCT_VALUE_TRUE_TXT
                    .getChosenConstant();
        }
        if (!statusFlag) {
            returnedText = Credentials.ADM_PRODUCT_PG_IMG_SLCT_VALUE_FALSE_TXT
                    .getChosenConstant();
        }
        return returnedText;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setStatusFlag(Boolean status) {
        this.statusFlag = status;
    }

    public void setImageFlag(Boolean imageFlag) {
        this.imageFlag = imageFlag;
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
