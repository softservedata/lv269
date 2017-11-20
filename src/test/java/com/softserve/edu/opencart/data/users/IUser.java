package com.softserve.edu.opencart.data.users;

public interface IUser {

    String getFirstname();

    String getLastname();

    String getEmail();

    String getPhoneNumber();

    String getFax();

    String getCompany();

    String getAddressFirst();

    String getAddressSecond();

    String getCity();

    String getPostCode();

    String getCountry();

    String getRegion();

    String getPassword();

    boolean isSubscribe();

}
