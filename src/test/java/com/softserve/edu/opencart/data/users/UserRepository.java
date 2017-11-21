package com.softserve.edu.opencart.data.users;

import java.util.List;

public final class UserRepository {

    private static volatile UserRepository instance = null;

    private UserRepository() {
    }

    public static UserRepository get() {
        if (instance == null) {
            synchronized (UserRepository.class) {
                if (instance == null) {
                    instance = new UserRepository();
                }
            }
        }
        return instance;
    }

    public IUser admin() {
        return User.get()
                .setFirstname("firstname")
                .setLastname("lastname")
                .setEmail("admin")
                .setPhoneNumber("phoneNumber")
                .setAddressFirst("addressFirst")
                .setCity("city")
                .setPostCode("postCode")
                .setCountry("country")
                .setRegion("region")
                .setPassword("269lv269lv")
                .setAddressSecond("addressSecond")
                .setCompany("company")
                .setFax("fax")
                .setSubscribe(true)
                .build();
    }

    public IUser validUser() {
        return User.get()
                .setFirstname("firstname")
                .setLastname("lastname")
                .setEmail("jar@inboxbear.com")
                .setPhoneNumber("phoneNumber")
                .setAddressFirst("addressFirst")
                .setCity("city")
                .setPostCode("postCode")
                .setCountry("country")
                .setRegion("region")
                .setPassword("jarjar")
                .setAddressSecond("addressSecond")
                .setCompany("company")
                .setFax("fax")
                .setSubscribe(true)
                .build();
    }

    public IUser newUser() {
        // TODO
        return null;
    }

    public IUser invalid() {
        // TODO
        return null;
    }

    public List<IUser> fromCVSFile() {
        // TODO
        return null;
        // return new UserUtils(new CSVUtils("/existUsers.csv")).getAllUsers();
    }

    public List<IUser> fromExcelFile() {
        // TODO
        return null;
        // return new UserUtils(new ExcelUtils("/existUsers.xlsx")).getAllUsers();
    }

    // TODO
    public List<IUser> fromDB() {
        // TODO
        return null;
        //return new UserUtils(new ExcelUtils("/existUsers.xlsx")).getAllUsers();
    }
}
