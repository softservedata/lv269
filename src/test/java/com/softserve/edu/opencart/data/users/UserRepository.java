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
                .setEmail("email")
                .setPhoneNumber("phoneNumber")
                .setAddressFirst("addressFirst")
                .setCity("city")
                .setPostCode("postCode")
                .setCountry("country")
                .setRegion("region")
                .setPassword("password")
                .setAddressSecond("addressSecond")
                .setCompany("company")
                .setFax("fax")
                .setSubscribe(true)
                .build();
    }

    public IUser valid() {
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
    
    public IUser userKutaiev() {
        return User.get()
                .setFirstname("Olex")
                .setLastname("Really")
                .setEmail("mfj14401@sqoai.com")
                .setPhoneNumber("12345667890")
                .setAddressFirst("qwe/wqe/qwe")
                .setCity("Lviv")
                .setPostCode("12345")
                .setCountry("United Kingdom")
                .setRegion("Conwy")
                .setPassword("qwerty123456")
                .setAddressSecond("-")
                .setCompany("-")
                .setFax("-")
                .setSubscribe(false)
                .build();
    }

    public IUser userTestLogin() {
        return User.get()
                .setFirstname("FIRSTNAME")
                .setLastname("LASTNAME")
                .setEmail("lv_269_test@ukr.net")
                .setPhoneNumber("380511223344")
                .setAddressFirst("TEST_ADDRESS")
                .setCity("Lviv")
                .setPostCode("79000")
                .setCountry("Ukraine")
                .setRegion("L'vivs'ka Oblast'")
                .setPassword("269lv269lv")
                .setAddressSecond("-")
                .setCompany("-")
                .setFax("-")
                .setSubscribe(false)
                .build();
    }
    public IUser userTestWrongPassword() {
        return User.get()
                .setFirstname("FIRSTNAME")
                .setLastname("LASTNAME")
                .setEmail("test_wrong_login@email.com")
                .setPhoneNumber("380511223344")
                .setAddressFirst("TEST_ADDRESS")
                .setCity("Lviv")
                .setPostCode("79000")
                .setCountry("Ukraine")
                .setRegion("L'vivs'ka Oblast'")
                .setPassword("269lv269lvs")
                .setAddressSecond("-")
                .setCompany("-")
                .setFax("-")
                .setSubscribe(false)
                .build();
    }
    public IUser userTestCorectPassword() {
        return User.get()
                .setFirstname("FIRSTNAME")
                .setLastname("LASTNAME")
                .setEmail("test_wrong_login@email.com")
                .setPhoneNumber("380511223344")
                .setAddressFirst("TEST_ADDRESS")
                .setCity("Lviv")
                .setPostCode("79000")
                .setCountry("Ukraine")
                .setRegion("L'vivs'ka Oblast'")
                .setPassword("269lv269lv")
                .setAddressSecond("-")
                .setCompany("-")
                .setFax("-")
                .setSubscribe(false)
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
