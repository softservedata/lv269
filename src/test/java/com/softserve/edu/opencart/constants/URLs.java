package com.softserve.edu.opencart.constants;

/**
 * enum with url, credentials, paths,  parameters for drivers,
 * values...
 */
public enum URLs {
    URL_SERVER("http://server7.pp.ua/"),
    URL_ADMIN_PAGE("admin/"),
    URL_LOGOUTED_PART("common/login"),
    URL_SETTING("index.php?route=setting/store&token" +
            "=dk7Vj8Zl94QRLl9V3aE22aQ4NvUigXZv"),
    URL_PRODUCT_PG("index.php?route=catalog/" +
            "product&token=giuFK45gup5AuVh6h1weuTb7ZqbxvlFa"),
    ADM_PRODUCT_PG_DFLT_IMAGE_ADDRESS_SMALL ("image/cache/no_image-40x40.png");

    private String chosen;

    URLs(String choice) {
        chosen = choice;
    }

    public String toString() {
        return chosen;
    }
    }
