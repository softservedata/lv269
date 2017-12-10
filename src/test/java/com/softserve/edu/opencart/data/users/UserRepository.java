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

    public IUser userZvarych(){
        return User.get()
                .setFirstname("Mirek")
                .setLastname("Zvarych")
                .setEmail("mirekzvar@gmail.com")
                .setPhoneNumber("000000")
                .setAddressFirst("Naukova")
                .setCity("Lviv")
                .setPostCode("7902")
                .setCountry("Ukraine")
                .setRegion("L'vivs'ka Oblast'")
                .setPassword("vitochka24")
                .setAddressSecond("Volodymyra Velykogo")
                .setCompany("Softserve.edu")
                .setFax("000")
                .setSubscribe(false)
                .build();

    }

    public IUser userWithoutName(){
        return User.get()
                .setFirstname("")
                .setLastname("Zvarych")
                .setEmail("WithoutName")
                .setPhoneNumber("000000")
                .setAddressFirst("Naukova")
                .setCity("Lviv")
                .setPostCode("7902")
                .setCountry("Ukraine")
                .setRegion("L'vivs'ka Oblast'")
                .setPassword("vitochka24")
                .setAddressSecond("Volodymyra Velukogo")
                .setCompany("Softserve.edu")
                .setFax("000")
                .setSubscribe(false)
                .build();

    }
    public IUser userWithoutLastName(){
        return User.get()
                .setFirstname("Mirek")
                .setLastname("")
                .setEmail("WithoutLastName")
                .setPhoneNumber("000000")
                .setAddressFirst("Naukova")
                .setCity("Lviv")
                .setPostCode("7902")
                .setCountry("Ukraine")
                .setRegion("L'vivs'ka Oblast'")
                .setPassword("vitochka24")
                .setAddressSecond("Volodymyra Velukogo")
                .setCompany("Softserve.edu")
                .setFax("000")
                .setSubscribe(false)
                .build();

    }
    public IUser userWithoutAddress(){
        return User.get()
                .setFirstname("Mirek")
                .setLastname("Zvarych")
                .setEmail("WithoutAddress")
                .setPhoneNumber("000000")
                .setAddressFirst("")
                .setCity("Lviv")
                .setPostCode("7902")
                .setCountry("Ukraine")
                .setRegion("L'vivs'ka Oblast'")
                .setPassword("vitochka24")
                .setAddressSecond("Volodymyra Velukogo")
                .setCompany("Softserve.edu")
                .setFax("000")
                .setSubscribe(false)
                .build();

    }
    public IUser userWithoutCity(){
        return User.get()
                .setFirstname("Mirek")
                .setLastname("Zvarych")
                .setEmail("WithoutCity")
                .setPhoneNumber("000000")
                .setAddressFirst("Naukova")
                .setCity("")
                .setPostCode("7902")
                .setCountry("Ukraine")
                .setRegion("L'vivs'ka Oblast'")
                .setPassword("vitochka24")
                .setAddressSecond("Volodymyra Velukogo")
                .setCompany("Softserve.edu")
                .setFax("000")
                .setSubscribe(false)
                .build();

    }
    public IUser userWithoutCountry(){
        return User.get()
                .setFirstname("Mirek")
                .setLastname("Zvarych")
                .setEmail("WithoutCountry")
                .setPhoneNumber("000000")
                .setAddressFirst("Naukova")
                .setCity("Lviv")
                .setPostCode("7902")
                .setCountry("--- Please Select ---")
                .setRegion("--- None ---")
                .setPassword("vitochka24")
                .setAddressSecond("Volodymyra Velukogo")
                .setCompany("Softserve.edu")
                .setFax("000")
                .setSubscribe(false)
                .build();

    }
    public IUser userWithoutRegion(){
        return User.get()
                .setFirstname("Mirek")
                .setLastname("Zvarych")
                .setEmail("WithoutRegion")
                .setPhoneNumber("000000")
                .setAddressFirst("Naukova")
                .setCity("Lviv")
                .setPostCode("7902")
                .setCountry("Ukraine")
                .setRegion("--- Please Select ---")
                .setPassword("vitochka24")
                .setAddressSecond("Volodymyra Velukogo")
                .setCompany("Softserve.edu")
                .setFax("000")
                .setSubscribe(false)
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
    public IUser userUnknown() {
        return User.get()
                .setFirstname("FIRSTNAME")
                .setLastname("LASTNAME")
                .setEmail("qwert@email.com")
                .setPhoneNumber("380511223344")
                .setAddressFirst("TEST_ADDRESS")
                .setCity("Lviv")
                .setPostCode("79000")
                .setCountry("Ukraine")
                .setRegion("L'vivs'ka Oblast'")
                .setPassword("2qwertyt")
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
