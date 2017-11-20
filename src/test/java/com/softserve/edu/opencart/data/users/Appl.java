package com.softserve.edu.opencart.data.users;

public class Appl {
    public static void main(String[] args) {
        IUser user = UserRepository.get().admin();
        System.out.println("email = " + user.getEmail());
    }
}
