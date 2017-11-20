package com.softserve.edu.opencart.data.users;

interface IFirstname {
    ILastname setFirstname(String firstname);
}

interface ILastname {
    IEmail setLastname(String lastname);
}

interface IEmail {
    IPhoneNumber setEmail(String email);
}

interface IPhoneNumber {
    IAddressFirst setPhoneNumber(String phoneNumber);
}

interface IAddressFirst {
    ICity setAddressFirst(String addressFirst);
}

interface ICity {
    IPostCode setCity(String city);
}

interface IPostCode {
    ICountry setPostCode(String postCode);
}

interface ICountry {
    IRegion setCountry(String country);
}

interface IRegion {
    IPassword setRegion(String region);
}

interface IPassword {
    IUserBuild setPassword(String password);
}

interface IUserBuild {
    IUserBuild setFax(String fax);

    IUserBuild setCompany(String company);

    IUserBuild setAddressSecond(String addressSecond);

    IUserBuild setSubscribe(boolean subscribe);

    IUser build();
}

public class User implements IFirstname, ILastname, IEmail, IPhoneNumber, IAddressFirst,
                             ICity, IPostCode, ICountry, IRegion, IPassword, IUserBuild, IUser {

    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private String fax; // optional
    private String company; // optional
    private String addressFirst;
    private String addressSecond; // optional
    private String city;
    private String postCode;
    private String country;
    private String region;
    private String password;
    private boolean subscribe; // optional

    private User() {
    }

    public static IFirstname get() {
        return new User();
    }

    // setters

    public ILastname setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public IEmail setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public IPhoneNumber setEmail(String email) {
        this.email = email;
        return this;
    }

    public IAddressFirst setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public IUserBuild setFax(String fax) {
        this.fax = fax;
        return this;
    }

    public IUserBuild setCompany(String company) {
        this.company = company;
        return this;
    }

    public ICity setAddressFirst(String addressFirst) {
        this.addressFirst = addressFirst;
        return this;
    }

    public IUserBuild setAddressSecond(String addressSecond) {
        this.addressSecond = addressSecond;
        return this;
    }

    public IPostCode setCity(String city) {
        this.city = city;
        return this;
    }

    public ICountry setPostCode(String postCode) {
        this.postCode = postCode;
        return this;
    }

    public IRegion setCountry(String country) {
        this.country = country;
        return this;
    }

    public IPassword setRegion(String region) {
        this.region = region;
        return this;
    }

    public IUserBuild setPassword(String password) {
        this.password = password;
        return this;
    }

    public IUserBuild setSubscribe(boolean subscribe) {
        this.subscribe = subscribe;
        return this;
    }


    public IUser build() {
        return this;
    }
    
    // getters

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFax() {
        return fax;
    }

    public String getCompany() {
        return company;
    }

    public String getAddressFirst() {
        return addressFirst;
    }

    public String getAddressSecond() {
        return addressSecond;
    }

    public String getCity() {
        return city;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    public String getPassword() {
        return password;
    }

    public boolean isSubscribe() {
        return subscribe;
    }

}
