package com.softserve.edu.opencart.data.users;

public class Appl {
    public static void main(String[] args) {
        // 1. Use Constructor for POJO class
        // User user = new User("firstname", "lastname", "email", "phoneNumber",
        // "fax", "company", "addressFirst", "addressSecond", "city",
        // "postCode", "country", "region", "password", true);
        // System.out.println("email = " + user.getEmail());
        //
        // 2. Use Default Constructor and setters
        // User user = new User();
        // user.setFirstname("firstname");
        // user.setLastname("lastname");
        // user.setEmail("email");
        // user.setPhoneNumber("phoneNumber");
        // user.setFax("fax");
        // user.setCompany("company");
        // user.setAddressFirst("addressFirst");
        // user.setAddressSecond("addressSecond");
        // user.setCity("city");
        // user.setPostCode("postCode");
        // user.setCountry("country");
        // user.setRegion("region");
        // user.setPassword("password");
        // user.setSubscribe(true);
        // System.out.println("email = " + user.getEmail());
        //
        // 3. Use Default Constructor and Fluent Interface
        // User user = new User()
        // .setFirstname("firstname")
        // .setLastname("lastname")
        // .setEmail("email")
        // .setPhoneNumber("phoneNumber")
        // .setFax("fax")
        // .setCompany("company")
        // .setAddressFirst("addressFirst")
        // .setAddressSecond("addressSecond")
        // .setCity("city")
        // .setPostCode("postCode")
        // .setCountry("country")
        // .setRegion("region")
        // .setPassword("password")
        // .setSubscribe(true);
        // System.out.println("email = " + user.getEmail());
        //
        // 4. Use Static Factory and Fluent Interface
//        User user = User.get()
//                .setFirstname("firstname")
//                .setLastname("lastname")
//                .setEmail("email")
//                .setPhoneNumber("phoneNumber")
//                .setFax("fax")
//                .setCompany("company")
//                .setAddressFirst("addressFirst")
//                .setAddressSecond("addressSecond")
//                .setCity("city")
//                .setPostCode("postCode")
//                .setCountry("country")
//                .setRegion("region")
//                .setPassword("password")
//                .setSubscribe(true);
//        System.out.println("email = " + user.getEmail());
        //
        // 5. Use Builder
//        User user = User.get()
//                .setFirstname("firstname")
//                .setLastname("lastname")
//                .setEmail("email")
//                .setPhoneNumber("phoneNumber")
//                .setAddressFirst("addressFirst")
//                .setCity("city")
//                .setPostCode("postCode")
//                .setCountry("country")
//                .setRegion("region")
//                .setPassword("password")
//                .setAddressSecond("addressSecond")
//                .setCompany("company")
//                .setFax("fax")
//                .setSubscribe(true)
//                .build();
//        System.out.println("email = " + user.setEmail("1111"));
//        System.out.println("email = " + user.getEmail());
        //
        // 6. Use Dependency Inversion
//        IUser user = User.get()
//                .setFirstname("firstname")
//                .setLastname("lastname")
//                .setEmail("email")
//                .setPhoneNumber("phoneNumber")
//                .setAddressFirst("addressFirst")
//                .setCity("city")
//                .setPostCode("postCode")
//                .setCountry("country")
//                .setRegion("region")
//                .setPassword("password")
//                .setAddressSecond("addressSecond")
//                .setCompany("company")
//                .setFax("fax")
//                .setSubscribe(true)
//                .build();
        //System.out.println("email = " + ((User)user).setEmail("1111"));
//        System.out.println("email = " + user.getEmail());
        //
        // 7-8. Use Singleton and Repository
        IUser user = UserRepository.get().admin();
        System.out.println("email = " + user.getEmail());
    }
}
